public enum Actions {
    HIT, STAND, DOUBLE, SPLIT;

    public String toString() {
        switch (this) {
            case HIT -> {
                return "Hit";
            }
            case STAND -> {
                return "Stand";
            }
            case DOUBLE -> {
                return "Double";
            }
            case SPLIT -> {
                return "Split";
            }
            default -> {
                return "Error";
            }
        }
    }
}
