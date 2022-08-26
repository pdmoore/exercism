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

  def encode(' '), do: <<0b0000::4>>
  def encode('A'), do: <<0b0001::4>>
  def encode('C'), do: <<0b0010::4>>
  def encode('G'), do: <<0b0100::4>>
  def encode('T'), do: <<0b1000::4>>
  def encode(dna) do
  end

  def decode(dna) do
    # Please implement the decode/1 function
  end
end
