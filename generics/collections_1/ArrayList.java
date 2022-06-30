package generics.collections_1;

import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    private Object[] aList;
    private int size;
    private int capacity;

    public ArrayList() {
        size = 0;
        capacity = 8;
        aList = new Object[capacity];
    }

    private Object[] capacityIncreasing() {
        capacity *= 2;
        Object[] increasedAList = new Object[capacity];
        for (int i = 0; i < size; i++) {
            increasedAList[i] = aList[i];
        }
        return increasedAList;
    }

    @Override
    public void add(int index, E item) {
        if (size == capacity) 
            aList = capacityIncreasing();
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();
        else if (index == size) {
            aList[index] = item;
            size++;
        } else {
            for (int i = size; i > index; i--) 
                aList[i] = aList[i-1];
            aList[index] = item;
            size++;
        }
    }

    @Override
    public void set(int index, E item) {
        if (index > size || index < 0) 
            throw new IndexOutOfBoundsException();
        else if (index == size)
            add(item);
        else 
            aList[index] = item;
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        else
            return (E) aList[index];
    }

    @Override
    public int indexOf(E item) {
        for (int i = 0; i < size; i++)
            if (aList[i].equals(item))
                return i;
        return -1;
    }

    @Override
    public int lastIndexOf(E item) {
        for (int i = size-1; i >= 0; i--)
            if (aList[i].equals(item)) 
                return i;
        return -1;
    }

    @Override
    public E remove(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        else {
            E item = (E) aList[index];
            for (int i = index; i < size; i++) {
                aList[i] = aList[i+1];
            }
            size--;
            return item;
        }
    }

    @Override
    public List<E> subList(int fisrtItem, int lastItem) {
        if (lastItem > size || lastItem < fisrtItem || fisrtItem < 0|| lastItem < 0)
            throw new IndexOutOfBoundsException();
        else {
            ArrayList<E> newAList = new ArrayList<>();
            for (int i = fisrtItem; i < lastItem; i++)
                newAList.add((E) aList[i]);
            return newAList;
        }
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }

    @Override
    public boolean contains(E item) {
        for (Object curItem : aList)
            if (item.equals(curItem))
                return true;
        return false;
    }

    @Override
    public boolean add(E item) {
        if (size < capacity) 
            aList[size] = item;
        else {
            aList = capacityIncreasing();
            aList[size] = item;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(E item) {
        int curSize = size;
        for (int i = 0; i < size; i++)
            if (aList[i].equals(item)) {
                remove(i);
                i--;
            }
        return !(curSize == size);
    }

    @Override
    public void clear() {
        size = 0;
        capacity = 8;
        aList = new Object[capacity];
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator<>(this);
    }
}