using System;

public class Robot
{
    private string _prefix = "AA";
    private static int _counter;

    public Robot() => GenerateNewName();

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