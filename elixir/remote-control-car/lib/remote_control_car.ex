defmodule RemoteControlCar do
  defstruct [:nickname,
             battery_percentage: 100,
             distance_driven_in_meters: 0]

  def new(), do: new("none")
  def new(nickname) do
    rc = %RemoteControlCar{}
    %{rc | nickname: nickname}
  end

  def display_distance(remote_car) do
    distance = remote_car.distance_driven_in_meters
    "#{distance} meters"
  end

  def display_battery(remote_car) do
    percentage = remote_car.battery_percentage
    cond do
      percentage == 0 -> "Battery empty"
      true -> "Battery at #{percentage}%"
    end
  end

  def drive(remote_car) do
    percentage = remote_car.battery_percentage
    if (percentage == 0) do
      remote_car
    end
  end
end
