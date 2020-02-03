using System;
using System.Runtime.InteropServices.WindowsRuntime;

public class SpaceAge {
    private const double SECONDS_PER_EARTH_YEAR = 31557600;

    private readonly long _ageInSeconds;

    public SpaceAge(long ageInSeconds) {
        this._ageInSeconds = ageInSeconds;
    }

    public double OnEarth() {
        return ToTwoDecimals(_ageInSeconds / SECONDS_PER_EARTH_YEAR);
    }

    public double OnMercury() {
        return AgeRelativeToEarthYear(0.2408467);
    }

    public double OnVenus() {
        return AgeRelativeToEarthYear(0.61519726);
    }

    public double OnMars() {
        return AgeRelativeToEarthYear(1.8808158);
    }

    public double OnJupiter() {
        return AgeRelativeToEarthYear(11.862615);
    }

    public double OnSaturn() {
        return AgeRelativeToEarthYear(29.447498);
    }

    public double OnUranus() {
        return AgeRelativeToEarthYear(84.016846);
    }

    public double OnNeptune() {
        return AgeRelativeToEarthYear(164.79132);
    }

    private double AgeRelativeToEarthYear(double earthYearMultiplier) {
        return ToTwoDecimals(_ageInSeconds / (SECONDS_PER_EARTH_YEAR * earthYearMultiplier));
    }

    private double ToTwoDecimals(double age) {
        return Math.Round(age, 2);
    }
}