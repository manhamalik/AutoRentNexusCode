import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vehicle {
    private int id;
    private String model;
    private double rentalPrice;
    private boolean availability;
    private VehicleType vehicleType;
    private List<Booking> bookings;

    public Vehicle(int id, String model, double rentalPrice, boolean availability, VehicleType vehicleType) {
        this.id = id;
        this.model = model;
        this.rentalPrice = rentalPrice;
        this.availability = availability;
        this.vehicleType = vehicleType;
        this.bookings = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public boolean isAvailable() {
        return availability;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public void setAvailability(int vehicleID, boolean status) {
        if (this.id == vehicleID) {
            this.availability = status;
        }
    }

    public boolean getAvailability(int vehicleID, Date startDate, Date endDate) {
        if (this.id == vehicleID) {
            for (Booking booking : bookings) {
                if (startDate.before(booking.getEndDate()) && endDate.after(booking.getStartDate())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public boolean isAvailableForDates(Date startDate, Date endDate) {
        for (Booking booking : bookings) {
            if (startDate.before(booking.getEndDate()) && endDate.after(booking.getStartDate())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vehicle ID: " + id +
                "\n----------------" +
                "\nModel: '" + model + '\'' +
                "\nPrice/day: $" + rentalPrice +
                "\nAvailable: " + availability +
                "\nType: " + vehicleType + "\n";
    }
}
