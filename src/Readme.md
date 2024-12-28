# Car Rental System
A Java-based Car Rental System demonstrating core Object-Oriented Programming concepts. This system allows customers to rent cars, calculate rental costs, and return cars through a user-friendly menu-driven interface.

## Features
- Add cars to the system.
- Display available cars for rent.
- Rent a car for a specified duration.
- Calculate rental costs dynamically.
- Return rented cars and update availability.
- Interactive menu for user input.


## Technologies Used
- **Programming Language**: Java
- **Concepts**: 
  - **Encapsulation**: Used to protect data by making class fields private and accessing them via getter/setter methods.
  - **Abstraction**: Abstracts real-world entities like `Car`, `Customer`, and `Rental` as classes.
  - **Polymorphism**: Demonstrated through method overloading or overriding (e.g., `toString()` method).
  - **Inheritance**: Future-ready to extend functionality by creating parent-child class relationships (e.g., adding a `Vehicle` superclass for `Car`).
- **IDE**: Visual Studio Code
- **Build Tool**: Java Compiler (javac)


## Project Structure
Car-Rental-System/
├── src/
│   ├── Car.java          # Represents a car
│   ├── Customer.java     # Represents a customer
│   ├── Rental.java       # Represents a rental
│   ├── CarRentalSystem.java # Main system logic
│   └── Main.java         # Entry point of the application
├── README.md             # Documentation
├── .gitignore            # Git ignored files


## How to Run
1. Clone this repository to your local machine:
   ```bash
   git clone https://github.com/yourusername/Car-Rental-System.git

   cd Car-Rental-System/src
   javac *.java
   java Main


