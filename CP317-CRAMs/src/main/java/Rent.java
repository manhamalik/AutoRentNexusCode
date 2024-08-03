public class Rent {
    private int vehicleId;
    private int customerId;

    public Rent(int vehicleId, int customerId) {
        this.vehicleId = vehicleId;
        this.customerId = customerId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public int getCustomerId() {
        return customerId;
    }
}
