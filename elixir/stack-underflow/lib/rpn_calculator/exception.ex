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
    defexception message: "stack underflow occurred"

    @impl true
    def exception(value) do
      case value do
        [] ->
          %StackUnderflowError{}
        _ ->
          %StackUnderflowError{message: "stack underflow occurred, context: " <> value}
      end
    end
  end

  def divide([]), do: raise StackUnderflowError, "when dividing"
  def divide([_ | []]), do: raise StackUnderflowError, "when dividing"
  def divide([h | _]) when h == 0, do: raise DivisionByZeroError
  def divide([h | t]), do: div(hd(t), h)
end
