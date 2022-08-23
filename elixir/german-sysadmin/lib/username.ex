defmodule Username do
  def sanitize([]), do: []
  def sanitize([first_char | t]) do
    sanitize(first_char) ++ sanitize(t)
  end
  def sanitize(ch) when ch == ?_, do: '_'
  def sanitize(ch) when ch >= ?a and ch <= ?z, do: [ch]
  # would prefer to have a list of specific german characters to compare against
  # or a map of german character to Latin substitution.
  # But Elixir Analyzer wants a case statement, so here it is
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
