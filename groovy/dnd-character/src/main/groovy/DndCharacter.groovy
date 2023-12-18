class DndCharacter {

    int modifier(int constitution) {
        if (constitution <= 11) {
            return (constitution - 11) / 2;
        }

        return (constitution - 10) / 2;
    }
}
