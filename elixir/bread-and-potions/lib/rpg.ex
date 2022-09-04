defmodule RPG do
  defprotocol Edible do
    def eat(item, character)
  end

  defmodule Character do
    defstruct health: 100, mana: 0
  end

  defmodule LoafOfBread do
    defstruct []
  end

  defmodule ManaPotion do
    defstruct strength: 10
  end

      defmodule Poison do
    defstruct []
  end

  defmodule EmptyBottle do
    defstruct []
  end

  # Add code to define the protocol and its implementations below here...
  defimpl Edible, for: LoafOfBread do
    def eat(_, character) do
      current_health = character.health
      {nil, %{character | health: current_health + 5}}
    end
  end

  defimpl Edible, for: ManaPotion do
    def eat(potion, character) do
      current_mana = character.mana
      potion_strength = potion.strength
      {%RPG.EmptyBottle{}, %{character | mana: current_mana + potion_strength}}
    end
  end

  defimpl Edible, for: Poison do
    def eat(_, character) do
      {%RPG.EmptyBottle{}, %{character | health: 0}}
    end
  end

end
