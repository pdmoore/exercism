defmodule NameBadge do
  def print(id, name, department) do
    printable_id = id_from(id)
    if department == nil do
      if id == nil do
        name <> " - OWNER"
      else
        printable_id <> name <> " - OWNER"
      end
    else
    upcased_department = department |> String.upcase
    if id == nil do
      name <> " - " <> upcased_department
    else
      printable_id <> name <> " - " <> upcased_department
    end
    end
  end

  defp id_from(id) do
    if id == nil do
      ""
    else
      "[#{id}] - "
    end
  end
end
