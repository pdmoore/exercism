defmodule RPNCalculator do
  def calculate!(stack, operation) do
    operation.(stack)
  end

  def calculate(stack, operation) do
    try do
      {:ok, operation.(stack)}
    rescue
      _ -> :error
    end
  end

  def calculate_verbose(stack, operation) do
    try do
      operation.(stack)
      {:ok, "operation completed"}
    rescue
      e in ArgumentError -> {:error, e.message}
      _ -> {:error, "test error"}
    end

  end
end
