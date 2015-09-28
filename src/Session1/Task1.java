package Session1;

import java.util.ArrayList;

/*
 * Created by dchernetskyi on 26.09.2015.
 *   Ќаписать метод принимающий на вход список типа arraylist и вывод€щий на экран кол-во простыстых чисел
 *   делитьс€ на само себ€
 *   на 1
 *   и не 1
 */

public class Task1 {

    public static void main(String[] args) {
        ArrayList<Integer> pNumList = new ArrayList<>();
        //fill array
        for (int i = 0; i < 10; i++) {
            pNumList.add(i);
        }

        //call method and show result
        System.out.println(primeNumber(pNumList));
    }

    public static int primeNumber(ArrayList<Integer> pNumList){
        int prNumCounter = 0;
        for (int i = 0; i < pNumList.size(); i++){
            //System.out.print(pNumList.get(i)+" ");
            for (int j = 1; j < pNumList.get(i); j++) {
                if (pNumList.get(i)% j == 0){
                    break;
                }
                ++prNumCounter;
            }
        }
        return prNumCounter;
    }

}
