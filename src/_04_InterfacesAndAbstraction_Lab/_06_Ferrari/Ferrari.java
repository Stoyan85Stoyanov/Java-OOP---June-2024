package _04_InterfacesAndAbstraction_Lab._06_Ferrari;

public class Ferrari implements Car {

    private String driverName;
    private static final String MODEL = "488-Spider";

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }


    public String getDriverName() {
        return driverName;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {

        return String.format("%s/%s/%s/%s", MODEL, brakes(), gas(), getDriverName());
    }
}
