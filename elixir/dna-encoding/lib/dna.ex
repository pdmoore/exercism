defmodule DNA do
  def encode_nucleotide(?\s), do: 0b0000
  def encode_nucleotide(?A), do: 0b0001
  def encode_nucleotide(?C), do: 0b0010
  def encode_nucleotide(?G), do: 0b0100
  def encode_nucleotide(?T), do: 0b1000

  def decode_nucleotide(0b0000), do: ?\s
  def decode_nucleotide(0b0001), do: ?A
  def decode_nucleotide(0b0010), do: ?C
  def decode_nucleotide(0b0100), do: ?G
  def decode_nucleotide(0b1000), do: ?T


  def encode(dna), do: do_encode(dna, <<>>)

  defp do_encode([], accumulator), do: accumulator
  defp do_encode([head | tail], accumulator) do
    do_encode(tail, <<accumulator::bitstring, encode_nucleotide(head)::4>>)
  end

  def decode(dna), do: do_decode(dna, [])

  def do_decode(<<>>, accumulator), do: accumulator
  def do_decode(<<head::4, tail::bitstring>>, accumulator) do
    do_decode(tail, accumulator ++ [(decode_nucleotide(head))])
  end
end
