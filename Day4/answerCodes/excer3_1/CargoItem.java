package Java34.day4.excer3_1;

class CargoItem {
    long id;
    String name;
    double weight;
    double value; // new property

    public CargoItem(long id, String name, double weight, double value) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    public long getId() { return id; }
    public String getName() { return name; }
    public double getWeight() { return weight; }
    public double getValue() { return value; } // Getter for value

    @Override
    public String toString() {
        return "CargoItem{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", weight=" + weight +
               ", value=" + value +
               '}';
    }
}
