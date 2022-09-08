defmodule LucasNumbers do
  @moduledoc """
  Lucas numbers are an infinite sequence of numbers which build progressively
  which hold a strong correlation to the golden ratio (φ or ϕ)

  E.g.: 2, 1, 3, 4, 7, 11, 18, 29, ...
  """
  def generate(1), do: [2]
  def generate(2), do: [2, 1]
  def generate(count) when is_binary(count), do: generate(0)
  def generate(count) when count <= 0, do: raise ArgumentError, message: "count must be specified as an integer >= 1"
  def generate(count) do

    # starting with 2, while size of list is less than count
    # [list | second, last]
    # list, second+last
    # Visualize Stream usage?
    # map the algo out on paper and see what parts are at play

    Enum.concat(generate(count - 1), [count])





  end
end
