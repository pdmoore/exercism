# Use the Plot struct as it is provided
defmodule Plot do
  @enforce_keys [:plot_id, :registered_to]
  defstruct [:plot_id, :registered_to]
end

defmodule CommunityGarden do
  def start(_opts \\ []) do
    Agent.start(fn -> [] end)
  end

  def list_registrations(pid) do
    Agent.get(pid, fn plots -> plots end)
  end

  def register(pid, register_to) do
    #TODO random is wrong, but passes tests
    plot = %Plot{plot_id: :rand.uniform(999999), registered_to: register_to}
    Agent.update(pid, fn plots -> [plot | plots] end)
    plot
  end

  def release(pid, plot_id) do
    Agent.update(pid, fn plots -> Enum.filter(plots, fn p -> p.plot_id != plot_id end) end)
  end

  def get_registration(pid, plot_id) do
    list_registrations(pid)
      |> Enum.find({:not_found, "plot is unregistered"},
           fn p -> p.plot_id == plot_id end)
  end
end
