defmodule RPNCalculatorInspection do
  def start_reliability_check(calculator, input) do
    # Please implement the start_reliability_check/2 function

    {:ok, pid} = Task.start_link(fn -> something(calculator, input) end)

    %{pid: pid, input: input}
  end

  defp something(calculator, input) do

  end

  def await_reliability_check_result(%{pid: pid, input: input}, results) do
    # Please implement the await_reliability_check_result/2 function
  end

  def reliability_check(calculator, inputs) do
    # Please implement the reliability_check/2 function
  end

  def correctness_check(calculator, inputs) do
    # Please implement the correctness_check/2 function
  end
end
