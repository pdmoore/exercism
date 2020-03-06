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
        int allergenBit = (int) Math.Pow(2, (int) allergen);

        return (_mask & allergenBit) != 0;
    }

    public Allergen[] List()
    {
        return new Allergen[0];
    }
}