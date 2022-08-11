defmodule FreelancerRates do
  @hours_per_day 8.0

  def daily_rate(hourly_rate), do: hourly_rate * @hours_per_day

  def apply_discount(before_discount, discount) do
    # Please implement the apply_discount/2 function
  end

  def monthly_rate(hourly_rate, discount) do
    # Please implement the monthly_rate/2 function
  end

  def days_in_budget(budget, hourly_rate, discount) do
    # Please implement the days_in_budget/3 function
  end
end
