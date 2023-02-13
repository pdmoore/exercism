defmodule Hamming do
  @doc """
  Returns number of differences between two strands of DNA, known as the Hamming Distance.

  ## Examples

  iex> Hamming.hamming_distance('AAGTCATA', 'TAGCGATC')
  {:ok, 4}
  """
#  @spec hamming_distance([], [char]) :: {:error, String.t()}
#  def hamming_distance([], [strand2]) do
#    {:error, "strands must be of equal length"}
#  end

#  @spec hamming_distance([char], []) :: {:error, String.t()}
#  def hamming_distance([strand1], []) do
#    {:error, "strands must be of equal length"}
#  end

  @spec hamming_distance([char], [char]) :: {:ok, non_neg_integer} | {:error, String.t()}
  def hamming_distance(strand1, strand2) do

    hamming_distance(strand1, strand2, 0)
    # need a counter, then recurse over each character in the strand
    # if chars do not match, increment counter
    # if lengths don't match return error

    #strands of different length, return {:error, "strands must be of equal length"}
    # handled by the functions watching for one side empty when other is not
  end


  def hamming_distance([strand1_head | strand1_tail], [strand2_head | strand2_tail], count) do

    cond do
      strand1_head == '' and strand2_head == '' ->
        {:ok, count}
      strand1_head == '' and strand2_head != '' ->
        {:error, "strands must be of equal length"}
      strand1_head != '' and strand2_head == '' ->
        {:error, "strands must be of equal length"}
      strand1_head != strand2_head ->
        hamming_distance(strand1_tail, strand2_tail, count + 1)
      true ->
        hamming_distance(strand1_tail, strand2_tail, count)
    end
  end



  def hamming_distance(strand1_head, [strand2_head | strand2_tail], count) do
    if strand1_head == '' and strand2_head != '' do
      {:error, "strands must be of equal length"}
    else
      {:ok, count}
    end
  end


  def hamming_distance([strand1_head | strand1_tail], strand2_head, count) do
    if strand2_head == '' and strand1_head != '' do
      {:error, "strands must be of equal length"}
    else
      {:ok, count}
    end
  end

  def hamming_distance(strand1_head, strand2_head, count) do
    if strand1_head != strand2_head do
      {:ok, count + 1}
    else
      {:ok, count}
    end
  end
end