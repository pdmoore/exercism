using System;
using System.Collections.Generic;

public class Robot
{
    private static readonly Random Random = new Random();
    private static readonly HashSet<string> AllRobotNames = new HashSet<string>();

    public Robot()
    {
        GenerateNewName();
    }

    private void GenerateNewName()
    {
        while (true)
        {
            var candidateName = TwoRandomLetters() + ThreeRandomDigits();
            if (AllRobotNames.Add(candidateName))
            {
                Name = candidateName;
                break;
            }
        }
    }

    private string ThreeRandomDigits()
    {
        return "" + RandomDigit() + RandomDigit() + RandomDigit();
    }

    private string RandomDigit()
    {
        return "" + Random.Next(0, 10);
    }

    private string TwoRandomLetters()
    {
        return RandomLetter() + RandomLetter();
    }

    private string RandomLetter()
    {
        //TODO - better way to return string?
        int number = Random.Next(0, 26);
        return "" + (char)('A' + number);
    }

    public string Name { get; private set; }

    public void Reset()
    {
        AllRobotNames.Remove(Name);
        GenerateNewName();
    }
}