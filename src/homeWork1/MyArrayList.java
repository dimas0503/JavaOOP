package homeWork1;

import java.util.Iterator;

/**
 * Created by Dima on 09.10.2015.
 */

public class MyArrayList <E> implements Iterable<E>{
    private  int capacity = 2;
    private  int maxIndex = -1;
    private Object[] array;

    public MyArrayList() {
        array = new Object[capacity];
    }

    public E get(int index){
        if (index <= maxIndex && index >=0){
            return (E) array[index];
        }
        System.out.println("there's no such index " + index);
        return null;
    }


    public boolean set(int index, E value){
        //reject if out of bound
        if (index > maxIndex || index < 0){
            System.out.println("Error while replacing value. Your index " + index + " is out of bound of array");
            return false;
        }

        array[index] = value;
        return true;
    }

    public int indexOf(E value){
        for (int i = 0; i <=maxIndex; i++) {
            if (array[i] == value){
                return i;
            }
        }
        return -1;
    }

    public int size(){
        return maxIndex+1;
    }

    public E remove(int index){
        //reject removing out of bound
        if (index > maxIndex || index < 0){
            return null;
        }

        E res = (E) array[index];

        //deleting element
        array[index] = null;

        //shifting other elements
        for (int i = index; i < maxIndex ; i++) {
            array[i] = array[i+1];
        }

        --maxIndex;

        return res;
    }

    public boolean add(int index, E value){
        //reject inserting  if out of bound
        if (index > maxIndex || index < 0){
            return false;
        }

        //extending array if not enough space
        if (maxIndex == array.length-1){
            Object[] tmpArray = new Object[array.length + capacity];
            System.arraycopy(array, 0, tmpArray, 0, array.length);
            array = tmpArray;
        }


        //find place where to paste new element
        int position = maxIndex;
        while (position >= index){
            array[position+1] = array[position];
            --position;
        }


        //paste new value
        array[index] = value;
        ++maxIndex;

        return true;
    }

    public void add(E value){
        //If current capacity enough to add just add. Else extending existing array and adding the value
        if (maxIndex != array.length-1){
            array[++maxIndex] = value;
        }else {
            Object[] tmpArray = new Object[array.length+ capacity];
            for (int i = 0; i < array.length; i++) {
                tmpArray[i] = array[i];
            }
            array = tmpArray;
            array[++maxIndex] = value;
        }
    }

    public void print(){
        for (int i = 0; i < array.length && array[i] != null; i++) {
            System.out.print(array[i] + " | ");
        }
        System.out.println();
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator(array);
    }
}
