defmodule RemoteControlCar do
  @enforce_keys [:nickname]
  defstruct [:nickname, battery_percentage: 100, distance_driven_in_meters: 0]

  def new(), do: new("none")
  def new(nickname) do
    rc = %RemoteControlCar{nickname: nickname}
  end

  def display_distance(remote_car = %RemoteControlCar{}) do
    distance = remote_car.distance_driven_in_meters
    "#{distance} meters"
  end

  def display_battery(remote_car = %RemoteControlCar{}) do
    percentage = remote_car.battery_percentage
    cond do
      percentage == 0 -> "Battery empty"
      true -> "Battery at #{percentage}%"
    end
  end

  def drive(remote_car = %RemoteControlCar{}) when remote_car.battery_percentage == 0, do: remote_car
  def drive(remote_car = %RemoteControlCar{}) do
    percentage = remote_car.battery_percentage
    distance = remote_car.distance_driven_in_meters
    %RemoteControlCar{battery_percentage: percentage - 1,
      distance_driven_in_meters: distance + 20,
      nickname: remote_car.nickname}
  end
end
