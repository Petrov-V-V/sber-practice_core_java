package collections_1;

import java.util.Iterator;

public class ArrayList implements List {
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
    public void add(int index, Object item) {
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
    public void set(int index, Object item) {
        if (index > size || index < 0) 
            throw new IndexOutOfBoundsException();
        else if (index == size)
            add(item);
        else 
            aList[index] = item;
    }

    @Override
    public Object get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        else
            return aList[index];
    }

    @Override
    public int indexOf(Object item) {
        for (int i = 0; i < size; i++)
            if (aList[i].equals(item))
                return i;
        return -1;
    }

    @Override
    public int lastIndexOf(Object item) {
        for (int i = size-1; i >= 0; i--)
            if (aList[i].equals(item)) 
                return i;
        return -1;
    }

    @Override
    public Object remove(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        else {
            Object item = aList[index];
            for (int i = index; i < size; i++) {
                aList[i] = aList[i+1];
            }
            size--;
            return item;
        }
    }

    @Override
    public List subList(int fisrtItem, int lastItem) {
        if (lastItem > size || lastItem < fisrtItem || fisrtItem < 0|| lastItem < 0)
            throw new IndexOutOfBoundsException();
        else {
            ArrayList newAList = new ArrayList();
            for (int i = fisrtItem; i < lastItem; i++)
                newAList.add(aList[i]);
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
    public boolean contains(Object item) {
        for (Object curItem : aList)
            if (item.equals(curItem))
                return true;
        return false;
    }

    @Override
    public boolean add(Object item) {
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
    public boolean remove(Object item) {
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
    public Iterator<Object> iterator() {
        return new ListIterator(this);
    }
}