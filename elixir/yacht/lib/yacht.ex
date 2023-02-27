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
  def score(category, dice) when category in [:ones, :twos, :threes, :fours, :fives, :sixes] do
    target_value =
    case category do
      :ones -> 1
      :twos -> 2
      :threes -> 3
      :fours -> 4
      :fives -> 5
      :sixes -> 6
    end
    Enum.count(dice, & &1 == target_value) * target_value
  end
  def score(category, dice) when category == :choice do
    Enum.sum(dice)
  end
  def score(category, dice) when category == :full_house do
    case Enum.sort(dice) do
      [x, x, x, x, x] -> 0
      [x, x, x, y, y] when x != y -> Enum.sum(dice)
      [x, x, y, y, y] when x != y -> Enum.sum(dice)
      _ -> 0
    end
  end
  def score(category, dice) when category == :four_of_a_kind do
    case Enum.sort(dice) do
      [x, x, x, x, _] -> 4 * x
      [_, x, x, x, x] -> 4 * x
      _ -> 0
    end
  end
  def score(category, dice) when category == :little_straight do
    case Enum.sort(dice)do
      [1, 2, 3, 4, 5] -> 30
      _ -> 0
    end
  end
  def score(category, dice) when category == :big_straight do
    case Enum.sort(dice) do
      [2, 3, 4, 5, 6] -> 30
      _ -> 0
    end
  end

  def score(_, _) do
  end
end
