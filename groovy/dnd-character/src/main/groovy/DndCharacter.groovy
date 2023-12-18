class DndCharacter {

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
        if (constitution <= 11) {
            return (constitution - 11) / 2;
        }

        return (constitution - 10) / 2;
    }

    int ability() {
        // TODO - random between 3 & 18
        return 7;
    }

    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;
    int hitpoints;



}