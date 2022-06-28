package collections_1;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public interface Collection extends java.lang.Iterable<Object> {
    int size();
    boolean isEmpty();
    boolean contains(Object item);
    boolean add(Object item);
    boolean remove(Object item);
    void clear();
    Iterator<Object> iterator();
    
    @Override
    default void forEach(Consumer<? super Object> action) {
        Iterable.super.forEach(action);
    }

    @Override
    default Spliterator<Object> spliterator() {
        return Iterable.super.spliterator();
    }
}