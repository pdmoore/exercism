class SpaceAge {

    private final int EARTH_SECONDS_PER_YEAR = 31557600;
    private final double EARTH   = 1.0;
    private final double JUPITER = 11.862615;
    private final double MARS    = 1.8808158;
    private final double MERCURY = 0.2408467;
    private final double NEPTUNE = 164.79132;
    private final double SATURN  = 29.447498;
    private final double URANUS  = 84.016846;
    private final double VENUS   = 0.61519726;

    private double ageInSeconds;

    SpaceAge(double seconds) {
        this.ageInSeconds = seconds;
    }

    double getSeconds() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    private double onPlanet(double planetOrbitalPeriodRelativeToEarth) {
        double secondsOnPlanet = EARTH_SECONDS_PER_YEAR * planetOrbitalPeriodRelativeToEarth;
        return ageInSeconds / secondsOnPlanet;
    }

    double onEarth() {
        return onPlanet(EARTH);
    }

    double onMercury() {
        return onPlanet(MERCURY);
    }

    double onVenus() {
        return onPlanet(VENUS);
    }

    double onMars() {
        return onPlanet(MARS);
    }

    double onJupiter() {
        return onPlanet(JUPITER);
    }

    double onSaturn() {
        return onPlanet(SATURN);
    }

    double onUranus() {
        return onPlanet(URANUS);
    }

    double onNeptune() {
        return onPlanet(NEPTUNE);
    }

}
