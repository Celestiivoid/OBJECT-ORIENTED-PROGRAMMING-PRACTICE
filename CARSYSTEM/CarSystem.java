package CARSYSTEM;

class Car {
    private String brand;
    private double speed;
    private double fuel;

    Car(String brand) {
        this.brand = brand;
        this.speed = 0;
        this.fuel = 0;

    }

    void displayStats() {
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed);
        System.out.println("Fuel: " + fuel);
    }
    void increaseSpeed(double addSpeed) {
        if(addSpeed <= 0.0) {
            System.out.println("Cannot validate 0 or negative numbers for set speed field.");
            return;
        }
        speed += addSpeed;
        System.out.println("Successfully increase speed by: " + addSpeed);
        return;
    }
    void addFuel(double addFuel) {
        if(addFuel <= 0.0) {
            System.out.println("Cannot validate 0 or negative numbers for set fuel field.");
            return;
        }

        fuel += addFuel;
        System.out.println("Successfully added " + addFuel + " fuel.");
        return;
    }
    void accelerate() {
        if(fuel <= 0.0) {
            System.out.println("No fuel.");
            return;
        }
        if(fuel < 5) {
            System.out.println("Not enough fuel to start.");
            return;
        }
        speed += 10;
        fuel -= 5;
        return;
    }

    void brake() {
        if(speed == 0.0) {
            System.out.println("Car already stopped.");
            return;
        }
        if(speed < 10) {
            speed = 0.0;
            return;
        }
        speed -= 10;
        return;
    }

    String getBrand() {
        return brand;
    }
    double getSpeed() {
        return speed;
    }
    double getFuel() {
        return fuel;
    }
}

public class CarSystem {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota");
        car1.increaseSpeed(30);
        car1.addFuel(4);
        car1.accelerate();
        car1.displayStats();
    }
}