defmodule Strain do
  @doc """
  Given a `list` of items and a function `fun`, return the list of items where
  `fun` returns true.

  Do not use `Enum.filter`.
  """
  @spec keep(list :: list(any), fun :: (any -> boolean)) :: list(any)
  def keep(list, fun) do
    _keep(list, fun)
  end

  defp _keep([head | tail], fun) do
    if (fun.(head)) do
      [head | _keep(tail, fun)]
    else
      _keep(tail,fun)
    end
  end
  defp _keep([], _fun), do: []

  @doc """
  Given a `list` of items and a function `fun`, return the list of items where
  `fun` returns false.

  Do not use `Enum.reject`.
  """
  @spec discard(list :: list(any), fun :: (any -> boolean)) :: list(any)
  def discard(list, fun) do
    _discard(list, fun)
  end

  defp _discard([head | tail], fun) do
    if (!fun.(head)) do
      [head | _discard(tail, fun)]
    else
      _discard(tail,fun)
    end
  end
  defp _discard([], _fun), do: []
end
