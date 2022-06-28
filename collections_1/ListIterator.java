package collections_1;

import java.util.Iterator;

public class ListIterator implements Iterator<Object> {
    private List list;
    private int numberElement;

    public ListIterator(List list) {
        this.list = list;
        numberElement = 0;
    }

    @Override
    public Object next() {
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