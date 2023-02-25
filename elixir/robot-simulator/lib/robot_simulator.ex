defmodule RobotSimulator do
  @type robot() :: any()
  @type direction() :: :north | :east | :south | :west
  @type position() :: {integer(), integer()}

  @doc """
  Create a Robot Simulator given an initial direction and position.

  Valid directions are: `:north`, `:east`, `:south`, `:west`
  """
  @spec create(direction, position) :: robot() | {:error, String.t()}
  def create(), do: create(:north, {0, 0})
  def create(direction, {x, y}) when is_integer(x) and is_integer(y) do
    cond do
      direction in [:north, :south, :east, :west] -> %{:direction => direction, :position => {x, y}}
      true -> {:error, "invalid direction"}
    end
  end
  def create(_, _), do: {:error, "invalid position"}

  @doc """
  Simulate the robot's movement given a string of instructions.

  Valid instructions are: "R" (turn right), "L", (turn left), and "A" (advance)
  """
  @spec simulate(robot, instructions :: String.t()) :: robot() | {:error, String.t()}
  def simulate(robot, []), do: robot
    def simulate(robot, [head | tail]) do
    simulate(move(robot, head), tail)
  end
  def simulate(robot, one_movement) do
    move(robot, one_movement)
  end
  def move(robot, instruction) when instruction == "R" do
    case robot[:direction] do
      :north -> %{:direction => :east, :position => robot[:position]}
      :east -> %{:direction => :south, :position => robot[:position]}
      :south -> %{:direction => :west, :position => robot[:position]}
      :west -> %{:direction => :north, :position => robot[:position]}
    end
  end
  def move(robot, instruction) when instruction == "L" do
    case robot[:direction] do
      :north -> %{:direction => :west, :position => robot[:position]}
      :east -> %{:direction => :north, :position => robot[:position]}
      :south -> %{:direction => :east, :position => robot[:position]}
      :west -> %{:direction => :south, :position => robot[:position]}
    end
  end
  def move(robot, instruction) when instruction == "A" do
    case robot[:direction] do
      :north ->  %{:direction => robot[:direction], :position => {elem(robot[:position], 0), elem(robot[:position], 1) + 1}}
      :east -> %{:direction => robot[:direction], :position => {elem(robot[:position], 0) + 1, elem(robot[:position], 1)}}
      :south -> %{:direction => robot[:direction], :position => {elem(robot[:position], 0), elem(robot[:position], 1) - 1}}
      :west -> %{:direction => robot[:direction], :position => {elem(robot[:position], 0) - 1, elem(robot[:position], 1)}}
    end
  end
  def move(robot, instruction) do
    [head | tail] = instruction |> String.codepoints
    if head not in ["A", "L", "R"] do
      {:error, "invalid instruction"}
    else
      simulate(move(robot, head), tail)
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
