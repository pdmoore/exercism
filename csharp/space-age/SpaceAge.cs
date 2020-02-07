using System;
using System.Runtime.InteropServices.WindowsRuntime;

public class SpaceAge {
    private const double SECONDS_PER_EARTH_YEAR = 31557600;

    private readonly long _ageInSeconds;

    public SpaceAge(long ageInSeconds) {
        this._ageInSeconds = ageInSeconds;
    }
    
    public double OnMercury() => AgeRelativeToEarthYear(0.2408467);

    public double OnVenus() => AgeRelativeToEarthYear(0.61519726);

    public double OnEarth() => AgeRelativeToEarthYear(1.0);

    public double OnMars() => AgeRelativeToEarthYear(1.8808158);

    public double OnJupiter() => AgeRelativeToEarthYear(11.862615);

    public double OnSaturn() => AgeRelativeToEarthYear(29.447498);

    public double OnUranus() => AgeRelativeToEarthYear(84.016846);

    public double OnNeptune() => AgeRelativeToEarthYear(164.79132);

    private double AgeRelativeToEarthYear(double earthYearMultiplier) => 
        ToTwoDecimals(_ageInSeconds / (SECONDS_PER_EARTH_YEAR * earthYearMultiplier));

    private double ToTwoDecimals(double age) {
        return Math.Round(age, 2);
    }
}