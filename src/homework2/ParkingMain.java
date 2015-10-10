package homework2;

/**
 * Created by Dima on 11.10.2015.
 */
public class ParkingMain {
    public static void main(String[] args) {
        Parking parking = new Parking(10);
        Car car1 = new Car("Ferrari");
        Car car2 = new Car("Lambo");
        Car car3 = new Car("Citroen");
        Car car4 = new Car("Giguli");
        parking.park(car1);
        parking.park(car2);
        parking.park(car3);
        System.out.println(car1.getPlaceNumber());
        System.out.println(car2.getPlaceNumber());
        System.out.println(car3.getPlaceNumber());
        parking.leave(1);
        System.out.println(car2.getPlaceNumber());
        parking.park(car4);
        System.out.println(car4.getPlaceNumber());

    }
}
