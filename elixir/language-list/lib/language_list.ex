defmodule LanguageList do
  def new() do
    []
  end

  def add(list, language) do
    [language | list]
  end

  def remove(list) do
    tl(list)
  end

  def first(list) do
    List.first(list)
  end

  def count(list) do
    Kernel.length(list)
  end

  def functional_list?(list) do
    Enum.member?(list, "Elixir")
  end
end
