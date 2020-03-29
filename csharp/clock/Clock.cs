using System;
using System.Text;

public class Clock
{
    private readonly int _minutes;
    private readonly string TwoDecimalPlaces = "D2";
    private readonly int HoursPerDay = 24;
    private readonly int MinutesPerHour = 60;

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
        sb.Append(hours.ToString(TwoDecimalPlaces));
        sb.Append(":");
        sb.Append(minutes.ToString(TwoDecimalPlaces));
        return sb.ToString();
    }

    public override bool Equals(object? obj) => this.ToString().Equals(obj.ToString());
}