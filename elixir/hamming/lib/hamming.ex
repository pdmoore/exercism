defmodule Hamming do
  @doc """
  Returns number of differences between two strands of DNA, known as the Hamming Distance.

  ## Examples

  iex> Hamming.hamming_distance('AAGTCATA', 'TAGCGATC')
  {:ok, 4}
  """
  @spec hamming_distance([], [char]) :: {:error, String.t()}
  def hamming_distance([], strand2) do
    {:error, "strands must be of equal length"}
  end

  @spec hamming_distance([char], [char]) :: {:ok, non_neg_integer} | {:error, String.t()}
  def hamming_distance(strand1, strand2) do

    if strand1 == '' and strand2 != '' do
      {:error, "strands must be of equal length"}
    else
      if strand1 != '' and strand2 == '' do
        {:error, "strands must be of equal length"}
      else
        {:ok, 0}
      end
    end


    # need a counter, then recurse over each character in the strand
    # if chars do not match, increment counter
    # if lengths don't match return error

    #strands of different length, return {:error, "strands must be of equal length"}


  end
end
