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
  def value([band_1, band_2 | _]) do
    tens = @color_value[band_1] * 10
    ones = @color_value[band_2]
    tens + ones
  end
end
