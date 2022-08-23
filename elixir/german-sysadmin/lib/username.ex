defmodule Username do
  def sanitize([]), do: []
  def sanitize([first_char | t]) do
    sanitize(first_char) ++ sanitize(t)
  end
  def sanitize(ch) when ch == ?_, do: '_'
  def sanitize(ch) when ch >= ?a and ch <= ?z, do: [ch]
  def sanitize(ch) when ch == ?ü or ch == ?ä or ch == ?ö or ch == ?ß do
    case ch do
      ?ü -> [?u, ?e]
      ?ä -> [?a, ?e]
      ?ö -> [?o, ?e]
      ?ß -> [?s, ?s]
    end
  end
  def sanitize(_), do: ''
 end
