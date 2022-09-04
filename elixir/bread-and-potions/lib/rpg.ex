defmodule RPG do
  defprotocol Edible do
    #TODO? returns a by-product and a character.
    def eat(item, character)
  end

  defmodule Character do
    defstruct health: 100, mana: 0
  end

  defmodule LoafOfBread do
    defstruct []
  end

  defimpl Edible, for: LoafOfBread do
    def eat(item, character) do

    end
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
end
