defmodule Darts do
  @type position :: {number, number}

  @doc """
  Calculate the score of a single dart hitting a target
  """
  @spec score(position) :: integer
  def score({x, y}) do
    deltaX = 0 - x
    deltaY = 0 - y
    sum = (deltaX * deltaX) + (deltaY * deltaY)
    # sqrt of (0 - x)^2 + (o-y)^2
    distance = :math.sqrt(sum)
    cond do
      distance <= 5 -> 5
      distance <= 10 -> 1
      true -> 0
    end
  end
end
