class DnDCharacter {

    int ability() {
        return 5;
    }

    int modifier(int consitution) {
        /*
         You find your character's constitution modifier by subtracting 10 from your character's constitution, divide by 2 and round down.
         */
        return Math.floorDiv(consitution - 10, 2);
    }

    public int getStrength() {
        return ability();
    }

    public int getDexterity() {
        return ability();
    }

    public int getConstitution() {
        return ability();
    }

    public int getIntelligence() {
        return ability();
    }

    public int getWisdom() {
        return ability();
    }

    public int getCharisma() {
        return ability();
    }

    public int getHitpoints() {
        return 10 + modifier(getConstitution());
    }
}
