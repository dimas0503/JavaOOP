package homework2;

/**
 * Created by Dima on 10.10.2015.
 */
public class Parking {
    private Car[] parkPlaces;

    public Parking(int placeCount) {
        parkPlaces = new Car[placeCount];
    }

    public int park(Car car) {
        for (int i = 0; i < parkPlaces.length; i++) {
            if (parkPlaces[i] == null){
                parkPlaces[i] = car;
                car.setPlaceNumber(i);
                return i;
            }
        }
        throw  new ParkFullException();
    }


    public Car leave(int placeNumber){
        Car car = parkPlaces[placeNumber];
        car.setPlaceNumber(-1);
        parkPlaces[placeNumber] = null;
        return car;
    }
}
