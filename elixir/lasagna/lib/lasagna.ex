defmodule Lasagna do
  # Please define the 'expected_minutes_in_oven/0' function
  def expected_minutes_in_oven(), do: 40

  # Please define the 'remaining_minutes_in_oven/1' function
  def remaining_minutes_in_oven(actual_minutes) do
    expected_minutes_in_oven() - actual_minutes
  end

  # Please define the 'preparation_time_in_minutes/1' function
  def preparation_time_in_minutes(number_of_layers) do
    minutes_per_layer = 2;
    minutes_per_layer * number_of_layers
  end

  # Please define the 'total_time_in_minutes/2' function

  # Please define the 'alarm/0' function
end
