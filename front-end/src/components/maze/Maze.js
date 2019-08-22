import React, { Component } from "react";
import Grid from "./Grid";
import "./Maze.css";
import DimensionInput from "./DimensionInput";
import HTTPClient from "../../api/HTTPClient.js";

class Maze extends Component {
  constructor(props) {
    super(props);
    const height = 6;
    const width = 6;
    this.state = {
      squares: Array(height * width).fill(null),
      height: height,
      width: width,
      coords: {
        start: { row: null, col: null },
        end: { row: null, col: null },
        obstacles: []
      },
      instructionalMessage:
        "Choose dimensions for the grid using the sliders on the left.",
      algorithms: [],
      algorithm: "",
      startPlaced: false,
      endPlaced: false,
      pathReceived: false
    };
  }

  placeCoordinate(squares, i, marker, updatedCoordinates) {
    squares[i] = marker;
    this.setState({ squares: squares, coords: updatedCoordinates });
  }

  handleSquareClick(i, coord) {
    const squares = this.state.squares;

    if (!this.state.startPlaced) {
      let updatedCoord = {
        start: coord,
        end: this.state.coords.end,
        obstacles: this.state.coords.obstacles
      };
      this.placeCoordinate(squares, i, "S", updatedCoord);
      this.setState({
        startPlaced: true,
        instructionalMessage: "Place the end point on the grid!"
      });
    } else if (!this.state.endPlaced) {
      let updatedCoord = {
        start: this.state.coords.start,
        end: coord,
        obstacles: this.state.coords.obstacles
      };
      this.placeCoordinate(squares, i, "E", updatedCoord);
      this.setState({
        endPlaced: true,
        instructionalMessage: "Place some obstacles on grid!"
      });
    } else {
      if (!this.state.pathReceived) {
        let updatedCoord = {
          start: this.state.coords.start,
          end: this.state.coords.end
        };
        if (this.state.squares[i] === null) {
          updatedCoord["obstacles"] = this.state.coords.obstacles.concat([
            coord
          ]);
          this.placeCoordinate(squares, i, "X", updatedCoord);
        } else if (this.state.squares[i] === "X") {
          updatedCoord["obstacles"] = this.state.coords.obstacles.filter(
            item => item.col !== coord.col || item.row !== coord.row
          );
          this.placeCoordinate(squares, i, null, updatedCoord);
        }
      }
      this.setState({ squares: squares });
    }
  }

  postCoordinates() {
    let body = {
      height: this.state.height,
      width: this.state.width,
      coords: this.state.coords,
      algorithm: this.state.algorithm
    };

    HTTPClient.postRequest("http://localhost/calculate_path", body).then(
      data => {
        this.setState({
          squares: this.setPathSquares(data.path_squares),
          pathReceived: true,
          instructionalMessage: `Here is the path for ${this.state.algorithm}!`
        });
      }
    );
  }

  getAlgorithms() {
    HTTPClient.getRequest("http://localhost/algorithms").then(data => {
      this.setState({
        algorithms: data.algorithms,
        algorithm: data.algorithms[0]
      });
    });
  }

  setPathSquares(path_squares) {
    let squares = this.state.squares;

    for (let i = 1; i < path_squares.length - 1; i++) {
      let index = path_squares[i].row * this.state.width + path_squares[i].col;
      squares[index] = "" + i;
    }
    return squares;
  }

  setStateDuringOnChange(field, value) {
    let otherDimension =
      field === "width" ? this.state.height : this.state.width;

    this.setState({
      [field]: value,
      squares: Array(value * otherDimension).fill(null)
    });
  }

  disableGridCreationInputs = () => {
    this.setState({
      gridIsCreated: true,
      instructionalMessage: "Place the starting point on the grid!"
    });
  };

  componentDidMount() {
    this.getAlgorithms();
  }

  render() {
    return (
      <div className="maze">
        <div className="dimensionInput">
          <DimensionInput
            onChange={(field, value) =>
              this.setStateDuringOnChange(field, value)
            }
            height={this.state.height}
            width={this.state.width}
            gridIsCreated={this.state.gridIsCreated}
            onCreateGridClick={this.disableGridCreationInputs}
          />
        </div>
        <div className={this.state.gridIsCreated ? "grid-visible" : ""}>
          <p>{this.state.instructionalMessage}</p>
          <div
            className={
              this.state.gridIsCreated ? "grid-visible" : "grid-invisible"
            }
          >
            <Grid
              className={
                this.state.gridIsCreated ? "grid-visible" : "grid-invisible"
              }
              squares={this.state.squares}
              width={this.state.width}
              height={this.state.height}
              coords={this.state.coords}
              onClick={(i, coord) => this.handleSquareClick(i, coord)}
            />
            <button
              disabled={
                !this.state.startPlaced ||
                !this.state.endPlaced ||
                this.state.pathReceived
              }
              onClick={() => this.postCoordinates()}
            >
              See Path
            </button>
            <select
              disabled={this.state.pathReceived || !this.state.gridIsCreated}
              defaultValue={this.state.algorithm}
              id="algorithm_dropdown"
              onChange={event => {
                this.setState({
                  algorithm: event.target.value
                });
              }}
            >
              {this.state.algorithms.map((algorithm, i) => {
                return <option key={i++}>{algorithm}</option>;
              })}
            </select>
          </div>
        </div>
      </div>
    );
  }
}

export default Maze;
