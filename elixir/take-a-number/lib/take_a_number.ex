defmodule TakeANumber do
  def start() do
    spawn(fn -> machine() end)
  end

  def machine() do
    0

    receive do
      {:report_state, sender_pid} -> send(sender_pid, 0)
    end

  end


end
