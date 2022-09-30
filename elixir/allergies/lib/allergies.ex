defmodule Allergies do
  @doc """
  List the allergies for which the corresponding flag bit is true.
  """
  @spec list(non_neg_integer) :: [String.t()]
  def list(flags) do
    []
      |> check_for_allergy(Bitwise.band(flags, 0b00000001))
      |> check_for_allergy(Bitwise.band(flags, 0b00000010))
      |> check_for_allergy(Bitwise.band(flags, 0b00000100))
      |> check_for_allergy(Bitwise.band(flags, 0b00001000))
      |> check_for_allergy(Bitwise.band(flags, 0b00010000))
      |> check_for_allergy(Bitwise.band(flags, 0b00100000))
      |> check_for_allergy(Bitwise.band(flags, 0b01000000))
      |> check_for_allergy(Bitwise.band(flags, 0b10000000))
  end

  defp check_for_allergy(allergies, 0b00000001), do: allergies ++ ["eggs"]
  defp check_for_allergy(allergies, 0b00000010), do: allergies ++ ["peanuts"]
  defp check_for_allergy(allergies, 0b00000100), do: allergies ++ ["shellfish"]
  defp check_for_allergy(allergies, 0b00001000), do: allergies ++ ["strawberries"]
  defp check_for_allergy(allergies, 0b00010000), do: allergies ++ ["tomatoes"]
  defp check_for_allergy(allergies, 0b00100000), do: allergies ++ ["chocolate"]
  defp check_for_allergy(allergies, 0b01000000), do: allergies ++ ["pollen"]
  defp check_for_allergy(allergies, 0b10000000), do: allergies ++ ["cats"]
  defp check_for_allergy(allergies, _), do: allergies

  @doc """
  Returns whether the corresponding flag bit in 'flags' is set for the item.
  """
  @spec allergic_to?(non_neg_integer, String.t()) :: boolean
  def allergic_to?(flags, item) do

    set = list(flags)

    if set == [] do
      false
    else
      set
    end


  end
end
