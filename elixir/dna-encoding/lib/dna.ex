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

   def encode([tail]), do: <<encode_nucleotide(tail)::4>>
   def encode([head | tail]), do: <<encode_nucleotide(head)::4, encode(tail)::bitstring>>

  def decode(<<tail::4>>), do: [decode_nucleotide(tail)]
end
