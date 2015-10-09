package homeWork1;

import java.util.Iterator;

/**
 * Created by Dima on 09.10.2015.
 */

public class MyArrayList <E> implements Iterable<E>{
    private  int Capacity = 2;
    private  int maxIndex = -1;
    private Object[] array;

    public MyArrayList() {
        array = new Object[Capacity];
    }

    public E get(int index){
        return (E) array[index];
    }


    public boolean set(int index, E value){
        array[index] = value;
        return true;
    }

    public int indexOf(E value){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value){
                return i;
            }
        }
        return -1;
    }

    public int size(){
        int resSize = 0;
        while ((resSize != array.length) && (array[resSize] != null)){
            ++resSize;
        }
        return resSize;
    }

    public E remove(int index){
        for (int i = index-1; array[i] != null ; i++) {
            array[i] = array[i+1];
        }
        return (E) array;
    }

    public boolean add(int index, E value){
        if (maxIndex != array.length-1){
            int position = maxIndex+1;
            while (position != index-1){
                array[position] = array[position-1];
                --position;
            }
            array[index-1] = value;
            ++maxIndex;
        }else {
            Object[] tmpArray = new Object[array.length + Capacity];
            System.arraycopy(array, 0, tmpArray, 0, array.length);
            array = tmpArray;
            int position = maxIndex+1;
            while (position != index-1){
                array[position] = array[position-1];
                --position;
            }
            array[index-1] = value;
            ++maxIndex;
        }
        return true;
    }

    public void add(E value){
        if (maxIndex != array.length-1){
            array[++maxIndex] = value;
        }else {
            Object[] tmpArray = new Object[array.length+ Capacity];
            for (int i = 0; i < array.length; i++) {
                tmpArray[i] = array[i];
            }
            array = tmpArray;
            array[++maxIndex] = value;
        }
    }

    public void print(){
        for (int i = 0; i < array.length && array[i] != null; i++) {
            System.out.println(array[i]);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator(array);
    }
}
