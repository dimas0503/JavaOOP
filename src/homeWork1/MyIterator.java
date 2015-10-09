package homeWork1;

import java.util.Iterator;

/**
 * Created by Dima on 09.10.2015.
 */
public class MyIterator<E> implements Iterator<E> {

    private Object[] array;
    private int index = -1;


    public MyIterator() {

    }

    public MyIterator(Object[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return (index < array.length- 1 && array[index+1] != null);
    }

    @Override
    public E next() {
        if (hasNext()){
            return (E) array[++index];
        }
        return null;
    }
}
