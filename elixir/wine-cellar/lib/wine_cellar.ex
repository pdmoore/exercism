defmodule WineCellar do
  def explain_colors do
    [
      white: "Fermented without skin contact.",
      red: "Fermented with skin contact using dark-colored grapes.",
      rose: "Fermented with some skin contact, but not enough to qualify as a red wine."
    ]
  end

  def filter(cellar, color, opts \\ []) do
    # color is an :atom
    # cellar is a keylist
    # opts is an atomvalue combo

    # want to match cellar keylist where key is atom
    by_color = Keyword.get_values(cellar, color)

    if Keyword.has_key?(opts, :year) do
      year = Keyword.get(opts, :year)
      by_color |> filter_by_year(year)
    else

      if Keyword.has_key?(opts, :country) do
        country = Keyword.get(opts, :country)
        by_color |> filter_by_country(country)
      else
        by_color
      end
    end

#    cond do
#      opts == [] -> by_color
#       ->
#       year = Keyword.get(opts, :year)
#       by_color |> filter_by_year(year)
#    end

  end

  # The functions below do not need to be modified.

  defp filter_by_year(wines, year)
  defp filter_by_year([], _year), do: []

  defp filter_by_year([{_, year, _} = wine | tail], year) do
    [wine | filter_by_year(tail, year)]
  end

  defp filter_by_year([{_, _, _} | tail], year) do
    filter_by_year(tail, year)
  end

  defp filter_by_country(wines, country)
  defp filter_by_country([], _country), do: []

  defp filter_by_country([{_, _, country} = wine | tail], country) do
    [wine | filter_by_country(tail, country)]
  end

  defp filter_by_country([{_, _, _} | tail], country) do
    filter_by_country(tail, country)
  end
end
