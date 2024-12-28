import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(String carId, String customerName, int days) {
        Car selectedCar = cars.stream()
                .filter(car -> car.getCarId().equals(carId) && car.isAvailable())
                .findFirst()
                .orElse(null);

        if (selectedCar == null) {
            System.out.println("Car not available or invalid car ID.");
            return;
        }

        Customer customer = new Customer("CUS" + (customers.size() + 1), customerName);
        addCustomer(customer);

        selectedCar.rent();
        rentals.add(new Rental(selectedCar, customer, days));

        System.out.printf("Car rented successfully! Total Price: $%.2f%n", selectedCar.calculatePrice(days));
    }

    public void returnCar(String carId) {
        Car carToReturn = cars.stream()
                .filter(car -> car.getCarId().equals(carId) && !car.isAvailable())
                .findFirst()
                .orElse(null);

        if (carToReturn == null) {
            System.out.println("Invalid car ID or car is not rented.");
            return;
        }

        Rental rentalToRemove = rentals.stream()
                .filter(rental -> rental.getCar() == carToReturn)
                .findFirst()
                .orElse(null);

        if (rentalToRemove != null) {
            carToReturn.returnCar();
            rentals.remove(rentalToRemove);
            System.out.println("Car returned successfully!");
        } else {
            System.out.println("No rental record found for this car.");
        }
    }

    public void listAvailableCars() {
        System.out.println("\nAvailable Cars:");
        cars.stream()
            .filter(Car::isAvailable)
            .forEach(System.out::println);
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Car Rental System =====");
            System.out.println("1. List Available Cars");
            System.out.println("2. Rent a Car");
            System.out.println("3. Return a Car");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> listAvailableCars();
                case 2 -> {
                    System.out.print("Enter your name: ");
                    String customerName = scanner.nextLine();

                    listAvailableCars();

                    System.out.print("Enter the car ID you want to rent: ");
                    String carId = scanner.nextLine();

                    System.out.print("Enter rental days: ");
                    int days = scanner.nextInt();
                    scanner.nextLine();

                    rentCar(carId, customerName, days);
                }
                case 3 -> {
                    System.out.print("Enter the car ID to return: ");
                    String carId = scanner.nextLine();
                    returnCar(carId);
                }
                case 4 -> {
                    System.out.println("Thank you for using the Car Rental System!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

