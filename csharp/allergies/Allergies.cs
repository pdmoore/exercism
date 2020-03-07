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

    public bool IsAllergicTo(Allergen allergen) => MaskHasAllergyTo(_mask, (int) allergen);

    private static bool MaskHasAllergyTo(int mask, int allergenIndex) {
        int allergenBit = (int) Math.Pow(2, allergenIndex);

        return (mask & allergenBit) != 0;
    }

    public Allergen[] List()
    {
        List<Allergen> allergens = new List<Allergen>();
        for (int i = 0; i < Enum.GetNames(typeof(Allergen)).Length; i++)
        {
            if (MaskHasAllergyTo(_mask, i))
            {
                allergens.Add((Allergen)i);
            }
        }
        
        return allergens.ToArray();
    }
}