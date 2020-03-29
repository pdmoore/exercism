using System;
using System.Text;

public class Clock
{
    private readonly int _minutes;
    private const int HoursPerDay = 24;
    private const int MinutesPerHour = 60;
    private const string AsTwoDigits = "D2";

    public Clock(int hours, int minutes)
    {
        _minutes = minutes + (hours * 60);

        while (_minutes < 0)
        {
            _minutes += MinutesPerHour * HoursPerDay;
        }
    }

    public Clock Add(int minutesToAdd) => new Clock(0, _minutes + minutesToAdd);

    public Clock Subtract(int minutesToSubtract) => Add(0 - minutesToSubtract);

    public override string ToString()
    {
        int hours = (_minutes / MinutesPerHour) % HoursPerDay;
        int minutes = _minutes % MinutesPerHour;

        StringBuilder sb = new StringBuilder();
        sb.Append(hours.ToString(AsTwoDigits));
        sb.Append(":");
        sb.Append(minutes.ToString(AsTwoDigits));
        return sb.ToString();
    }

    public override bool Equals(object? obj) => this.ToString().Equals(obj.ToString());
}