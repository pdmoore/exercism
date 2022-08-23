defmodule Username do
  def sanitize([]), do: []
  def sanitize([first_char | t]) do
    sanitize(first_char) ++ sanitize(t)
  end
  def sanitize(ch) when ch == ?_, do: '_'
  def sanitize(ch) when ch >= ?a and ch <= ?z, do: [ch]
  def sanitize(ch) when ch == ?ü, do: [?u, ?e]
  def sanitize(ch) when ch == ?ä, do: [?a, ?e]
  def sanitize(ch) when ch == ?ö, do: [?o, ?e]
  def sanitize(ch) when ch == ?ß, do: [?s, ?s]
  def sanitize(_), do: ''
 end
