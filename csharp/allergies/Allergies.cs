using System;
using System.Collections.Generic;
using System.Linq;

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

    public bool IsAllergicTo(Allergen allergen) => MaskHasAllergyTo(allergen);

    public Allergen[] List() =>
        Enum.GetValues(typeof(Allergen)).
            Cast<Allergen>().
            Where(MaskHasAllergyTo).
            ToArray();

    private bool MaskHasAllergyTo(Allergen allergy)
    {
        int allergenBit = (int) Math.Pow(2, (int) allergy);

        return (_mask & allergenBit) != 0;
    }
}