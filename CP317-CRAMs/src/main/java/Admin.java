import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Admin {
    private int adminId;
    private String username;
    private String email;
    private String password;

    public Admin(int adminId, String username, String email, String password) {
        this.adminId = adminId;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getAdminId() {
        return adminId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void addVehicle(List<Vehicle> vehicles, Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println("Vehicle added successfully.");
    }

    public void updateVehicle(Vehicle vehicle, String model) {
        vehicle.setModel(model);
        System.out.println("Vehicle updated successfully.");
    }

    public void removeVehicle(List<Vehicle> vehicles, Vehicle vehicle) {
        vehicles.remove(vehicle);
        System.out.println("Vehicle removed successfully.");
    }

    public void createCustomerProfile(List<Customer> customers, Customer customer) {
        customers.add(customer);
        System.out.println("Customer profile created successfully.");
    }

    public void editCustomerProfile(Customer customer, String name, String email, String phone, String address) {
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setAddress(address);
        System.out.println("Customer profile updated successfully.");
    }

    public void removeCustomerProfile(List<Customer> customers, Customer customer) {
        customers.remove(customer);
        System.out.println("Customer profile removed successfully.");
    }

    public List<Vehicle> searchAvailability(List<Vehicle> vehicles, Date startDate, Date endDate) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.isAvailableForDates(startDate, endDate))
                .collect(Collectors.toList());
    }

    public void confirmBooking(List<Booking> bookings, List<Vehicle> vehicles, Booking booking, Vehicle vehicle) {
        bookings.add(booking);
        vehicle.setAvailability(vehicle.getId(), false);
        vehicle.addBooking(booking); // Add the booking to the vehicle's list of bookings
        System.out.println("Booking confirmed. Total cost: $" + booking.getTotalCost());
    }

    public void viewCustomerRentalHistory(Customer customer) {
        customer.getRentalHistory().forEach(System.out::println);
    }

    public void cancelBooking(List<Booking> bookings, int bookingID) {
        bookings.stream()
                .filter(b -> b.getBookingID() == bookingID)
                .findFirst()
                .ifPresent(booking -> {
                    bookings.remove(booking);
                    Vehicle vehicle = booking.getVehicle();
                    vehicle.setAvailability(vehicle.getId(), true);
                    System.out.println("Booking canceled successfully.");
                });
    }

    public void sendEmail(Customer customer, Invoice invoice, Booking booking) {
        String message = "Dear " + customer.getName() + ",\n\n" +
                "Thank you for your booking. Here are your invoice details:\n" +
                invoice.toString() + "\n" + booking.toString() +
                "\n\nBest regards,\nYour Car Rental Service";
        System.out.println("Sending email to " + customer.getEmail() + ":\n" + message);
    }

    @Override
    public String toString() {
        return "Admin ID: " + adminId +
                "\n----------------" +
                "\nUsername: '" + username +
                "\nEmail: '" + email +
                "\nPassword: '" + password + "\n";
    }
}
