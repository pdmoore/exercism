defmodule NameBadge do
  def print(id, name, department) do
    "[#{id}] - " <> name <> " - " <> department
  end
end
