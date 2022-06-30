package generics.collections_1;

import java.util.NoSuchElementException;
import java.util.Iterator;

public class LinkedList<E> implements List<E>, Deque<E> {
    private int size;
    private Node<E> begin;
    private Node<E> end;

    public LinkedList() {
        size = 0;
        begin = new Node<>();
        end = new Node<>();
        begin.next = end;
        end.prev = begin;
    }

    private E itemDeleting(Node<E> node) {
        E item = null;
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
    public void add(int index, E item) {
        if (index > size || index < 0)
            throw new NoSuchElementException();
        else if (index == size)
            addLast(item);
        else if (index == 0)
            addFirst(item);
        else {
            Node<E> node = begin.next;
            for (int i = 0; i < index; i++)
                node = node.next;
            Node<E> newNode = new Node<>(item, node.prev, node);
            node.prev.next = newNode;
            node.prev = newNode;
            size++;
        }
    }

    @Override
    public void set(int index, E item) {
        if (index > size || index < 0)
            throw new NoSuchElementException();
        else if (index == size)
            addLast(item);
        else if (index < (int) size / 2) {
            Node<E> node = begin.next;
            for (int i = 0; i < index; i++)
                node = node.next;
            node.item = item;
        } else {
            Node<E> node = end.prev;
            for (int i = size; i > index+1; i--)
                node = node.prev;
            node.item = item;
        }

    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        Node<E> node = begin.next;
        for (int i = 0; i < index; i++)
            node = node.next;
        return node.item;
    }

    @Override
    public int indexOf(E item) {
        Node<E> node = begin.next;
        for (int i = 0; i < size; i++) {
            if (node.item == item)
                return i;
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E item) {
        Node<E> node = end.prev;
        for (int i = size-1;i >= 0; i--) {
            if (node.item == item) 
                return i;
            node = node.prev;   
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if (index >= size || index < 0)
            throw new NoSuchElementException();
        else {
            E item = null;
            Node<E> node = begin.next;
            for (int i = 0; i < index; i++)
                node = node.next;
            item = itemDeleting(node);
            return item;
        }
    }

    @Override
    public List<E> subList(int fisrtItem, int lastItem) {
        if (lastItem > size || fisrtItem > lastItem || fisrtItem < 0 || lastItem < 0)
            throw new IndexOutOfBoundsException();
        LinkedList<E> lList = new LinkedList<>();
        Node<E> node = begin.next;
        for (int i = 0; i < lastItem; i++) {
            if (i >= fisrtItem)
                lList.addLast(node.item);
            node = node.next;
        }
        return lList;
    }


    @Override
    public void addFirst(E item) {
        if (begin.next.equals(end)) {
            Node<E> node = new Node<>(item, begin, end);
            begin.next = node;
            end.prev = node;
        } else {
            Node<E> node = new Node<>(item, null, begin.next);
            begin.next.prev = node;
            begin.next = node;
        }
        size++;
    }

    @Override
    public void addLast(E item) {
        if (end.prev.equals(begin)) {
            Node<E> node = new Node<>(item, begin, end);
            begin.next = node;
            end.prev = node;
        } else {
            Node<E> node = new Node<>(item, end.prev, null);
            end.prev.next = node;
            end.prev = node;
        }
        size++;
    }

    @Override
    public E getFirst() {
        if (size == 0)
            throw new NoSuchElementException();
        return begin.next.item;

    }

    @Override
    public E getLast() {
        if (size == 0)
            throw new NoSuchElementException();
        return end.prev.item;
    }

    @Override
    public E pollFirst() {
        if (size == 0)
            return null;
        else {
            E item = begin.next.item;
            begin.next.next.prev = begin;
            begin.next = begin.next.next;
            size--;
            return item;
        }
    }

    @Override
    public E pollLast() {
        if (size == 0)
            return null;
        else {
            E item = end.prev.item;
            end.prev.prev.next = end;
            end.prev = end.prev.prev;
            size--;
            return item;
        }
    }

    @Override
    public E removeFirst() {
        if (size == 0)
            throw new NoSuchElementException();
        else {
            E item = begin.next.item;
            begin.next.next.prev = begin;
            begin.next = begin.next.next;
            size--;
            return item;
        }
    }

    @Override
    public E removeLast() {
        if (size == 0)
            throw new NoSuchElementException();
        else {
            E item = end.prev.item;
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
    public boolean contains(E item) {
        Node<E> node = begin.next;
        while (node != null) {
            if (node.item == item)
                return true;
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean add(E item) {
        addLast(item);
        return true;
    }

    @Override
    public boolean remove(E item) {
        Node<E> node = begin.next;
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
            Node<E> node = begin.next;
            while (node != null) {
                itemDeleting(node);
                node = node.next;
        }
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator<>(this);
    }
}