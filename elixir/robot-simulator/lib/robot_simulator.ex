defmodule RobotSimulator do
  @type robot() :: any()
  @type direction() :: :north | :east | :south | :west
  @type position() :: {integer(), integer()}

  @doc """
  Create a Robot Simulator given an initial direction and position.


  #TODO - shouldn't I be able to check parameter direction against @type on line 3?
  # and what about checking type at function definition, not within body?

  Valid directions are: `:north`, `:east`, `:south`, `:west`
  """
  @spec create(direction, position) :: robot() | {:error, String.t()}
  def create(), do: create(:north, {0, 0})
  def create(direction \\ nil, position \\ nil) do
    cond do
      direction in [:north, :south, :east, :west] -> %{:direction => direction, :position => position}
      true -> {:error, "invalid direction"}
    end
  end

  @doc """
  Simulate the robot's movement given a string of instructions.

  Valid instructions are: "R" (turn right), "L", (turn left), and "A" (advance)
  """
  @spec simulate(robot, instructions :: String.t()) :: robot() | {:error, String.t()}
  def simulate(robot, instruction) when instruction == "R" do
    case robot[:direction] do
      :north -> %{:direction => :east, :position => robot[:position]}
      :east -> %{:direction => :south, :position => robot[:position]}
      :south -> %{:direction => :west, :position => robot[:position]}
      :west -> %{:direction => :north, :position => robot[:position]}
    end
  end
  def simulate(robot, instruction) when instruction == "L" do
    case robot[:direction] do
      :north -> %{:direction => :west, :position => robot[:position]}
      :east -> %{:direction => :north, :position => robot[:position]}
      :south -> %{:direction => :east, :position => robot[:position]}
      :west -> %{:direction => :south, :position => robot[:position]}
    end
  end
  def simulate(robot, instruction) when instruction == "A" do
    case robot[:direction] do
      :north ->  %{:direction => robot[:direction], :position => {elem(robot[:position], 0), elem(robot[:position], 1) + 1}}
      :east -> %{:direction => robot[:direction], :position => {elem(robot[:position], 0) + 1, elem(robot[:position], 1)}}
      :south -> %{:direction => robot[:direction], :position => {elem(robot[:position], 0), elem(robot[:position], 1) - 1}}
      :west -> %{:direction => robot[:direction], :position => {elem(robot[:position], 0) - 1, elem(robot[:position], 1)}}
    end
  end

  @doc """
  Return the robot's direction.

  Valid directions are: `:north`, `:east`, `:south`, `:west`
  """
  @spec direction(robot) :: direction()
  def direction(robot) do
    robot[:direction]
  end

  @doc """
  Return the robot's position.
  """
  @spec position(robot) :: position()
  def position(robot) do
    robot[:position]
  end
end
