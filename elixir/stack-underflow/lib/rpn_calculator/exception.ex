defmodule RPNCalculator.Exception do
  defmodule DivisionByZeroError do
    defexception message: "division by zero occurred"

    @impl true
    def exception(value) do
      case value do
        _ ->  %DivisionByZeroError{}
      end
    end
  end

  defmodule StackUnderflowError do
    @message "stack underflow occurred"
    defexception message: @message

    @impl true
    def exception(value) do
      case value do
        [] ->
          %StackUnderflowError{}
        _ ->
          %StackUnderflowError{message: @message <> ", context: " <> value}
      end
    end
  end

  def divide([]), do: raise StackUnderflowError, "when dividing"
  def divide([_ | []]), do: raise StackUnderflowError, "when dividing"
  def divide([0 | _]), do: raise DivisionByZeroError
  def divide([divisor, dividend]), do: div(dividend, divisor)
end
