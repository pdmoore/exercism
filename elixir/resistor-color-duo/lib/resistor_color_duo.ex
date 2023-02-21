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
    # if param is a list, access head | tail?
    [head1 | tail] = colors
    [head2 | _] = tail
#    first = color_value[List.first(colors)]
    first = color_value[head1]
    second = color_value[head2]
    String.to_integer(Integer.to_string(first) <> Integer.to_string(second))
  end
end
