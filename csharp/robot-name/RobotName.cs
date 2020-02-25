using System;

public class Robot
{
    private const string Prefix = "AB";
    private static int _counter;

    public Robot() => GenerateNewName();

    private void GenerateNewName() {
        Name = Prefix + _counter.ToString("D3");
        ++_counter;
    }

    public string Name { get; private set; }

    public void Reset() => GenerateNewName();
}