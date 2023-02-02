defmodule Hamming do
  @doc """
  Returns number of differences between two strands of DNA, known as the Hamming Distance.

  ## Examples

  iex> Hamming.hamming_distance('AAGTCATA', 'TAGCGATC')
  {:ok, 4}
  """
  @spec hamming_distance([char], [char]) :: {:ok, non_neg_integer} | {:error, String.t()}
  def hamming_distance(strand1, strand2) do

    # need a counter, then recurse over each character in the strand
    # if chars do not match, increment counter

    #strands of different length, return {:error, "strands must be of equal length"}

    {:ok, 0}
  end
end
