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

    []
  end

  def register(pid, register_to) do
    plot = %Plot{plot_id: 1, registered_to: register_to}
    Agent.update(pid, fn plots -> [plot | plots] end)
    plot
  end

  def release(pid, plot_id) do
    # Please implement the release/2 function
  end

  def get_registration(pid, plot_id) do
    # Please implement the get_registration/2 function
  end
end
