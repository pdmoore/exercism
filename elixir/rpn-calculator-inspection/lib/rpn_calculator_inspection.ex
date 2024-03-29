defmodule RPNCalculatorInspection do
  @wait_time 100

  def start_reliability_check(calculator, input) do
    {:ok, pid} = Task.start_link(fn -> calculator.(input) end)
    %{pid: pid, input: input}
  end

  def await_reliability_check_result(%{pid: pid, input: input}, results) do
    receive do
      {:EXIT, caller, :normal} when caller == pid -> Map.put(results, input, :ok)
      {:EXIT, caller, _}       when caller == pid -> Map.put(results, input, :error)
    after
      @wait_time -> Map.put(results, input, :timeout)
    end
  end

  def reliability_check(calculator, inputs) do
    old_flag_value = Process.flag(:trap_exit, true)

    result = Enum.map(inputs, fn input -> start_reliability_check(calculator, input) end)
      |> Enum.reduce(%{}, &await_reliability_check_result/2)

    Process.flag(:trap_exit, old_flag_value)

    result
  end

  def correctness_check(calculator, inputs) do
    Enum.map(inputs, fn input -> Task.async(fn -> calculator.(input) end) end)
      |> Task.await_many(@wait_time)
  end
end
