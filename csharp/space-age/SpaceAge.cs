using System;

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
        throw new NotImplementedException("You need to implement this function.");
    }

    public double OnJupiter() {
        throw new NotImplementedException("You need to implement this function.");
    }

    public double OnSaturn() {
        throw new NotImplementedException("You need to implement this function.");
    }

    public double OnUranus() {
        throw new NotImplementedException("You need to implement this function.");
    }

    public double OnNeptune() {
        throw new NotImplementedException("You need to implement this function.");
    }
    private double AgeRelativeToEarthYear(double MercuryOfEarth) {
        return ToTwoDecimals(_ageInSeconds / (SECONDS_PER_EARTH_YEAR * MercuryOfEarth));
    }

    private double ToTwoDecimals(double age) {
        return Math.Round(age, 2);
    }
}
