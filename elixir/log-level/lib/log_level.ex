defmodule LogLevel do
  def to_label(level, legacy?) do
    # Please implement the to_label/2 function

    cond do
      level == 0 -> if legacy?, do: :unknown, else: :trace
      level == 1 -> :debug
      level == 2 -> :info
      level == 3 -> :warning
      level == 4 -> :error
      level == 5 -> if legacy?, do: :unknown, else: :fatal
      true -> :unknown
    end
  end

  def alert_recipient(level, legacy?) do
    if level == 5, do: :ops
    # Please implement the alert_recipient/2 function
  end
end
