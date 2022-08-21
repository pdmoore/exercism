defmodule NameBadge do
  def print(id, name, department) do
    printable_id = if id == nil, do: "", else: "[#{id}] - "
    printable_department = department_from(department)
    printable_id <> name <> printable_department
  end

  defp department_from(department) do
    if department == nil do
      " - OWNER"
    else
      upcased_department = department |> String.upcase
      " - " <> upcased_department
    end
  end
end
