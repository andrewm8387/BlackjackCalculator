public enum Cards {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    public int value() {
        switch (this) {
            case ACE -> {
                return 11;
            }
            case TWO -> {
                return 2;
            }
            case THREE -> {
                return 3;
            }
            case FOUR -> {
                return 4;
            }
            case FIVE -> {
                return 5;
            }
            case SIX -> {
                return 6;
            }
            case SEVEN -> {
                return 7;
            }
            case EIGHT -> {
                return 8;
            }
            case NINE -> {
                return 9;
            }
            case TEN, JACK, QUEEN, KING -> {
                return 10;
            }
            default -> throw new IllegalStateException(this + " is not a valid card and has no value.");
        }
    }

}

