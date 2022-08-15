defmodule GuessingGame do
  def compare(secret_number, guess) do
    if secret_number == guess do
      "Correct"
    end
  end
end
