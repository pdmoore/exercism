defmodule Hamming do
  @doc """
  Returns number of differences between two strands of DNA, known as the Hamming Distance.

  ## Examples

  iex> Hamming.hamming_distance('AAGTCATA', 'TAGCGATC')
  {:ok, 4}
  """
  @spec hamming_distance([char], [char]) :: {:ok, non_neg_integer} | {:error, String.t()}
  def hamming_distance(strand1, strand2) do
    hamming_distance(strand1, strand2, 0)
  end

  # TODO - Suspect a lot of the 'cond' code will be covered by the other impls below
  # start pulling code, runningt tests, to see if that's true

  @spec hamming_distance([char], [char], integer) :: {:ok, non_neg_integer} | {:error, String.t()}
  def hamming_distance([strand1_head | strand1_tail], [strand2_head | strand2_tail], difference_count) do

    cond do
      strand1_head != strand2_head ->
        hamming_distance(strand1_tail, strand2_tail, difference_count + 1)
      true ->
        hamming_distance(strand1_tail, strand2_tail, difference_count)
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