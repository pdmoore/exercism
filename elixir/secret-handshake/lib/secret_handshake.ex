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


    # It's easy to do the bit checks
    # completely stuck on how to add the secret string to the list
    # and then return the resulting list of secrets....

    blink = 1
    _double_blink = 2
    result = []
    if Bitwise.band(code, blink) == 1 do
      ["wink" | result]
    else
#      ["double blink"]
#    FAILS  if Bitwise.band(code, double_blink) == 1 do
#    WORKS  if (code == 2) do
      if (Bitwise.bsr(code,1) == 1) do
        ["double blink"]
      else
        if (Bitwise.bsr(code,2) == 1) do
          ["close your eyes"]
        else
          if (Bitwise.bsr(code,3) == 1) do
            ["jump"]
          else
            ["woof1"]
          end
        end
      end
    end
  end
end
