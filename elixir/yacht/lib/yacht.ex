defmodule Yacht do
  @type category ::
          :ones
          | :twos
          | :threes
          | :fours
          | :fives
          | :sixes
          | :full_house
          | :four_of_a_kind
          | :little_straight
          | :big_straight
          | :choice
          | :yacht

  @doc """
  Calculate the score of 5 dice using the given category's scoring method.
  """
  @spec score(category :: category(), dice :: [integer]) :: integer
  def score(category, dice) when category == :yacht do
    face_value = List.first(dice)
    if Enum.all?(dice, & &1==face_value) do
      50
    else
      0
    end
  end
  def score(category, dice) when category == :ones do
    target_value = 1
    Enum.count(dice, & &1 == target_value) * target_value
  end
  def score(category, dice) when category == :twos do
    target_value = 2
    Enum.count(dice, & &1 == target_value) * target_value
  end
  def score(category, dice) do
  end
end
