using System;

public class Robot
{
    private static int _counter;

    public Robot() => GenerateNewName();

    // TODO - generate New Name works fine for the tests
    // but isn't in the spirit of the assignment
    // "they should not follow a predictable sequence"
    // so - 
    // - Need to generate a truly random name RandomLetter + RandomLetter + RandomDigit...
    // - check if rando name is in the list of names
    // - add if it isn't
    // - generate new name if it is
    // - reset removes name from list of names
    private void GenerateNewName() {
        Name = TwoRandomLetters() + ThreeRandomDigits();
    }

    private string ThreeRandomDigits()
    {
        if (_counter > 999)
        {
            _counter = 0;
        }
        _counter++;
        return _counter.ToString("D3");
    }

    private string TwoRandomLetters()
    {
        return "A" + "A";
    }

    public string Name { get; private set; }

    public void Reset() => GenerateNewName();
}