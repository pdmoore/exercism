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
        // given allergen (probably need power of 2)
        int allergenValue = (int) allergen + 1;
        // check if the corresponding bit is set in the mask
        int bitSet = _mask & allergenValue;
        
        
        return bitSet != 0;
    }

    public Allergen[] List()
    {
        throw new NotImplementedException("You need to implement this function.");
    }
}