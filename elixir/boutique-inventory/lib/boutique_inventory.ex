defmodule BoutiqueInventory do
  def sort_by_price(inventory) do
#    Enum.sort_by inventory, &Map.fetch(&1, :price)
    Enum.sort_by(inventory, fn(i) -> i.price end)
  end

  def with_missing_price(inventory) do
    Enum.filter(inventory, fn(i) -> i.price == nil end)
  end

  def update_names(inventory, old_word, new_word) do
    Enum.map(inventory, fn item -> update_name(item, old_word, new_word) end)
  end

  defp update_name(item, old_word, new_word) do
    updated_name = String.replace(item[:name], old_word, new_word)
    %{item | name: updated_name}
  end

  def increase_quantity(item, count) do
    # get the size map
    # Enum map each size
    # increase value by count
    # replace the sizes

    x = item[:quantity_by_size]

    %{item | quantity_by_size: x}

  end

  def total_quantity(item) do
    # Please implement the total_quantity/1 function
  end

  def replace_old_with_new( i, old_word, new_word ) do
    String.replace(i, old_word, new_word)
  end

end
