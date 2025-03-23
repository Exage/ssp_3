import java.util.ArrayList;
import java.util.List;

public class ApartmentRentalSystem {
    private List<Apartment> freeApartments;
    private List<Apartment> rentedApartments;

    public ApartmentRentalSystem() {
        freeApartments = new ArrayList<>();
        rentedApartments = new ArrayList<>();
    }

    public void addApartment(Apartment apt) {
        if (!apt.isRented()) {
            freeApartments.add(apt);
        } else {
            rentedApartments.add(apt);
        }
    }

    public boolean rentApartment(Apartment apt) {
        if (freeApartments.remove(apt)) {
            apt.setRented(true);
            rentedApartments.add(apt);
            return true;
        }
        return false;
    }

    public void printAllApartments() {
        System.out.println("Свободные квартиры:");
        for (Apartment apt : freeApartments) {
            System.out.println(apt);
        }
        System.out.println("Сданные квартиры:");
        for (Apartment apt : rentedApartments) {
            System.out.println(apt);
        }
    }

    public List<Apartment> listByRooms(int rooms) {
        List<Apartment> result = new ArrayList<>();
        for (Apartment apt : freeApartments) {
            if (apt.getNumberOfRooms() == rooms) {
                result.add(apt);
            }
        }
        return result;
    }

    public List<Apartment> listByRoomsAndFloorRange(int rooms, int floorMin, int floorMax) {
        List<Apartment> result = new ArrayList<>();
        for (Apartment apt : freeApartments) {
            if (apt.getNumberOfRooms() == rooms && apt.getFloor() >= floorMin && apt.getFloor() <= floorMax) {
                result.add(apt);
            }
        }
        return result;
    }

    public List<Apartment> listByMinArea(double minArea) {
        List<Apartment> result = new ArrayList<>();
        for (Apartment apt : freeApartments) {
            if (apt.getArea() > minArea) {
                result.add(apt);
            }
        }
        return result;
    }

    public Apartment findSuitableApartment(int rooms, int floor, double desiredArea) {
        for (Apartment apt : freeApartments) {
            if (apt.getNumberOfRooms() == rooms &&
                    apt.getFloor() == floor &&
                    Math.abs(apt.getArea() - desiredArea) <= 10.0) {
                return apt;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ApartmentRentalSystem system = new ApartmentRentalSystem();

        Apartment a1 = new Apartment(2, 55.0, 3, "ул. Ленина, д.5", 500.0, false);
        Apartment a2 = new Apartment(3, 75.0, 5, "ул. Гагарина, д.10", 700.0, false);
        Apartment a3 = new Apartment(2, 60.0, 3, "ул. Победы, д.8", 520.0, false);
        Apartment a4 = new Apartment(1, 35.0, 2, "ул. Советская, д.2", 300.0, false);
        Apartment a5 = new Apartment(3, 80.0, 4, "ул. Кирова, д.12", 750.0, false);

        system.addApartment(a1);
        system.addApartment(a2);
        system.addApartment(a3);
        system.addApartment(a4);
        system.addApartment(a5);

        System.out.println("Полный список квартир:");
        system.printAllApartments();

        System.out.println("\nКвартиры с 2 комнатами:");
        for (Apartment apt : system.listByRooms(2)) {
            System.out.println(apt);
        }

        System.out.println("\nКвартиры с 3 комнатами на этажах от 4 до 6:");
        for (Apartment apt : system.listByRoomsAndFloorRange(3, 4, 6)) {
            System.out.println(apt);
        }

        System.out.println("\nКвартиры с площадью более 60 кв.м:");
        for (Apartment apt : system.listByMinArea(60.0)) {
            System.out.println(apt);
        }

        System.out.println("\nПоиск подходящей квартиры (2 комнаты, этаж 3, площадь ~58 кв.м):");
        Apartment suitable = system.findSuitableApartment(2, 3, 58.0);
        if (suitable != null) {
            System.out.println("Найдена квартира: " + suitable);
            system.rentApartment(suitable);
        } else {
            System.out.println("Подходящая квартира не найдена.");
        }

        System.out.println("\nСписок квартир после аренды:");
        system.printAllApartments();
    }
}
