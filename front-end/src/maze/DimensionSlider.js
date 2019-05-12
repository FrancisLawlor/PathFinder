import React, { Component } from "react";

class DimensionSlider extends Component {
  constructor(props) {
    super(props);
    this.state = { value: this.props.value };
  }

  render() {
    return (
      <div>
        <p>{this.props.label}</p>
        <input
          onChange={event => {
            this.setState({ value: event.target.value });
            this.props.onChange(
              this.props.state_field_name,
              event.target.value
            );
          }}
          id={this.props.id}
          type="range"
          min={this.props.min}
          max={this.props.max}
          value={this.state.value}
        />
        <p>{this.state.value}</p>
      </div>
    );
  }
}

export default DimensionSlider;
