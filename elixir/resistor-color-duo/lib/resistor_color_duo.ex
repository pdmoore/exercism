defmodule ResistorColorDuo do
  @color_value %{
    black:  0,
    brown:  1,
    red:    2,
    orange: 3,
    yellow: 4,
    green:  5,
    blue:   6,
    violet: 7,
    grey:   8,
    white:  9
  }

  @doc """
  Calculate a resistance value from two colors
  """
  @spec value(colors :: [atom]) :: integer
  def value(colors) do
    [band_1 | tail] = colors
    [band_2 | _] = tail
    first_digit  = @color_value[band_1]
    second_digit = @color_value[band_2]
    two_digits_combined_as_string = Integer.to_string(first_digit) <> Integer.to_string(second_digit)
    String.to_integer(two_digits_combined_as_string)
  end
end
