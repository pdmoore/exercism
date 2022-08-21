defmodule NameBadge do
  def print(id, name, department) do
    if department == nil do
      if id == nil do
        name <> " - OWNER"
      else
        "[#{id}] - " <> name <> " - OWNER"
      end
    else
    upcased_department = department |> String.upcase
    if id == nil do
      name <> " - " <> upcased_department
    else
      "[#{id}] - " <> name <> " - " <> upcased_department
    end
    end
  end
end
