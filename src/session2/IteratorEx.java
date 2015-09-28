package session2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by dchernetskyi on 27.09.2015.
 */
public class IteratorEx {
    public static void main(String[] args) {
        ArrayList<Integer> indexToRemove = new ArrayList<>();
        int prevValue = 0;
        int currValue = 0;
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        Iterator<Integer> itr= list.iterator();

        if (itr.hasNext()){
            prevValue = itr.next();
        }
        while (itr.hasNext()){
            currValue = itr.next();
            if (prevValue - currValue > 5){
                itr.remove();
            }else {
                prevValue = currValue;
            }
        }

        Iterator<Integer> itr1 = list.iterator();
        while (itr1.hasNext()){
            System.out.println(itr.next());
        }

    }
}
