import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static List<Vehicle> vehicles = new ArrayList<Vehicle>();
    private static List<Customer> customers = new ArrayList<Customer>();
    private static List<Admin> admins = new ArrayList<Admin>();
    private static List<Booking> bookings = new ArrayList<Booking>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        Admin currentAdmin = null;

        while (true) {
            if (currentAdmin == null) {
                System.out.println("1. Admin Login");
                System.out.println("2. Create Admin Account");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        currentAdmin = adminLogin();
                        break;
                    case 2:
                        createAdminAccount();
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } else {
                System.out.println("\n1. Add Vehicle");
                System.out.println("2. Update Vehicle");
                System.out.println("3. Remove Vehicle");
                System.out.println("4. View Vehicles");
                System.out.println("5. Add Customer");
                System.out.println("6. Update Customer");
                System.out.println("7. Remove Customer");
                System.out.println("8. View Customers");
                System.out.println("9. Book Vehicle");
                System.out.println("10. View Bookings");
                System.out.println("11. Logout");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addVehicle(currentAdmin);
                        break;
                    case 2:
                        updateVehicle(currentAdmin);
                        break;
                    case 3:
                        removeVehicle(currentAdmin);
                        break;
                    case 4:
                        viewVehicles();
                        break;
                    case 5:
                        addCustomer(currentAdmin);
                        break;
                    case 6:
                        updateCustomer(currentAdmin);
                        break;
                    case 7:
                        removeCustomer(currentAdmin);
                        break;
                    case 8:
                        viewCustomers();
                        break;
                    case 9:
                        bookVehicle(currentAdmin);
                        break;
                    case 10:
                        viewBookings();
                        break;
                    case 11:
                        currentAdmin = null;
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }

    private static Admin adminLogin() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (Admin admin : admins) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                System.out.println("Login successful!");
                return admin;
            }
        }
        System.out.println("Invalid credentials. Try again.");
        return null;
    }

    private static void createAdminAccount() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Admin admin = new Admin(admins.size() + 1, username, email, password);
        admins.add(admin);
        System.out.println("Admin account created successfully.");
    }

    private static void addVehicle(Admin admin) {
        System.out.print("Enter vehicle model: ");
        String model = scanner.nextLine();
        // System.out.print("Enter rental price: ");
        // double rentalPrice = scanner.nextDouble();
        // scanner.nextLine();
        boolean availability = true;

        System.out.print("Enter vehicle type (SUV, TRUCK, VAN, CONVERTIBLE, WAGON, EV, ECONOMY, SPORTS): ");
        String typeStr = scanner.nextLine().toUpperCase();
        VehicleType vehicleType;
        try {
            vehicleType = VehicleType.valueOf(typeStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid vehicle type. Defaulting to SUV.");
            vehicleType = VehicleType.SUV;
        }
        double rentalPrice = vehicleType.getPricePerDay();
        Vehicle vehicle = new Vehicle(vehicles.size() + 1, model, rentalPrice, availability, vehicleType);
        admin.addVehicle(vehicles, vehicle);

        System.out.println("Vehicle added successfully.");
        System.out.println("The vehicle ID for " + model + " is: " + vehicle.getId());
    }

    private static void updateVehicle(Admin admin) {
        System.out.print("Enter vehicle ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Vehicle vehicle = findVehicleById(id);
        if (vehicle != null) {
            System.out.print("Enter new model: ");
            String model = scanner.nextLine();
            // System.out.print("Enter new rental price: ");
            // double rentalPrice = scanner.nextDouble();
            // scanner.nextLine();

            admin.updateVehicle(vehicle, model);
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    private static void removeVehicle(Admin admin) {
        System.out.print("Enter vehicle ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Vehicle vehicle = findVehicleById(id);
        if (vehicle != null) {
            admin.removeVehicle(vehicles, vehicle);
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    private static void viewVehicles() {
        System.out.println("Vehicles:\n");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    private static void addCustomer(Admin admin) {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();
        System.out.print("Enter customer phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter customer address: ");
        String address = scanner.nextLine();

        Customer customer = new Customer(customers.size() + 1, name, email, phone, address);
        admin.createCustomerProfile(customers, customer);
        System.out.println("Customer profile created successfully.");
        System.out.println("The customer ID for " + name + " is: " + customer.getId());
    }

    private static void updateCustomer(Admin admin) {
        System.out.print("Enter customer ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Customer customer = findCustomerById(id);
        if (customer != null) {
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new email: ");
            String email = scanner.nextLine();
            System.out.print("Enter new phone: ");
            String phone = scanner.nextLine();
            System.out.print("Enter new address: ");
            String address = scanner.nextLine();

            admin.editCustomerProfile(customer, name, email, phone, address);
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void removeCustomer(Admin admin) {
        System.out.print("Enter customer ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Customer customer = findCustomerById(id);
        if (customer != null) {
            admin.removeCustomerProfile(customers, customer);
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void viewCustomers() {
        System.out.println("Customers:\n");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private static void bookVehicle(Admin admin) {
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        Customer customer = findCustomerById(customerId);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("Enter vehicle ID: ");
        int vehicleId = scanner.nextInt();
        scanner.nextLine();
        Vehicle vehicle = findVehicleById(vehicleId);

        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        if (!vehicle.isAvailable()) {
            System.out.println("Vehicle is not available.");
            return;
        }

        System.out.print("Enter start date (yyyy-MM-dd): ");
        String startDateStr = scanner.nextLine();
        System.out.print("Enter end date (yyyy-MM-dd): ");
        String endDateStr = scanner.nextLine();

        try {
            Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateStr);
            Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateStr);
            long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
            int numberOfDays = (int) (diffInMillies / (1000 * 60 * 60 * 24));

            double totalCost = vehicle.getRentalPrice() * numberOfDays;

            Booking booking = new Booking(bookings.size() + 1, vehicleId, customerId, startDate, endDate, totalCost,
                    true);
            admin.confirmBooking(bookings, vehicles, booking, vehicle);

            Invoice invoice = booking.generateInvoice(booking.getBookingId(), totalCost, new Date(), "Credit Card");
            admin.sendEmail(customer, invoice, booking);

        } catch (ParseException e) {
            System.out.println("Invalid date format. Please try again.");
        }
    }

    private static void viewBookings() {
        System.out.println("Bookings:\n");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    private static Vehicle findVehicleById(int id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) {
                return vehicle;
            }
        }
        return null;
    }

    private static Customer findCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public static List<Vehicle> getVehicles() {
        return vehicles;
    }

    public static List<Booking> getBookings() {
        return bookings;
    }
}
