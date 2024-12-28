public class Car {
    private String carId;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isAvailable;

    public Car(String carId, String brand, String model, double basePricePerDay) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true;
    }

    public String getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public double calculatePrice(int rentalDays) {
        return basePricePerDay * rentalDays;
    }

    public void rent() {
        if (isAvailable) {
            isAvailable = false;
        } else {
            throw new IllegalStateException("Car is already rented.");
        }
    }

    public void returnCar() {
        if (!isAvailable) {
            isAvailable = true;
        } else {
            throw new IllegalStateException("Car is already available.");
        }
    }

    @Override
    public String toString() {
        return String.format("Car ID: %s, Brand: %s, Model: %s, Price/Day: $%.2f, Available: %s",
                carId, brand, model, basePricePerDay, isAvailable ? "Yes" : "No");
    }
}
