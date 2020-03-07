using System;
using System.Collections.Generic;

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
        List<Allergen> allergens = new List<Allergen>();
        for (int i = 0; i < Enum.GetNames(typeof(Allergen)).Length; i++)
        {
            int allergenBit = (int) Math.Pow(2, i);
            if ((_mask & allergenBit) != 0)
            {
                allergens.Add((Allergen)i);
            }
        }
        
        return allergens.ToArray();
    }
}