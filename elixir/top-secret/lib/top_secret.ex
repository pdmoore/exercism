defmodule TopSecret do
  def to_ast(string) do
    # Please implement the to_ast/1 function
    Code.string_to_quoted!(string)
  end

  def decode_secret_message_part(ast, acc) do
    # Please implement the decode_secret_message_part/2 function
    #if ast is 'def' or 'defp' prepend the name of the thing to acc
    {thing, _, second} = ast

    if thing == :def do
      IO.puts(second)
#       {:def, _, [{fun, _, _}] | _}
#      [{:fit, [line: 1], [{:a, [line: 1], nil}, {:b, [line: 1], nil}, {:c, [line: 1], nil}]}, [do: :scale]]

      {ast, ["fit", "at"]}
    else
      {ast, acc}
    end

  end

  def decode_secret_message(string) do
    # Please implement the decode_secret_message/1 function
  end
end
