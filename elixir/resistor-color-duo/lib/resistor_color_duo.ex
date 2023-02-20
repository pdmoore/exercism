defmodule ResistorColorDuo do
  @doc """
  Calculate a resistance value from two colors
  """
  @spec value(colors :: [atom]) :: integer
  def value(colors) do
# [:brown, :black]

    color_value = %{
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
#    fn color_value[:brown], color_value[:black] -> "#{x}#{y}" end

    # TODO - combine first and second of colors param to form "10"

    String.to_integer(Integer.to_string(color_value[:brown]) <> Integer.to_string(color_value[:black]))

#    elem(Integer.parse("10"), 0)
  end
end
