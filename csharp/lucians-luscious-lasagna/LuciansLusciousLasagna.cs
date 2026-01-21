class Lasagna
{
    private int expectedMinutesInOven = 40;
    private int preparationTimePerLayer = 2;
    
    public int ExpectedMinutesInOven() => expectedMinutesInOven;

    public int RemainingMinutesInOven(int minutesInOven) => ExpectedMinutesInOven() - minutesInOven;

    public int PreparationTimeInMinutes(int numberOfLayers) => numberOfLayers * preparationTimePerLayer;

    public int ElapsedTimeInMinutes(int numberOfLayers, int minutesInOven) => PreparationTimeInMinutes(numberOfLayers) + minutesInOven;
}
