defmodule NameBadge do
  def print(id, name, department) do
    printable_id = if id == nil, do: "", else: "[#{id}] - "
    printable_department = if department == nil, do: " - OWNER", else: " - " <> department |> String.upcase
    printable_id <> name <> printable_department
  end
end
