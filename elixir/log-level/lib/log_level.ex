defmodule LogLevel do
  def to_label(level, legacy?) do
    # Please implement the to_label/2 function
    if level == 0 do
      if legacy? do
          :unknown
        else
          :trace
      end
    else
      if level == 1 do
        :debug
        else
        if level == 2 do
          :info
        else
          :unknown
        end
      end
    end
  end

  def alert_recipient(level, legacy?) do
    # Please implement the alert_recipient/2 function
  end
end
