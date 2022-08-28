defmodule LibraryFees do
  def datetime_from_string(string) do
    NaiveDateTime.from_iso8601!(string)
  end

  # TODO - is this the best way to check less than and convert to boolean?
  def before_noon?(datetime) do
    noon = ~T[12:00:00.000]
    Time.compare(NaiveDateTime.to_time(datetime), noon) == :lt
  end

  def return_date(checkout_datetime) do
    checkout_date = NaiveDateTime.to_date(checkout_datetime)
    if (before_noon?(checkout_datetime)) do
      Date.add(checkout_date, 28)
    else
      Date.add(checkout_date, 29)
    end
  end

  def days_late(planned_return_date, actual_return_datetime) do
    actual_return_date = NaiveDateTime.to_date(actual_return_datetime)
    difference = Date.compare(planned_return_date, actual_return_date)
    cond do
      true -> 0
    end
    # Please implement the days_late/2 function
  end

  def monday?(datetime) do
    # Please implement the monday?/1 function
  end

  def calculate_late_fee(checkout, return, rate) do
    # Please implement the calculate_late_fee/3 function
  end
end
