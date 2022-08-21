defmodule Username do
  def sanitize(username) do
    # ä becomes ae
    # ö becomes oe
    # ü becomes ue
    # ß becomes ss

    # Please implement the sanitize/1 function
    ''

    username |> Enum.filter(fn ch -> ch >= ?a and ch <= ?z end)

  end

end
