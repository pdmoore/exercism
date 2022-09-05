defmodule CaptainsLog do
  @planetary_classes ["D", "H", "J", "K", "L", "M", "N", "R", "T", "Y"]

  def random_planet_class() do
    Enum.random(@planetary_classes)
  end

  def random_ship_registry_number() do
    number_portion = Enum.to_list(1000..9999) |> Enum.random
    "NCC-#{number_portion}"
  end

  def random_stardate() do
    number = :rand.uniform() * 1000.0
    41_000.0 + number
  end

  def format_stardate(stardate) do
    "#{:io_lib.format("~.1f", [stardate])}"
  end
end
