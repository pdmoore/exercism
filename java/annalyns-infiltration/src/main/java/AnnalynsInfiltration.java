class AnnalynsInfiltration {
    public static boolean canFastAttack(boolean knightIsAwake) {
        return !knightIsAwake;
    }

    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        boolean everyoneIsAsleep = !knightIsAwake && !archerIsAwake && !prisonerIsAwake;
        return  !everyoneIsAsleep;
    }

    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        return prisonerIsAwake && !archerIsAwake;
    }

    public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake, boolean petDogIsPresent) {
        boolean foesAreAsleep = !knightIsAwake && !archerIsAwake;
        if (foesAreAsleep && prisonerIsAwake) return true;

        return (petDogIsPresent && !archerIsAwake);
    }
}
