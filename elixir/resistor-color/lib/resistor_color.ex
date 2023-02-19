defmodule ResistorColor do
  @doc """
  Return the value of a color band
  """
  @spec code(atom) :: integer()
  def code(:black), do: 0
  def code(color) do
    0
  end
end
