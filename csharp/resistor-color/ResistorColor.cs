using System;
using System.Linq;

public static class ResistorColor
{
    public static int ColorCode(string color)
    {
        // switch (color)
        // {
        //     case "black"  : return 0;
        //     case "orange" : return 3;
        // }
        //
        // return 9;

        return Array.IndexOf(Colors(), color);
        
        
    }

    public static string[] Colors() => new[] {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
}