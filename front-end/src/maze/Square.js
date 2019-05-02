import React, { Component } from "react";

class Square extends Component {
  render() {
    return <button className="square">{this.props.value}</button>;
  }
}

export default Square;
