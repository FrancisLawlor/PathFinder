import React, { Component } from "react";
import Square from "./Square";

class Grid extends Component {
  renderSquare(i, coord) {
    return (
      <Square
        key={i}
        value={this.props.squares[i]}
        onClick={() => this.props.onClick(i, coord)}
      />
    );
  }

  createGrid(height, width) {
    let grid = [];
    let id = 0;

    for (let i = 0; i < height; i++) {
      let row = [];
      for (let j = 0; j < width; j++) {
        let coord = { row: i, col: j };
        row.push(this.renderSquare(id, coord));
        id += 1;
      }
      grid.push(
        <div className="grid-row" key={id}>
          {row}
        </div>
      );
    }

    return grid;
  }

  render() {
    return <div>{this.createGrid(this.props.height, this.props.width)}</div>;
  }
}

export default Grid;
