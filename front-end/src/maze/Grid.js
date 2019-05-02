import React, { Component } from "react";
import Square from "./Square";

class Grid extends Component {
  renderSquare(i) {
    return <Square value={i} />;
  }

  createGrid(height, width) {
    let grid = [];

    for (let i = 0; i < height; i++) {
      let row = [];
      for (let j = 0; j < width; j++) {
        row.push(this.renderSquare(j));
      }
      grid.push(<div className="grid-row">{row}</div>);
    }

    return grid;
  }

  render() {
    return <div>{this.createGrid(this.props.height, this.props.width)}</div>;
  }
}

export default Grid;
