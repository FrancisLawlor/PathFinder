import React, { Component } from "react";
import DimensionSlider from "./DimensionSlider";

class DimensionInput extends Component {
  constructor(props) {
    super(props);
    this.state = { width_slider: 6 };
  }

  render() {
    return (
      <div>
        <DimensionSlider
          label="Width"
          width_value="6"
          id="width_slider"
          min="2"
          max="15"
          state_field_name="width"
          onChange={(field, value) => this.props.onChange(field, value)}
        />

        <DimensionSlider
          label="Height"
          width_value="6"
          id="height_slider"
          min="2"
          max="15"
          state_field_name="height"
          onChange={(field, value) => this.props.onChange(field, value)}
        />
      </div>
    );
  }
}

export default DimensionInput;
