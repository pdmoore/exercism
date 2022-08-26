defmodule DNA do


  def encode_nucleotide(?\s), do: 0b0000
  def encode_nucleotide(?A), do: 0b0001
  def encode_nucleotide(?C), do: 0b0010
  def encode_nucleotide(?G), do: 0b0100
  def encode_nucleotide(?T), do: 0b1000
  def encode_nucleotide(code_point) do
  end

  def decode_nucleotide(0b0000), do: ?\s
  def decode_nucleotide(0b0001), do: ?A
  def decode_nucleotide(0b0010), do: ?C
  def decode_nucleotide(0b0100), do: ?G
  def decode_nucleotide(0b1000), do: ?T
  def decode_nucleotide(encoded_code) do
  end

  # TODO figure out how to collapse this
  def encode(' '), do: <<encode_nucleotide(?\s)::4>>
  def encode('A'), do: <<encode_nucleotide(?A)::4>>
  def encode('C'), do: <<encode_nucleotide(?C)::4>>
  def encode('G'), do: <<encode_nucleotide(?G)::4>>
  def encode('T'), do: <<encode_nucleotide(?T)::4>>

  def encode(dna) do
    do_encode(dna, nil)
  end

   defp do_encode(tail), do: <<encode_nucleotide(tail)::4>>
   defp do_encode([head | tail], accumulator), do: <<encode_nucleotide(head)::4, encode(tail)::bitstring>>

  def decode(dna) do
    # Please implement the decode/1 function
  end
end
