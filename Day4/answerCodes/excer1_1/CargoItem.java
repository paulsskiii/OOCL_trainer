package Java34.day4.excer1_1;

class CargoItem {
    long id;
    String name;
    double weight; // in kg
    String destination; // added for mini-project

    public CargoItem(long id, String name, double weight, String destination) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.destination = destination;
    }

    public long getId() { return id; }
    public String getName() { return name; }
    public double getWeight() { return weight; }
    public String getDestination() { return destination; }


    @Override
    public String toString() {
        return "CargoItem{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", weight=" + weight +
               ", destination='" + destination + '\'' +
               '}';
    }

    // Important for removing by object reference if not by index
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CargoItem cargoItem = (CargoItem) o;
        return id == cargoItem.id; // Compare based on ID for uniqueness
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }
}
