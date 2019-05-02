import React, { Component } from "react";
import Grid from "./Grid";
import "./Maze.css";

class Maze extends Component {
  constructor(props) {
    super(props);
    this.state = {
      squares: Array(9).fill(null),
      height: 5,
      width: 5
    };
  }

  render() {
    return (
      <div className="maze">
        <Grid
          squares={this.state.squares.slice()}
          width={this.state.width}
          height={this.state.height}
        />
      </div>
    );
  }
}

export default Maze;
