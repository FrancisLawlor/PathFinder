import React, { Component } from "react";

class DimensionSlider extends Component {
  constructor(props) {
    super(props);
    this.state = { width_value: this.props.width_value };
  }

  render() {
    return (
      <div>
        <p>{this.props.label}</p>
        <input
          onChange={event => {
            this.setState({ width_value: event.target.value });
          }}
          id={this.props.id}
          type="range"
          min={this.props.min}
          max={this.props.max}
          value={this.state.width_value}
        />
        <p>{this.state.width_value}</p>
      </div>
    );
  }
}

export default DimensionSlider;
