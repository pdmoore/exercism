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
        StringBuilder sb = new StringBuilder();
        sb.Append(Hours().ToString(AsTwoDigits));
        sb.Append(":");
        sb.Append(Minutes().ToString(AsTwoDigits));
        return sb.ToString();
    }

    public override bool Equals(object obj)
    {
        if (ReferenceEquals(null, obj)) return false;
        if (ReferenceEquals(this, obj)) return true;
        return obj.GetType() == this.GetType() && Equals((Clock) obj);
    }

    public override int GetHashCode()
    {
        unchecked
        {
            return (Hours() * 397) ^ Minutes();
        }
    }

    private bool Equals(Clock other) => Hours() == other.Hours() && Minutes() == other.Minutes();

    private int Minutes() => _minutes % MinutesPerHour;

    private int Hours() => (_minutes / MinutesPerHour) % HoursPerDay;

}