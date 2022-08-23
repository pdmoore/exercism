defmodule Username do
  def sanitize([]), do: []
  def sanitize([first_char | t]) do
    sanitize(first_char) ++ sanitize(t)
  end
  def sanitize(ch) when ch == ?_, do: '_'
  def sanitize(first_char) do
      case first_char do
        ?ä -> [?a, ?e]
        ?ö -> [?o, ?e]
        ?ü -> [?u, ?e]
        ?ß -> [?s, ?s]
        ch when ch >= ?a and ch <= ?z -> [ch]
        _ -> ''
      end
  end
end
