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
    sorted_dice = Enum.sort(dice)
    first  = Enum.at(sorted_dice, 0)
    second = Enum.at(sorted_dice, 1)
    if first == second do
      last = Enum.at(sorted_dice, 4)
      almost_last = Enum.at(sorted_dice, 3)
      if last == almost_last do
        middle = Enum.at(sorted_dice, 2)
        if (middle == first or middle == last) and first != last do
          Enum.sum(dice)
        else
          0
        end
      else
        0
      end
    else
      0
    end
  end
  def score(category, dice) when category == :four_of_a_kind do
    sorted_dice = Enum.sort(dice)
    first  = Enum.at(sorted_dice, 0)
    last  = Enum.at(sorted_dice, 4)
    if first == Enum.at(sorted_dice, 1) and
       first == Enum.at(sorted_dice, 2) and
       first == Enum.at(sorted_dice, 3) do
         first * 4
    else if last == Enum.at(sorted_dice, 1) and
               last == Enum.at(sorted_dice, 2) and
               last == Enum.at(sorted_dice, 3) do
           last * 4
         end
    end

  end
  # four of a kind
  # little straight
  # big straight

  def score(_, _) do
  end
end
