defmodule Strain do
  @doc """
  Given a `list` of items and a function `fun`, return the list of items where
  `fun` returns true.

  Do not use `Enum.filter`.
  """
  @spec keep(list :: list(any), fun :: (any -> boolean)) :: list(any)
  def keep(list, fun) do
    retain(list, fun)
  end

  defp retain([head | tail], fun) do
    if (fun.(head)) do
      [head | retain(tail, fun)]
    else
      retain(tail,fun)
    end
  end
  defp retain([], _fun), do: []

  @doc """
  Given a `list` of items and a function `fun`, return the list of items where
  `fun` returns false.

  Do not use `Enum.reject`.
  """
  @spec discard(list :: list(any), fun :: (any -> boolean)) :: list(any)
  def discard(list, fun) do
    drop(list, fun)
  end

  defp drop([head | tail], fun) do
    if (!fun.(head)) do
      [head | drop(tail, fun)]
    else
      drop(tail,fun)
    end
  end
  defp drop([], _fun), do: []

end
