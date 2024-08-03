# Car Rental Agency Management System (CRAMS)

## Overview
The Car Rental Agency Management System (CRAMS) is designed to streamline the operations of car rental businesses by automating key functions such as vehicle management, booking processes, and customer management. Developed using Java, the system ensures efficiency, reliability, and ease of use.

## Features
### Vehicle Management
- **Add Vehicle**: Admins can add new vehicles to the system with details like model, rental price, and availability.
- **Update Vehicle**: Admins can update existing vehicle details.
- **Remove Vehicle**: Admins can remove vehicles from the system.
- **View Vehicle List**: Admins can view a list of all vehicles and their current status (available, rented).

### Booking System
- **Search Available Vehicles**: Admins can search for available vehicles based on dates and vehicle type.
- **Book Vehicle**: Admins can book vehicles for customers, ensuring no double bookings occur.
- **Calculate Booking Cost**: The system calculates the cost of booking based on the rental period and vehicle type.
- **Generate Booking Confirmation**: The system generates a booking confirmation for the customer.
- **Generate Invoice**: The system generates an invoice for the customer.
- **Send Email**: The system sends booking confirmation and invoice emails to customers.

### Customer Management
- **Create Customer Profile**: Admins can create new customer profiles with details such as name, contact information, and payment details.
- **Edit Customer Profile**: Admins can edit customer profiles to update information or correct errors.
- **Remove Customer Profile**: Admins can remove customer profiles from the system.
- **View Customer Profile**: Admins can view details of customer profiles.
- **View Customer Rental History**: Admins can view a customer's rental history, including past and current rentals.

## System Architecture
CRAMS is designed with a modular architecture to ensure scalability, maintainability, and efficient data management. The system is divided into three main components: Vehicle Management, Booking System, and Customer Management. Each component interacts with various sub-components to perform specific functions.

## Installation
1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/CRAMS.git
    ```
2. Navigate to the project directory:
    ```bash
    cd CRAMS
    ```
3. Compile the Java files:
    ```bash
    javac -d bin src/main/java/*.java
    ```
4. Run the application:
    ```bash
    java -cp bin Main
    ```

## Usage
Upon running the application, admins can log in or create a new account. Once logged in, they can manage vehicles, bookings, and customer profiles through the console interface. The system ensures that all operations are performed efficiently and accurately, with real-time updates and automated processes.
