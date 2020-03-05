using System;

public enum Allergen
{
    Eggs,
    Peanuts,
    Shellfish,
    Strawberries,
    Tomatoes,
    Chocolate,
    Pollen,
    Cats
}

public class Allergies
{
    private int _mask;

    public Allergies(int mask)
    {
        _mask = mask;
    }

    public bool IsAllergicTo(Allergen allergen)
    {
        int allergenValue = (int) allergen + 1;

        int isBitSet = _mask & allergenValue;
        
        return isBitSet != 0;
    }

    public Allergen[] List()
    {
        throw new NotImplementedException("You need to implement this function.");
    }
}