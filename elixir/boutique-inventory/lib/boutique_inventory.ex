defmodule BoutiqueInventory do
  def sort_by_price(inventory) do
    Enum.sort_by(inventory, fn(i) -> i.price end)
  end

  def with_missing_price(inventory) do
    Enum.filter(inventory, fn(i) -> i.price == nil end)
  end

  def update_names(inventory, old_word, new_word) do
    Enum.map(inventory, fn item -> update_name(item, old_word, new_word) end)
  end

  defp update_name(item, old_word, new_word) do
    %{item | name: String.replace(item[:name], old_word, new_word)}
  end

  def increase_quantity(item, count) do
    quantities_after = increase_quantity_of_each(item[:quantity_by_size], count)
    %{item | quantity_by_size: quantities_after}
  end

  defp increase_quantity_of_each(quantity_by_size, increase_by) do
    Map.new(quantity_by_size, fn {size, quantity} -> {size, quantity + increase_by} end)
  end

  def total_quantity(item) do
    Enum.reduce(item[:quantity_by_size], 0, fn {_size, quantity_of_this_size},
      quantity_of_all_sizes -> quantity_of_all_sizes + quantity_of_this_size end)
  end
end
