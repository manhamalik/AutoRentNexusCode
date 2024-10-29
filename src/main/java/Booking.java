import java.util.Date;

public class Booking {
    private int bookingId;
    private int vehicleId;
    private int customerId;
    private Date startDate;
    private Date endDate;
    private double totalCost;
    private boolean confirmed;

    public Booking(int bookingId, int vehicleId, int customerId, Date startDate, Date endDate, double totalCost, boolean confirmed) {
        this.bookingId = bookingId;
        this.vehicleId = vehicleId;
        this.customerId = customerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
        this.confirmed = confirmed;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public double calculateCost(double dailyRate, int numberOfDays) {
        return dailyRate * numberOfDays;
    }

    public Invoice generateInvoice(int bookingId, double totalCost, Date paymentDate, String paymentMethod) {
        return new Invoice(bookingId, totalCost, totalCost, paymentDate, paymentMethod);
    }

    public Vehicle getVehicle() {
        for (Vehicle vehicle : Main.getVehicles()) {
            if (vehicle.getId() == this.vehicleId) {
                return vehicle;
            }
        }
        return null;
    }

    public int getBookingID() {
        return bookingId;
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId +
                "\n----------------" +
                "\nVehicle ID: " + vehicleId +
                "\nCustomer ID: " + customerId +
                "\nStart Date:" + startDate +
                "\nEnd Date:" + endDate +
                "\nTotal Cost: $" + totalCost +
                "\nConfirmed: " + confirmed + "\n";
    }
}
