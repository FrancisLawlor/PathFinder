import React, { Component } from "react";
import Grid from "./Grid";
import "./Maze.css";

class Maze extends Component {
  constructor(props) {
    super(props);
    this.state = {
      squares: Array(9).fill(null),
      height: 5,
      width: 5,
      coords: []
    };
  }

  render() {
    return (
      <div className="maze">
        <Grid
          squares={this.state.squares.slice()}
          width={this.state.width}
          height={this.state.height}
          coords={this.state.coords}
        />
      </div>
    );
  }

  componentDidMount() {
    console.log(this.state.coords)
  }
}

export default Maze;
