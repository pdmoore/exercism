defmodule ProteinTranslation do
  @doc """
  Given an RNA string, return a list of proteins specified by codons, in order.
  """
  @spec of_rna(String.t()) :: {:ok, list(String.t())} | {:error, String.t()}
  def of_rna(rna) do
    codons_by_3 = rna
      |> to_charlist
      |> Enum.chunk_every(3)
      |> Enum.map(&to_string/1)

    codons_to_proteins(codons_by_3, {:ok, []})
  end

  defp codons_to_proteins([], result), do: result
  defp codons_to_proteins([head | tail], {_, result}) do
    case of_codon(head) do
      {:ok, "STOP"} -> {:ok, result}
      {:ok, protein} -> codons_to_proteins(tail, {:ok, result ++ [protein]})
      _ -> {:error, "invalid RNA"}
    end
  end




  @doc """
  Given a codon, return the corresponding protein

  UGU -> Cysteine
  UGC -> Cysteine
  UUA -> Leucine
  UUG -> Leucine
  AUG -> Methionine
  UUU -> Phenylalanine
  UUC -> Phenylalanine
  UCU -> Serine
  UCC -> Serine
  UCA -> Serine
  UCG -> Serine
  UGG -> Tryptophan
  UAU -> Tyrosine
  UAC -> Tyrosine
  UAA -> STOP
  UAG -> STOP
  UGA -> STOP
  """
  @spec of_codon(String.t()) :: {:ok, String.t()} | {:error, String.t()}
  def of_codon("AUG"), do: {:ok, "Methionine"}
  def of_codon(codon) when codon in ["UUU", "UUC"] do {:ok, "Phenylalanine"} end
  def of_codon(codon) when codon in ["UUA", "UUG"] do {:ok, "Leucine"} end
  def of_codon(codon) when codon in ["UCU", "UCC", "UCA", "UCG"] do {:ok, "Serine"} end
  def of_codon(codon) when codon in ["UCU", "UCC", "UCA", "UCG"] do {:ok, "Serine"} end
  def of_codon(codon) when codon in ["UAU", "UAC"] do {:ok, "Tyrosine"} end
  def of_codon(codon) when codon in ["UGU", "UGC"] do {:ok, "Cysteine"} end
  def of_codon(codon) when codon in ["UGG"] do {:ok, "Tryptophan"} end
  def of_codon(codon) when codon in ["UAA", "UAG", "UGA"] do {:ok, "STOP"} end
  def of_codon(_), do: {:error, "invalid codon"}
end
