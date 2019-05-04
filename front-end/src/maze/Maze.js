import React, { Component } from "react";
import Grid from "./Grid";
import "./Maze.css";

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
    // post coordinates
    fetch("http://localhost:3004/calculated_path_response", {
      method: "post",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(this.state.coords)
    })
      .then(response => response.json())
      .then(data => alert(JSON.stringify(data)));
    // alert("coords: " + JSON.stringify(this.state.coords));
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
      </div>
    );
  }
}

export default Maze;
