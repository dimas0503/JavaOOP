package homework2;

/**
 * Created by Dima on 11.10.2015.
 */
public class Car {

    private String name;
    private int placeNumber;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public String getName() {
        return name;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }
}
