defmodule ResistorColor do
  @doc """
  Return the value of a color band
  """
  @spec code(atom) :: integer()
  def code(:orange), do: 3
  def code(:yellow), do: 4
  def code(:green),  do: 5
  def code(:blue),   do: 6
  def code(:violet), do: 7
  def code(:grey),   do: 8
  def code(:white),  do: 9

  def code(color) do
    color_value = %{
      black:  0,
      brown:  1,
      red:    2
    }
    color_value[color]
  end
end
