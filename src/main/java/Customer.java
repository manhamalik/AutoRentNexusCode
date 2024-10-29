import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;

    public Customer(int id, String name, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void createCustomerProfile(List<Customer> customers, Customer customer) {
        customers.add(customer);
        System.out.println("Customer profile created successfully.");
    }

    public void editCustomerProfile(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        System.out.println("Customer profile updated successfully.");
    }

    public void removeCustomerProfile(List<Customer> customers, Customer customer) {
        customers.remove(customer);
        System.out.println("Customer profile removed successfully.");
    }

    public void viewCustomerProfile() {
        System.out.println(this.toString());
    }

    public List<Booking> getRentalHistory() {
        List<Booking> rentalHistory = new ArrayList<>();
        for (Booking booking : Main.getBookings()) {
            if (booking.getCustomerId() == this.id) {
                rentalHistory.add(booking);
            }
        }
        return rentalHistory;
    }

    public void viewCustomerRentalHistory(List<Booking> bookings) {
        for (Booking booking : bookings) {
            if (booking.getCustomerId() == this.id) {
                System.out.println(booking.toString());
            }
        }
    }

    @Override
    public String toString() {
        return "Customer ID: " + id +
                "\n----------------" +
                "\nName: " + name +
                "\nEmail: " + email +
                "\nPhone: " + phone +
                "\nAddress: " + address + "\n";
    }
}
