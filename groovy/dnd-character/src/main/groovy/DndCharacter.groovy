class DndCharacter {

    int modifier(int constitution) {
        switch (constitution) {
            case 3: return -4;
            case 4:
            case 5: return -3;
            case 6:
                case 7: return -2;

        }
        return constitution - 7;
    }
}
