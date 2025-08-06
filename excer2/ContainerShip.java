package OOCL_trainer.excer2;

public class ContainerShip extends Ship {
    private int numberOfTEU;

    public ContainerShip(String shipName, String captainName, double speedKnots, int fuelLevelPercentage, int numberOfTEU) {
        super(shipName, captainName, speedKnots, fuelLevelPercentage);
        this.numberOfTEU = numberOfTEU;
    }

    public int getNumberOfTEU() {
        return numberOfTEU;
    }

    public void setNumberOfTEU(int numberOfTEU) {
        this.numberOfTEU = numberOfTEU;
    }

    @Override
    public void displayShipInfo() {
        super.displayShipInfo(); // Call parent method
        System.out.println("Number of TEU: " + numberOfTEU);
    }
}

