defmodule NameBadge do
  def print(id, name, department) do
    upcased_department = department |> String.upcase
    "[#{id}] - " <> name <> " - " <> upcased_department
  end
end
