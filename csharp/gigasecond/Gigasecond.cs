using System;

public static class Gigasecond
{
    private static readonly int NO_HOURS   = 0;
    private static readonly int NO_MINUTES = 0;
    private static readonly int GIGA_SECONDS = Convert.ToInt32(Math.Pow(10, 9));
    private static readonly TimeSpan ONE_GIGASECOND = new TimeSpan(NO_HOURS, NO_MINUTES, GIGA_SECONDS);

    public static DateTime Add(DateTime birthDate) => birthDate.Add(ONE_GIGASECOND);
}