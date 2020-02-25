using System;

public class Robot
{
    private string _prefix = "AA";
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
        Name = _prefix + _counter.ToString("D3");
        ++_counter;
        if (_counter > 999)
        {
            _counter = 0;
            _prefix = "AB";
        }
    }

    public string Name { get; private set; }

    public void Reset() => GenerateNewName();
}