defmodule Chessboard do
  def rank_range do
    1..8
  end

  def file_range do
    ?A..?H
  end

  def ranks do
    Enum.map(rank_range(), fn r -> r end)
  end

  def files do
    Enum.map(file_range(), fn f -> List.to_string([f]) end)
  end
end
