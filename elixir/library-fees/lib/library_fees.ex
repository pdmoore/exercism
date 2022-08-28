defmodule LibraryFees do
  @monday 1

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

  # TODO - could prolly be a Min expression
  def days_late(planned_return_date, actual_return_datetime) do
    actual_return_date = NaiveDateTime.to_date(actual_return_datetime)
    if (Date.compare(planned_return_date, actual_return_date) == :gt) do
      0
    else
      Date.diff(actual_return_date, planned_return_date)
    end
  end

  def monday?(datetime) do
    actual_return_date = NaiveDateTime.to_date(datetime)
    Date.day_of_week(actual_return_date) == @monday
  end

  def calculate_late_fee(checkout, return, rate) do
    expected_return_date = return_date(datetime_from_string(checkout))
    days = days_late(expected_return_date, datetime_from_string(return))

    if monday?(datetime_from_string(return)) do
      trunc(days * rate * 0.5)
    else

    days * rate
    end

  end
end