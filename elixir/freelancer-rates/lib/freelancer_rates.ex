defmodule FreelancerRates do
  @hours_per_day 8.0

  def daily_rate(hourly_rate), do: hourly_rate * @hours_per_day

  def apply_discount(before_discount, discount) do
    discount_rate = (100 - discount) / 100.0
    before_discount * discount_rate
  end

  def monthly_rate(hourly_rate, discount) do
    before_discount = ceil(@hours_per_day * hourly_rate * 22)
  end

  def days_in_budget(budget, hourly_rate, discount) do
    Float.floor(budget / (apply_discount(daily_rate(hourly_rate), discount)), 1)
  end
end
