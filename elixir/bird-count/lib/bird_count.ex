defmodule BirdCount do

  def today([]), do: nil
  def today([h | _]), do: h


  def increment_day_count([]), do: [1]
  def increment_day_count([h | t]), do: [ h + 1 | t]

  def has_day_without_birds?([]), do: false
  def has_day_without_birds?([h | _]) when h == 0, do: true
  def has_day_without_birds?([_ | t]), do: has_day_without_birds?(t)

  def total([]), do: 0
  def total(list) do
    sum = 0
    sum + _total(sum, list)
  end

  def _total(sum, [h | t]), do: sum + h + total(t)

  def busy_days(list) do
    # Please implement the busy_days/1 function
  end
end
