defmodule BasketballWebsite do
  def extract_from_path(data, []), do: data
  def extract_from_path(data, [h | t]), do: extract_from_path(data[h], t)
  def extract_from_path(data, path) do
    paths = String.split(path, ".")
    extract_from_path(data, paths)
  end

  def get_in_path(data, path) do
    paths = String.split(path, ".")
    Kernel.get_in(data, paths)
  end
end
