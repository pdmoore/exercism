using System;

public static class Gigasecond
{
    private const int NoHours = 0;
    private const int NoMinutes = 0;
    private static readonly int GigaSeconds = Convert.ToInt32(Math.Pow(10, 9));
    private static readonly TimeSpan OneGigasecond = new TimeSpan(NoHours, NoMinutes, GigaSeconds);

    public static DateTime Add(DateTime birthDate) => birthDate.Add(OneGigasecond);
}