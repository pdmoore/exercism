defmodule Allergies do
  @doc """
  List the allergies for which the corresponding flag bit is true.
  """
  @spec list(non_neg_integer) :: [String.t()]
  def list(flags) do
    []
      |> check_for_allergy(Bitwise.band(flags, 0b00001))
  end

  defp check_for_allergy(allergies, 0b00001), do: allergies ++ ["eggs"]
  defp check_for_allergy(allergies, _), do: allergies

  @doc """
  Returns whether the corresponding flag bit in 'flags' is set for the item.
  """
  @spec allergic_to?(non_neg_integer, String.t()) :: boolean
  def allergic_to?(flags, item) do
  end
end
