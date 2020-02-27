using System;
using System.Collections.Generic;

public class Robot
{
    private static readonly Random Random = new Random();
    private static readonly HashSet<string> AllRobotNames = new HashSet<string>();

    public Robot() => GenerateNewName();

    private void GenerateNewName()
    {
        while (true)
        {
            var candidateName = TwoRandomLetters() + ThreeRandomDigits();
            if (!AllRobotNames.Add(candidateName))
            {
                continue;
            }

            Name = candidateName;
            return;
        }
    }

    private string ThreeRandomDigits() => "" + RandomDigit() + RandomDigit() + RandomDigit();

    private string RandomDigit() => "" + Random.Next(0, 10);

    private string TwoRandomLetters() => RandomLetter() + RandomLetter();

    private static string RandomLetter() => ((char)Random.Next('A','Z')).ToString();

    public string Name { get; private set; }

    public void Reset()
    {
        AllRobotNames.Remove(Name);
        GenerateNewName();
    }
}