defmodule TakeANumber do
  def start() do
    spawn(fn -> machine(0) end)
  end

  def machine(count) do
    receive do
      {:report_state, sender_pid}  ->
        send(sender_pid, count)
        machine(count)
      {:take_a_number, sender_pid} ->
        send(sender_pid, count + 1)
        machine(count + 1)
#      {:stop, _sender_id} ->
      _ -> machine(count)
    end
 end



end
