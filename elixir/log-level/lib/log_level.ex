defmodule LogLevel do
  def to_label(level, legacy?) do
    cond do
      level == 0 and not legacy? -> :trace
      level == 1 -> :debug
      level == 2 -> :info
      level == 3 -> :warning
      level == 4 -> :error
      level == 5 and not legacy?-> :fatal
      true -> :unknown
    end
  end

  def alert_recipient(level, legacy?) do
    cond do
      level in [0, 5, 6] and legacy? -> :dev1
      level in[4, 5] -> :ops
      level == 6 -> :dev2
      true -> false
    end
  end
end
