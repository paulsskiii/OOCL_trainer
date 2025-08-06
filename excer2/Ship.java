package OOCL_trainer.excer2;

public class Ship {
    private String shipName;
    private String captainName;
    private double speedKnots;
    private int fuelLevelPercentage;

    public Ship(String shipName, String captainName, double speedKnots, int fuelLevelPercentage) {
        this.shipName = shipName;
        this.captainName = captainName;
        this.speedKnots = speedKnots;
        setFuelLevelPercentage(fuelLevelPercentage); // Use setter for validation
    }

    // Getters
    public String getShipName() {
        return shipName;
    }

    public String getCaptainName() {
        return captainName;
    }

    public double getSpeedKnots() {
        return speedKnots;
    }

    public int getFuelLevelPercentage() {
        return fuelLevelPercentage;
    }

    // Setters
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public void setSpeedKnots(double speedKnots) {
        this.speedKnots = speedKnots;
    }

    public void setFuelLevelPercentage(int fuelLevelPercentage) {
        if (fuelLevelPercentage >= 0 && fuelLevelPercentage <= 100) {
            this.fuelLevelPercentage = fuelLevelPercentage;
        } else {
            System.out.println("Error: Fuel level must be between 0 and 100 percent. Value not set.");
        }
    }

    public void displayShipInfo() {
        System.out.println("Ship Name: " + shipName);
        System.out.println("Captain: " + captainName);
        System.out.println("Speed: " + speedKnots + " knots");
        System.out.println("Fuel Level: " + fuelLevelPercentage + "%");
    }
}


