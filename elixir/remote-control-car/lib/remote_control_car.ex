defmodule RemoteControlCar do
  defstruct [nickname: "none",
             battery_percentage: 100,
             distance_driven_in_meters: 0,
            ]

  def new() do
    %RemoteControlCar{}
  end

  def new(nickname) do
    # Please implement the new/1 function
  end

  def display_distance(remote_car) do
    # Please implement the display_distance/1 function
  end

  def display_battery(remote_car) do
    # Please implement the display_battery/1 function
  end

  def drive(remote_car) do
    # Please implement the drive/1 function
  end
end
