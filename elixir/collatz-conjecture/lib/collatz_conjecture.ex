require Integer
defmodule CollatzConjecture do
  @doc """
  calc/1 takes an integer and returns the number of steps required to get the
  number to 1 when following the rules:
    - if number is odd, multiply with 3 and add 1
    - if number is even, divide by 2
  """
  @spec calc(input :: pos_integer()) :: non_neg_integer()
  def calc(0), do: raise FunctionClauseError
  def calc(input) when input < 0, do: raise FunctionClauseError
  def calc(input) when is_bitstring(input), do: raise FunctionClauseError
  def calc(input) do
    count_steps(input, 0)
  end

  defp count_steps(1, count), do: count
  defp count_steps(input, count) do
    if Integer.is_even(input) do
      count_steps(div(input, 2), count + 1)
    else
      count_steps(3 * input + 1, count + 1)
    end
  end
end
