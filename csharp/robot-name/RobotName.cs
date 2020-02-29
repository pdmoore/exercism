using System;
using System.Collections.Generic;

public class Robot
{
    private static readonly Random Random = new Random();
    private static readonly HashSet<string> AllRobotNames = new HashSet<string>();

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

    private static string ThreeRandomDigits() => "" + RandomDigit() + RandomDigit() + RandomDigit();
    
    private static string RandomDigit() => "" + Random.Next(0, 10);
    
    private static string TwoRandomLetters() => RandomLetter() + RandomLetter();
    
    private static string RandomLetter() => ((char)Random.Next('A', '[')).ToString();
    
    private void AssignNameIfUnique(string candidateName) {
        if (AllRobotNames.Add(candidateName)) {
            Name = candidateName;
        }
    }
}
