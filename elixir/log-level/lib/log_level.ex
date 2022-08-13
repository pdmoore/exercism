defmodule LogLevel do
  def to_label(level, legacy?) do
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
    cond do
      level == 0 and legacy? -> :dev1
      level == 4 -> :ops
      level == 5 -> if legacy?, do: :dev1, else: :ops
      level == 6 -> if legacy?, do: :dev1, else: :dev2
      true -> false
    end
  end
end
