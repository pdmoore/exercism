defmodule Darts do
  @type position :: {number, number}
  @inner_circle_score  10
  @middle_circle_score  5
  @outer_circle_score   1
  @outside_target_score 0

  @doc """
  Calculate the score of a single dart hitting a target
  """
  @spec score(position) :: integer
  def score({x, y}) do
    distance_from_center = :math.sqrt((x |> squared) + (y |> squared))
    cond do
      distance_from_center <= 1  -> @inner_circle_score
      distance_from_center <= 5  -> @middle_circle_score
      distance_from_center <= 10 -> @outer_circle_score
      true -> @outside_target_score
    end
  end

  def squared(scalar) do
    :math.pow(scalar, 2)
  end
end
