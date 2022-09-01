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
    # Please implement the display_battery/1 function
  end

  def drive(remote_car) do
    # Please implement the drive/1 function
  end
end
