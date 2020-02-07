using System;
using System.Linq;

public static class ResistorColor
{
    private static readonly string[] COLOR_NAMES = new[] {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

    public static int ColorCode(string color) => Array.IndexOf(Colors(), color);

    public static string[] Colors() => COLOR_NAMES;
}
