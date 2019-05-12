import React, { Component } from "react";
import DimensionSlider from "./DimensionSlider";

class DimensionInput extends Component {
  render() {
    return (
      <div>
        <DimensionSlider
          label="Width"
          value={this.props.width}
          id="width_slider"
          min="2"
          max="15"
          state_field_name="width"
          onChange={(field, value) => this.props.onChange(field, value)}
        />
        <DimensionSlider
          label="Height"
          value={this.props.height}
          id="height_slider"
          min="2"
          max="15"
          state_field_name="height"
          onChange={(field, value) => this.props.onChange(field, value)}
        />
        <button onClick={this.props.onCreateGridClick}>Create Grid</button>
      </div>
    );
  }
}

export default DimensionInput;
