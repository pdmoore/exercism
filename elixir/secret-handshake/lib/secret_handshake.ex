defmodule SecretHandshake do
  @doc """
  Determine the actions of a secret handshake based on the binary
  representation of the given `code`.

  If the following bits are set, include the corresponding action in your list
  of commands, in order from lowest to highest.

  1 = wink
  10 = double blink
  100 = close your eyes
  1000 = jump

  10000 = Reverse the order of the operations in the secret handshake
  """
  @spec commands(code :: integer) :: list(String.t())
  def commands(code) do
    []
    |> check_for_bit(Bitwise.band(code, 0b00001))
    |> check_for_bit(Bitwise.band(code, 0b00010))
    |> check_for_bit(Bitwise.band(code, 0b00100))
    |> check_for_bit(Bitwise.band(code, 0b01000))


end

def check_for_bit(secrets, 0b00001), do: secrets ++ ["wink"]
def check_for_bit(secrets, 0b00010), do: secrets ++ ["double blink"]
def check_for_bit(secrets, 0b00100), do: secrets ++ ["close your eyes"]
def check_for_bit(secrets, 0b01000), do: secrets ++ ["jump"]
def check_for_bit(secrets, _), do: secrets

end
