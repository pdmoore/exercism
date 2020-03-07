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

    public bool IsAllergicTo(Allergen allergen) => (_mask & (1 << (int) allergen)) != 0;

    public Allergen[] List() =>
        Enum.GetValues(typeof(Allergen)).
            Cast<Allergen>().
            Where(IsAllergicTo).
            ToArray();
}