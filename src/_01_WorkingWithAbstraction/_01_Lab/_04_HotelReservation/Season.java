package _01_WorkingWithAbstraction._01_Lab._04_HotelReservation;

public enum Season {
    SPRING(2),
    SUMMER(4),
    AUTUMN(1),
    WINTER(3);

    private final int multiplier;

    Season(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
