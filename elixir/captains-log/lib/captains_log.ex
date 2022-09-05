defmodule CaptainsLog do
  @planetary_classes ["D", "H", "J", "K", "L", "M", "N", "R", "T", "Y"]

  def random_planet_class() do
    Enum.random(@planetary_classes)
  end

  def random_ship_registry_number() do
    #1000 to 9999 inclusive
    #:rand.uniform(n)
    # 1000 <= x <= 9999
    #    1 <= x <= 9000
    #  999
    number = :rand.uniform(9000) + 999
    "NCC-#{number}"
  end

  def random_stardate() do
    # Please implement the random_stardate/0 function
  end

  def format_stardate(stardate) do
    # Please implement the format_stardate/1 function
  end
end
