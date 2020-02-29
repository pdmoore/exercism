using System;
using System.Collections.Generic;

public class Robot
{
    private static readonly Random Random = new Random();
    private static readonly HashSet<string> AllRobotNames = new HashSet<string>();
    private const char FROM_A = 'A';
    private const char TO_Z = '[';
    private const int FROM_0 = 0;
    private const int TO_9 = 10;

    public Robot() => GenerateNewName();

    public string Name { get; private set; }
    
    public void Reset()
    {
        AllRobotNames.Remove(Name);
        GenerateNewName();
    }

    private void GenerateNewName()
    {
        do
        {
            var candidateName = TwoRandomLetters() + ThreeRandomDigits();
            AssignNameIfUnique(candidateName);
        } while (Name == null);
    }

    private static string ThreeRandomDigits() => RandomDigit() + RandomDigit() + RandomDigit();
    
    private static string RandomDigit() => "" + Random.Next(FROM_0, TO_9);

    private static string TwoRandomLetters() => RandomLetter() + RandomLetter();
    
    private static string RandomLetter() => ((char)Random.Next(FROM_A, TO_Z)).ToString();

    private void AssignNameIfUnique(string candidateName) {
        if (AllRobotNames.Add(candidateName)) {
            Name = candidateName;
        }
    }
}
