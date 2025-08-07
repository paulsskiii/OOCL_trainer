package Java34.day4.excer1_3;

class Port {
    String name;
    int capacity; // maximum ships
    int currentOccupancy;

    public Port(String name, int capacity, int currentOccupancy) {
        this.name = name;
        this.capacity = capacity;
        this.currentOccupancy = currentOccupancy;
    }

    public String getName() { return name; }
    public int getCapacity() { return capacity; }
    public int getCurrentOccupancy() { return currentOccupancy; }

    public boolean addShip() {
        if (currentOccupancy < capacity) {
            currentOccupancy++;
            return true;
        }
        return false;
    }

    public boolean removeShip() {
        if (currentOccupancy > 0) {
            currentOccupancy--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Port{" +
               "name='" + name + '\'' +
               ", capacity=" + capacity +
               ", currentOccupancy=" + currentOccupancy +
               '}';
    }
}

