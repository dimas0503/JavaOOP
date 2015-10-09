package homeWork1;

/**
 * Created by Dima on 09.10.2015.
 */
public class MyArrayListMain{
    public static void main(String[] args) {
        MyArrayList<String> arr = new MyArrayList<>();
        MyArrayList<Integer> arr1 = new MyArrayList<>();

        arr1.add(10);
        arr1.add(20);

        for (int i: arr1){
            System.out.println(i);
        }
        arr1.remove(1);


        arr.add("Hello");
        arr.add("Hello1");
        arr.add("Hello2");
        arr.add("Hello3");
        arr.add("Hello4");
        arr.add("Hello5");
        arr.add("Hello6");
        arr.print();
        arr.remove(7);
        System.out.println("------------");
        arr.print();

        for (String element : arr){
            System.out.println(element);
        }


        arr.add(3,"Hello1.1");
        arr.print();
        System.out.println(arr.indexOf("Hello6"));
        System.out.println(arr.size());

        System.out.println(arr.get(3));


    }

}
