defmodule GuessingGame do
  def compare(secret_number, guess) when guess == secret_number, do: "Correct"

  def compare(secret_number, guess) when guess > secret_number, do: "Too high"

end
