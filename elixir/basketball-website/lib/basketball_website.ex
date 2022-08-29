defmodule BasketballWebsite do
  def extract_from_path(data, path) do

    paths = String.split(path, ".", parts: 2)
    if length(paths) == 1 do
      data[path]
    else
      next = data[List.first(paths)]
      extract_from_path(next, List.last(paths))
    end
  end

  def get_in_path(data, path) do
    paths = String.split(path, ".")
    Kernel.get_in(data, paths)
  end
end
