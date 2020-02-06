using System;

public static class ResistorColor
{
    public static int ColorCode(string color)
    {
        switch (color)
        {
            case "black"  : return 0;
            case "orange" : return 3;
        }
        
        return 9;
    }

    public static string[] Colors() => new[] {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
}