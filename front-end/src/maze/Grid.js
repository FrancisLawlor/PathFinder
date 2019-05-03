import React, { Component } from "react";
import Square from "./Square";

class Grid extends Component {
  renderSquare(coord) {
    return <Square coord={coord} />;
  }

  createGrid(height, width) {
    let grid = [];

    for (let i = 0; i < height; i++) {
      let row = [];
      for (let j = 0; j < width; j++) {
        let coord = {row: i, col: j}
        row.push(this.renderSquare(coord));
        this.props.coords.push(coord)
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
