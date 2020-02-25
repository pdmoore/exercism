using System;
using System.Collections.Generic;

public class Robot
{
    private List<string> _allRobotNames;
    private static Random _random;

    public Robot()
    {
        _random = new Random();
        _allRobotNames = new List<string>();

        GenerateNewName();
    }

    private void GenerateNewName()
    {
        while (true)
        {
            var candidateName = TwoRandomLetters() + ThreeRandomDigits();
            if (!_allRobotNames.Contains(candidateName))
            {
                _allRobotNames.Add(candidateName);
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
        return "" + _random.Next(0, 10);
    }

    private string TwoRandomLetters()
    {
        return RandomLetter() + RandomLetter();
    }

    private string RandomLetter()
    {
        //TODO - better way to return string?
        int number = _random.Next(0, 26);
        return "" + (char)('A' + number);
    }

    public string Name { get; private set; }

    public void Reset()
    {
        _allRobotNames.Remove(Name);
        GenerateNewName();
    }
}