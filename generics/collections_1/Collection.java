package generics.collections_1;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public interface Collection<E> extends java.lang.Iterable<E> {
    int size();
    boolean isEmpty();
    boolean contains(E item);
    boolean add(E item);
    boolean remove(E item);
    void clear();
    Iterator<E> iterator();
    
    @Override
    default void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }

    @Override
    default Spliterator<E> spliterator() {
        return Iterable.super.spliterator();
    }
}