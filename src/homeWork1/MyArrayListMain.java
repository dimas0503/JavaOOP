package homeWork1;

/**
 * Created by Dima on 09.10.2015.
 */
public class MyArrayListMain{
    public static void main(String[] args) {
/*        //for strings
        MyArrayList<String> arr = new MyArrayList<>();
        arr.add("Hello");
        arr.add("Hello1");
        arr.add("Hello2");
        arr.print();
        System.out.println("Get 0 index  -> " + arr.get(0));
        System.out.println("Get 10 index  -> " + arr.get(10));
        arr.set(10, "H");
        arr.set(1, "H");
        arr.print();
        arr.add(2, "h1");
        arr.print();
        System.out.println("index of h --> " + arr.indexOf("Hello2"));
        System.out.println("Size --> "+ arr.size());
        System.out.println("remove " + arr.remove(3));
        arr.print();

        for (String element : arr){
            System.out.print(element+" | ");
        }
*/

        //for int
        MyArrayList<Integer> arr1 = new MyArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(0,7);
        System.out.println(arr1.get(0));
        arr1.add(1,8);
        System.out.println(arr1.get(0));
        arr1.print();

/*
        arr1.add(30);
        arr1.print();
        arr1.set(10, 2);
        arr1.set(1,2);
        arr1.print();

        for (int i: arr1){
            System.out.println(i);
        }
        arr1.remove(1);

        arr.add(3,"Hello1.1");
        arr.print();
        System.out.println(arr.indexOf("Hello6"));
        System.out.println(arr.size());

        System.out.println(arr.get(3));
*/
    }

}
