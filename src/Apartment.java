public class Apartment {
    private int numberOfRooms;
    private double area;
    private int floor;
    private String address;
    private double rentalPrice;
    private boolean isRented;

    public Apartment(int numberOfRooms, double area, int floor, String address, double rentalPrice, boolean isRented) {
        this.numberOfRooms = numberOfRooms;
        this.area = area;
        this.floor = floor;
        this.address = address;
        this.rentalPrice = rentalPrice;
        this.isRented = isRented;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }
    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
    public double getArea() {
        return area;
    }
    public void setArea(double area) {
        this.area = area;
    }
    public int getFloor() {
        return floor;
    }
    public void setFloor(int floor) {
        this.floor = floor;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public double getRentalPrice() {
        return rentalPrice;
    }
    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }
    public boolean isRented() {
        return isRented;
    }
    public void setRented(boolean rented) {
        isRented = rented;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "rooms=" + numberOfRooms +
                ", area=" + area +
                ", floor=" + floor +
                ", address='" + address + '\'' +
                ", rentalPrice=" + rentalPrice +
                ", isRented=" + isRented +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Apartment)) return false;
        Apartment other = (Apartment) obj;
        return numberOfRooms == other.numberOfRooms &&
                Double.compare(area, other.area) == 0 &&
                floor == other.floor &&
                address.equals(other.address) &&
                Double.compare(rentalPrice, other.rentalPrice) == 0 &&
                isRented == other.isRented;
    }
}
