import React, { Component } from "react";
import Grid from "./Grid";
import "./Maze.css";
import DimensionInput from "./DimensionInput";

class Maze extends Component {
  constructor(props) {
    super(props);
    let height = 5;
    let width = 6;
    this.state = {
      squares: Array(height * width).fill(null),
      height: height,
      width: width,
      coords: {
        start: { row: null, col: null },
        end: { row: null, col: null },
        obstacles: []
      },
      algorithm: "",
      startPlaced: false,
      endPlaced: false
    };
  }

  handleSquareClick(i, coord) {
    const squares = this.state.squares.slice();

    if (!this.state.startPlaced || !this.state.endPlaced) {
      let marker = "S";
      let updatedCoord = {
        start: coord,
        end: this.state.coords.end,
        obstacles: this.state.coords.obstacles
      };
      if (!this.state.startPlaced) {
        this.setState({ startPlaced: true });
      } else {
        this.setState({ endPlaced: true });
        marker = "E";
        updatedCoord = {
          start: this.state.coords.start,
          end: coord,
          obstacles: this.state.coords.obstacles
        };
      }
      squares[i] = marker;
      this.setState({ squares: squares });
      this.setState({ coords: updatedCoord });
    } else {
      if (this.state.squares[i] === null) {
        squares[i] = "X";
        this.setState({
          coords: {
            start: this.state.coords.start,
            end: this.state.coords.end,
            obstacles: this.state.coords.obstacles.concat([coord])
          }
        });
      } else if (this.state.squares[i] === "X") {
        squares[i] = null;
        this.setState({
          coords: {
            start: this.state.coords.start,
            end: this.state.coords.end,
            obstacles: this.state.coords.obstacles.filter(
              item => item.col !== coord.col || item.row !== coord.row
            )
          }
        });
      }
      this.setState({ squares: squares });
    }
  }

  postCoordinates() {
    fetch("http://localhost:8080/calculate_path", {
      method: "post",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        height: this.state.height,
        width: this.state.width,
        coords: this.state.coords,
        algorithm: this.state.algorithm
      })
    })
      .then(response => response.json())
      .then(data => {
        this.setState({ squares: this.setPathSquares(data.path_squares) });
      });
  }

  setPathSquares(path_squares) {
    let squares = this.state.squares;

    for (let i = 0; i < path_squares.length; i++) {
      let index = path_squares[i].row * this.state.width + path_squares[i].col;
      squares[index] = "P";
    }
    return squares;
  }

  render() {
    return (
      <div className="maze">
        <Grid
          squares={this.state.squares.slice()}
          width={this.state.width}
          height={this.state.height}
          coords={this.state.coords}
          onClick={(i, coord) => this.handleSquareClick(i, coord)}
        />
        <button
          disabled={!this.state.startPlaced || !this.state.endPlaced}
          onClick={() => this.postCoordinates()}
        >
          Post Coordinates
        </button>
        <select
          id="algorithm_dropdown"
          onChange={() => {
            this.setState({
              algorithm: document.getElementById("algorithm_dropdown").value
            });
          }}
        >
          <option value="depth_first_search">Depth First Search</option>
          <option value="breadth_first_search">Breadth First Search</option>
        </select>

        <DimensionInput />
      </div>
    );
  }

  componentDidMount() {
    this.setState({
      algorithm: document.getElementById("algorithm_dropdown").value
    });
  }
}

export default Maze;
