package _01_WorkingWithAbstraction._01_Lab._04_HotelReservation;

public enum DiscountType {
    VIP(0.80),
    SECOND_VISIT(0.90),
    NONE(1.00);

    private final double value;

    DiscountType(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public static DiscountType fromString(String str) {
        return switch (str) {
            case "VIP" -> VIP;
            case "SecondVisit" -> SECOND_VISIT;
            case "None" -> NONE;
            default -> throw new IllegalArgumentException("Unsupported discount type " + str);
        };
    }
}

