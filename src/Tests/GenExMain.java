package Tests;

/**
 * Created by Dima on 03.10.2015.
 */
public class GenExMain {
    public static void main(String[] args) {
        GenEx<String> exString = new GenEx<>();
        exString.setSomedata("Hello");
        System.out.println(exString.getSomedata());

        GenEx<Integer> exInt = new GenEx<>();
        exInt.setSomedata(12);
        System.out.println(exInt.getSomedata());
    }
}
