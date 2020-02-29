using System;
using System.Collections.Generic;

public class Robot
{
    private static readonly Random Random = new Random();
    private static readonly HashSet<string> AllRobotNames = new HashSet<string>();
    private const char FromA = 'A';
    private const char ToZ = '[';
    private const int From0 = 0;
    private const int To9 = 10;

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
    
    private static string RandomDigit() => "" + Random.Next(From0, To9);

    private static string TwoRandomLetters() => RandomLetter() + RandomLetter();
    
    private static string RandomLetter() => ((char)Random.Next(FromA, ToZ)).ToString();

    private void AssignNameIfUnique(string candidateName) {
        if (AllRobotNames.Add(candidateName)) {
            Name = candidateName;
        }
    }
}
