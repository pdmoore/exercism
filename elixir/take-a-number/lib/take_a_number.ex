defmodule TakeANumber do
  def start() do
    spawn(fn -> machine(0) end)
  end

  def machine(value) do
    count = value

    receive do
      {:report_state, sender_pid}  -> send(sender_pid, count)
      {:take_a_number, sender_pid} -> send(sender_pid, count + 1)
    end

    machine(count)
  end


end
