public enum VehicleType {
    SUV("SUV", 60),
    TRUCK("Truck", 80),
    VAN("Van", 100),
    CONVERTIBLE("Convertible", 70),
    WAGON("Wagon", 50),
    EV("Electric Vehicle", 50),
    ECONOMY("Economy Car", 40),
    SPORTS("Sports Car", 100);

    private final String type;
    private final double pricePerDay;

    VehicleType(String type, double pricePerDay) {
        this.type = type;
        this.pricePerDay = pricePerDay;
    }

    public String getType() {
        return type;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public String toString() {
        return type;
    }
}
