defmodule TakeANumber do
  def start() do
    spawn(fn -> 0 end)
  end
end
