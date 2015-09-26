package Session1;

import java.util.ArrayList;

/**
 * Created by Dima on 26.09.2015.
 * написать метод который выводит на экран кол-во натуральных чисел
 * На вход идет array list
 */
class PrimeNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> prNum = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            prNum.add(i);
        }
        System.out.println("Total prime numbers: " + prNumCounter(prNum));
    }

    public  static int prNumCounter(ArrayList<Integer> prNum){
        int prCounter = 0;
        boolean prCounterFlag;
        for (Integer aPrNum : prNum) {
            //System.out.print(prNum.get(i)+" ");
            if (aPrNum != 0 && aPrNum != 1) {
                if (aPrNum == 2) {
                    System.out.print(aPrNum + " ");
                    ++prCounter;
                } else {
                    prCounterFlag = true;
                    for (int j = 2; j < aPrNum; j++) {
                        if (aPrNum % j == 0) {
                            prCounterFlag = false;
                            break;
                        }
                    }
                    if (prCounterFlag) {
                        System.out.print(aPrNum + " ");
                        ++prCounter;
                    }
                }
            }
        }
        return prCounter;
    }
}
