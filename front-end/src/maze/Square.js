import React, { Component } from "react";

class Square extends Component {
  render() {
    return <button className="square">({this.props.coord.row}, {this.props.coord.col})</button>;
  }
}

export default Square;
