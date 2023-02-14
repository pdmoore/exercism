defmodule Hamming do
  @doc """
  Returns number of differences between two strands of DNA, known as the Hamming Distance.

  ## Examples

  iex> Hamming.hamming_distance('AAGTCATA', 'TAGCGATC')
  {:ok, 4}
  """
  @spec hamming_distance([char], [char]) :: {:ok, non_neg_integer} | {:error, String.t()}
  def hamming_distance(strand1, strand2) when length(strand1) != length(strand2),
      do: {:error, "strands must be of equal length"}

  def hamming_distance(strand1, strand2) do
    {:ok, hamming_distance(strand1, strand2, 0)}
  end

  defp hamming_distance([], [], difference_count), do: difference_count

  defp hamming_distance([match | strand1_tail], [match | strand2_tail], difference_count) do
      hamming_distance(strand1_tail, strand2_tail, difference_count)
  end

  defp hamming_distance([_mismatch1 | strand1_tail], [_mismatch2 | strand2_tail], difference_count) do
      hamming_distance(strand1_tail, strand2_tail, difference_count + 1)
  end
end