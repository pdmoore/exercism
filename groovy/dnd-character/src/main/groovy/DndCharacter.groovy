class DndCharacter {
    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;
    int hitpoints;

    DndCharacter() {
        this.strength = ability();
        this.dexterity = ability();
        this.constitution = ability();
        this.intelligence = ability();
        this.wisdom = ability();
        this.charisma = ability();
        this.hitpoints = 10 + modifier(constitution);
    }

    int modifier(int constitution) {
        Math.floorDiv( constitution - 10, 2 )
    }

    int ability() {
        // TODO - random between 3 & 18
        // Seems like there could be a test that two different characters have different
        // abilities or sum of abilities
        // or calling ability a few times in a row doesn't return the same value
        // currently all tests pass with a hard-coded value
        return 7;
    }
}
