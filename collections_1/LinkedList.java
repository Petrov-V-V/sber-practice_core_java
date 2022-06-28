package collections_1;

import java.util.NoSuchElementException;
import java.util.Iterator;

public class LinkedList implements List, Deque {
    private int size;
    private Node begin;
    private Node end;

    public LinkedList() {
        size = 0;
        begin = new Node();
        end = new Node();
        begin.next = end;
        end.prev = begin;
    }

    private Object itemDeleting(Node node) {
        Object item = null;
        if (node.next != null && node.prev != null) {
            item = node.item;
            node.next.prev = node.prev;
            node.prev.next = node.next;
        } else if (node.next == null) {
            item = node.item;
            end.prev = node.prev;
            node.prev.next = end;
        } else if (node.prev == null) {
            item = node.item;
            begin.next = node.next;
            node.next.prev = begin;
        }
        size--;
        return item;
    }

    @Override
    public void add(int index, Object item) {
        if (index > size || index < 0)
            throw new NoSuchElementException();
        else if (index == size)
            addLast(item);
        else if (index == 0)
            addFirst(item);
        else {
            Node node = begin.next;
            for (int i = 0; i < index; i++)
                node = node.next;
            Node newNode = new Node(item, node.prev, node);
            node.prev.next = newNode;
            node.prev = newNode;
            size++;
        }
    }

    @Override
    public void set(int index, Object item) {
        if (index > size || index < 0)
            throw new NoSuchElementException();
        else if (index == size)
            addLast(item);
        else if (index < (int) size / 2) {
            Node node = begin.next;
            for (int i = 0; i < index; i++)
                node = node.next;
            node.item = item;
        } else {
            Node node = end.prev;
            for (int i = size; i > index+1; i--)
                node = node.prev;
            node.item = item;
        }

    }

    @Override
    public Object get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        Node node = begin.next;
        for (int i = 0; i < index; i++)
            node = node.next;
        return node.item;
    }

    @Override
    public int indexOf(Object item) {
        Node node = begin.next;
        for (int i = 0; i < size; i++) {
            if (node.item == item)
                return i;
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object item) {
        Node node = end.prev;
        for (int i = size-1;i >= 0; i--) {
            if (node.item == item) 
                return i;
            node = node.prev;   
        }
        return -1;
    }

    @Override
    public Object remove(int index) {
        if (index >= size || index < 0)
            throw new NoSuchElementException();
        else {
            Object item = null;
            Node node = begin.next;
            for (int i = 0; i < index; i++)
                node = node.next;
            item = itemDeleting(node);
            return item;
        }
    }

    @Override
    public List subList(int fisrtItem, int lastItem) {
        if (lastItem > size || fisrtItem > lastItem || fisrtItem < 0 || lastItem < 0)
            throw new IndexOutOfBoundsException();
        LinkedList lList = new LinkedList();
        Node node = begin.next;
        for (int i = 0; i < lastItem; i++) {
            if (i >= fisrtItem)
                lList.addLast(node.item);
            node = node.next;
        }
        return (List) lList;
    }


    @Override
    public void addFirst(Object item) {
        if (begin.next.equals(end)) {
            Node node = new Node(item, begin, end);
            begin.next = node;
            end.prev = node;
        } else {
            Node node = new Node(item, null, begin.next);
            begin.next.prev = node;
            begin.next = node;
        }
        size++;
    }

    @Override
    public void addLast(Object item) {
        if (end.prev.equals(begin)) {
            Node node = new Node(item, begin, end);
            begin.next = node;
            end.prev = node;
        } else {
            Node node = new Node(item, end.prev, null);
            end.prev.next = node;
            end.prev = node;
        }
        size++;
    }

    @Override
    public Object getFirst() {
        if (size == 0)
            throw new NoSuchElementException();
        return begin.next.item;

    }

    @Override
    public Object getLast() {
        if (size == 0)
            throw new NoSuchElementException();
        return end.prev.item;
    }

    @Override
    public Object pollFirst() {
        if (size == 0)
            return null;
        else {
            Object item = begin.next.item;
            begin.next.next.prev = begin;
            begin.next = begin.next.next;
            size--;
            return item;
        }
    }

    @Override
    public Object pollLast() {
        if (size == 0)
            return null;
        else {
            Object item = end.prev.item;
            end.prev.prev.next = end;
            end.prev = end.prev.prev;
            size--;
            return item;
        }
    }

    @Override
    public Object removeFirst() {
        if (size == 0)
            throw new NoSuchElementException();
        else {
            Object item = begin.next.item;
            begin.next.next.prev = begin;
            begin.next = begin.next.next;
            size--;
            return item;
        }
    }

    @Override
    public Object removeLast() {
        if (size == 0)
            throw new NoSuchElementException();
        else {
            Object item = end.prev.item;
            end.prev.prev.next = end;
            end.prev = end.prev.prev;
            size--;
            return item;
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
        Node node = begin.next;
        while (node != null) {
            if (node.item == item)
                return true;
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean add(Object item) {
        addLast(item);
        return true;
    }

    @Override
    public boolean remove(Object item) {
        Node node = begin.next;
        boolean isDeleted = false;
        while (node != null) {
            if (node.item == item) {
                itemDeleting(node);
                isDeleted = true;
            }
            node = node.next;
        }
        return isDeleted;
    }

    @Override
    public void clear() {
        if (size > 0){
            Node node = begin.next;
            while (node != null) {
                itemDeleting(node);
                node = node.next;
        }
        }
    }

    @Override
    public Iterator<Object> iterator() {
        return new ListIterator(this);
    }
}