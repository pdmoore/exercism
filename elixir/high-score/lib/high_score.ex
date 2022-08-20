defmodule HighScore do
  def new() do
    %{}
  end

  def add_player(scores, name), do: add_player(scores, name, 0)
  def add_player(scores, name, score) do
    Map.put_new(scores, name, score)
  end

  def remove_player(scores, name) do
    Map.delete(scores, name)
  end

  def reset_score(scores, name) do
    Map.put(scores, name, 0)
  end

  def update_score(scores, name, score) do
    cond do
      Map.has_key?(scores, name) -> add_score(scores, name, score)
      true -> Map.put(scores, name, score)
    end
  end

  def add_score(scores, name, score) do
    current_score = Map.get(scores, name)
    Map.replace(scores, name, current_score + score)
  end
  def get_players(scores) do
    # Please implement the get_players/1 function
  end
end
