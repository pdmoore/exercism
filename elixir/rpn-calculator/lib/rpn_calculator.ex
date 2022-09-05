defmodule RPNCalculator do
  def calculate!(stack, operation) do
    try do
      operation.(stack)
    rescue
      _ -> :ok
    end
  end

  def calculate(stack, operation) do
    # Please implement the calculate/2 function
  end

  def calculate_verbose(stack, operation) do
    # Please implement the calculate_verbose/2 function
  end
end
