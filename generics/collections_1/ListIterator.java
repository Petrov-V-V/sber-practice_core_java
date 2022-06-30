package generics.collections_1;

import java.util.Iterator;

public class ListIterator<E> implements Iterator<E> {
    private List<E> list;
    private int numberElement;

    public ListIterator(List<E> list) {
        this.list = list;
        numberElement = 0;
    }

    @Override
    public E next() {
        numberElement++;
        return list.get(numberElement-1);
    }

    @Override
    public boolean hasNext() {
        if (list.size() >= numberElement+1) 
            return true;
        return false;
    }
}