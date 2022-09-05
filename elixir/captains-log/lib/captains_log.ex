defmodule CaptainsLog do
  @planetary_classes ["D", "H", "J", "K", "L", "M", "N", "R", "T", "Y"]

  def random_planet_class() do
    Enum.random(@planetary_classes)
  end

  def random_ship_registry_number() do
    number_portion = :rand.uniform(9000) + 999
    "NCC-#{number_portion}"
  end

  def random_stardate() do
    # Please implement the random_stardate/0 function
    #41000.0 inclusive, and 42000.0, exclusive
#    :rand.uniform(1000.0) + 41_000.0
    number = :rand.uniform() * 1000.0
    41_000.0 + number
  end

  def format_stardate(stardate) do
    # Please implement the format_stardate/1 function
  end
end
