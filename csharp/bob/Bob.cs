using System;
using System.Text.RegularExpressions;

public static class Bob
{
    public static string Response(string statement)
    {
        var TrimmedStatement = statement.Trim();
        var Silent = isSilent(TrimmedStatement);
        var Shouting = isShouting(TrimmedStatement);
        var Questioning = isQuestioning(TrimmedStatement);

        if (Silent)
        {
            return "Fine. Be that way!";
        } 
        else if (Questioning && Shouting)
        {
            return "Calm down, I know what I'm doing!";
        }
        else if (Questioning)
        {
            return "Sure.";
        }
        else if (Shouting)
        {
            return "Whoa, chill out!";
        }

        return "Whatever.";
    }

    private static bool isSilent(string statement)
    {
        return statement.Length == 0;
    }

    private static bool isQuestioning(string statement)
    {
        return statement.EndsWith("?");
    }

    private static bool isShouting(string statement)
    {
        String UpperCase = statement.ToUpper();
        Boolean HasLetters = (Regex.Matches(UpperCase, @"[A-Z]").Count > 0);
        return statement.Equals(UpperCase) && HasLetters;
    }
}