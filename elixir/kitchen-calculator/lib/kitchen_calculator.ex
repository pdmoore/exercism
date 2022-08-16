defmodule KitchenCalculator do
  @ml_per_teaspoon 5
  @ml_per_tablespoon 15
  @ml_per_fluid_ounce 30
  @ml_per_cup 240

  @conversions %{
    :milliliter  =>   1,
    :teaspoon    =>   5,
    :tablespoon  =>  15,
    :fluid_ounce =>  30,
    :cup         => 240
  }

  def get_volume(volume_pair) do
    elem(volume_pair, 1)
  end

  def to_milliliter(volume_pair) do
    {:milliliter, @conversions[elem(volume_pair, 0)] * get_volume(volume_pair)}
  end

  def from_milliliter(volume_pair, unit) when unit == :milliliter, do: volume_pair
  def from_milliliter(volume_pair, unit) when unit == :cup, do: {unit, get_volume(volume_pair) / @ml_per_cup}
  def from_milliliter(volume_pair, unit) when unit == :fluid_ounce, do: {unit, get_volume(volume_pair) / @ml_per_fluid_ounce}
  def from_milliliter(volume_pair, unit) when unit == :tablespoon, do: {unit, get_volume(volume_pair) / @ml_per_tablespoon}
  def from_milliliter(volume_pair, unit) when unit == :teaspoon, do: {unit, get_volume(volume_pair) / @ml_per_teaspoon}

  def convert(volume_pair, unit) do
    volume_pair |> to_milliliter() |> from_milliliter(unit)
  end
end
