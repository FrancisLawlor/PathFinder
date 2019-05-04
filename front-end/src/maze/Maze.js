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
        end: { row: null, col: null }
      },
      startPlaced: false,
      endPlaced: false
    };
  }

  handleSquareClick(i, coord) {
    if (!this.state.startPlaced || !this.state.endPlaced) {
      let marker = "S";
      let updatedCoord = {
        start: { row: coord.row, col: coord.col },
        end: { row: this.state.coords.end.row, col: this.state.coords.end.col }
      };
      if (!this.state.startPlaced) {
        this.setState({ startPlaced: true });
      } else {
        this.setState({ endPlaced: true });
        marker = "E";
        updatedCoord = {
          start: {
            row: this.state.coords.start.row,
            col: this.state.coords.start.col
          },
          end: {
            row: coord.row,
            col: coord.col
          }
        };
      }
      const squares = this.state.squares.slice();
      squares[i] = marker;
      this.setState({ squares: squares });
      this.setState({ coords: updatedCoord });
    }
  }

  postCoordinates() {
    // post coordinates
    alert("coords: " + JSON.stringify(this.state.coords));
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
