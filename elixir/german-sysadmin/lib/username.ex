defmodule Username do
#  def sanitize(username) do
#    username
#      |> Enum.map(fn ch -> convert_german(ch) end)
#      |> Enum.filter(fn ch -> (ch >= ?a and ch <= ?z) or (ch == ?_) end)
#
#  end
#
#  defp convert_german(ch) do
#        case ch do
#          ?ä -> [?a, ?e]
#          ?ö -> [?o, ?e]
#          ?ü -> [?u, ?e]
#          ?ß -> [?s, ?s]
#          _ -> ch
#        end
#  end

  def sanitize(username) when username == [], do: []
  def sanitize(ch), do: ch
  def sanitize([h | t]) do
    sanitize(h) ++ sanitize(t)
  end
end
