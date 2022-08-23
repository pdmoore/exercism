defmodule Username do
  def sanitize([]), do: []
  def sanitize([first_char | t]) do
    sanitized_first_char =
      case first_char do
        ?ä -> [?a, ?e]
        ?ö -> [?o, ?e]
        ?ü -> [?u, ?e]
        ?ß -> [?s, ?s]
        ch when ch >= ?a and ch <= ?z -> [ch]
        ?_ -> '_'
        _ -> ''
      end
    sanitized_first_char ++ sanitize(t)
  end
end
