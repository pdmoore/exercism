class DndCharacter {

    int modifier(int constitution) {
        switch (constitution) {
            case 3: return (constitution - 11) / 2;
            case 4:
            case 5: return (constitution - 11) / 2;
            case 6:
                case 7: return (constitution - 11) / 2;
            case 8:
                case 9: return (constitution - 11) / 2;

        }

        int ;

        return 0;
    }
}
