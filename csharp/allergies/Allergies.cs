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
    private readonly int _mask;

    public Allergies(int mask) => _mask = mask;

    public bool IsAllergicTo(Allergen allergen) => MaskHasAllergyTo(_mask, (int) allergen);

    private static bool MaskHasAllergyTo(int mask, int allergenIndex) {
        int allergenBit = (int) Math.Pow(2, allergenIndex);

        return (mask & allergenBit) != 0;
    }

    public Allergen[] List()
    {
        List<Allergen> allergens = new List<Allergen>();

        foreach (Allergen allergy in Enum.GetValues(typeof(Allergen)))
        {
            if (MaskHasAllergyTo(allergy))
            {
                allergens.Add(allergy);
            }
        }
        
        return allergens.ToArray();
    }

    private bool MaskHasAllergyTo(Allergen allergy)
    {
        int allergenBit = (int) Math.Pow(2, (int) allergy);

        return (_mask & allergenBit) != 0;
    }
}