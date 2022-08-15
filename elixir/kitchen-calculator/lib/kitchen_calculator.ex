defmodule KitchenCalculator do
  def get_volume(volume_pair) do
    elem(volume_pair, 1)
  end

  def to_milliliter(volume_pair) do
    # Please implement the to_milliliter/1 functions
    unit = elem(volume_pair, 0)
    cond do
      unit == :milliliter -> volume_pair
      true -> -99
    end
  end

  def from_milliliter(volume_pair, unit) do
    # Please implement the from_milliliter/2 functions
  end

  def convert(volume_pair, unit) do
    # Please implement the convert/2 function
  end
end
