defmodule KitchenCalculator do
  @ml_per_teaspoon 5
  @ml_per_tablespoon 15
  @ml_per_fluid_ounce 30
  @ml_per_cup 240

  def get_volume(volume_pair) do
    elem(volume_pair, 1)
  end

  def to_milliliter(volume_pair) do
    # Please implement the to_milliliter/1 functions
    unit = elem(volume_pair, 0)

    cond do
      unit == :milliliter -> {:milliliter, elem(volume_pair, 1)}
      unit == :cup -> {:milliliter, @ml_per_cup * elem(volume_pair, 1)}
      unit == :fluid_ounce -> {:milliliter, @ml_per_fluid_ounce * elem(volume_pair, 1)}
      unit == :teaspoon -> {:milliliter, @ml_per_teaspoon * elem(volume_pair, 1)}
      unit == :tablespoon -> {:milliliter, @ml_per_tablespoon * elem(volume_pair, 1)}
      true -> -99
    end
  end

  def from_milliliter(volume_pair, unit) do
    cond do
      unit == :milliliter -> {unit, elem(volume_pair, 1)}
      unit == :cup -> {unit, elem(volume_pair, 1) / @ml_per_cup}
      unit == :teaspoon -> {unit, elem(volume_pair, 1) / @ml_per_teaspoon}
      unit == :tablespoon -> {unit, elem(volume_pair, 1) / @ml_per_tablespoon}
      unit == :fluid_ounce -> {unit, elem(volume_pair, 1) / @ml_per_fluid_ounce}
    end
  end

  def convert(volume_pair, unit) do
    from_milliliter(to_milliliter(volume_pair), unit)
  end
end
