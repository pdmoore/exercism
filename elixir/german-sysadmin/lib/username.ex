defmodule Username do
  def sanitize([]), do: []
  def sanitize([first_char | t]) do
    sanitize(first_char) ++ sanitize(t)
  end
  def sanitize(ch) when ch == ?_, do: '_'
  def sanitize(ch) when ch >= ?a and ch <= ?z, do: [ch]
  def sanitize(ch) do
      case ch do
        ?ä -> [?a, ?e]
        ?ö -> [?o, ?e]
        ?ü -> [?u, ?e]
        ?ß -> [?s, ?s]
        _ -> ''
      end
  end
end
