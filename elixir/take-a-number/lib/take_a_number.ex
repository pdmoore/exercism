defmodule TakeANumber do
  def start() do
    spawn(fn -> machine end)
  end

  def machine() do
    0
  end
#  receive do
#    {:report_state, pid} -> send(pid, 99)
##    after
##    0 -> "nothing"
#  end
end
