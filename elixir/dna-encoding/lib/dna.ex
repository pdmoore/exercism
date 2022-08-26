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

  def encode(' '), do: <<encode_nucleotide(?\s)::4>>
  def encode('A'), do: <<encode_nucleotide(?A)::4>>
  def encode('C'), do: <<encode_nucleotide(?C)::4>>
  def encode('G'), do: <<encode_nucleotide(?G)::4>>
  def encode('T'), do: <<encode_nucleotide(?T)::4>>

  def encode(dna) do
    blank = <<0b0000::4>>
    a_encoded = <<0b0001::4>>
    c_encoded = <<0b0010::4>>
    g_encoded = <<0b0100::4>>
    t_encoded = <<0b1000::4>>
    <<blank::bitstring, a_encoded::bitstring, c_encoded::bitstring, g_encoded::bitstring, t_encoded::bitstring>>
  end

  def decode(dna) do
    # Please implement the decode/1 function
  end
end
