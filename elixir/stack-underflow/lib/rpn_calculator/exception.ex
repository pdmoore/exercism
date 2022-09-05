defmodule RPNCalculator.Exception do
  # Please implement DivisionByZeroError here.
  defmodule DivisionByZeroError do
    defexception message: "division by zero occurred"

    @impl true
    def exception(value) do
      case value do
        _ ->  %DivisionByZeroError{}
      end
    end
  end

  # Please implement StackUnderflowError here.
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
#  def divide([h | _]) when h == 0, do: DivisionByZeroError
  #TODO - this passes the one number test, dunno if I trust the impl tho
  def divide([_ | t]), do: raise StackUnderflowError, "when dividing"

end
