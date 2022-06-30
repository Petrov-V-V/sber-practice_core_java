package generics.collections_2;

import generics.collections_1.ArrayList;
import generics.collections_1.LinkedList;
import generics.collections_1.Collection;

public class HashMap<K, V> implements Map<K, V>{
    private int capacity;
    private int size;
    private LinkedList<Entry<K, V>>[] buckets;

    public HashMap(){
        capacity = (int) Math.pow(2,29);
        size = 0;
        buckets = new LinkedList[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0)
            return true;
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        for(LinkedList<Entry<K, V>> lList: buckets)
            if(lList != null)
                for (int i = 0; i < lList.size(); i++) 
                    if(((Entry<K, V>)lList.get(i)).getKey().equals(key))
                        return true;
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for(LinkedList<Entry<K, V>> lList: buckets)
            if(lList != null)
                for (int i = 0; i < lList.size(); i++) {
                    try{
                        if(((Entry<K, V>)lList.get(i)).getValue().equals(value))
                            return true;
                    }catch(NullPointerException exception){}
                    if(((Entry<K, V>)lList.get(i)).getValue() == null && value == null)
                        return true;
                }
        return false;
    }

    @Override
    public V get(K key) {
        int bucketNumber = key.hashCode() % buckets.length;
        LinkedList<Entry<K, V>> lList = buckets[bucketNumber];
        for(int i = 0; i < lList.size(); i++)
            if(((Entry<K, V>)lList.get(i)).getKey().equals(key))
                return ((Entry<K, V>)lList.get(i)).getValue();
        return null;
    }

    @Override
    public Entry<K, V> put(K key, V value) {  
        Entry<K, V> entry = new Entry<>(key, value);
        int bucketNumber = key.hashCode() % buckets.length;
        var lList = buckets[bucketNumber];
        if(lList != null){
            for(int i = 0; i < lList.size(); i++)
                if(((Entry<K, V>) lList.get(i)).getKey().equals(key)){
                    ((Entry<K, V>) lList.get(i)).setValue(value);
                    return entry;
                }
        }else
            lList = new LinkedList<Entry<K, V>>();
        lList.addLast(entry);
        buckets[bucketNumber] = lList;
        size++;
        return entry;
    }

    @Override
    public V remove(K key) {
        for (LinkedList<Entry<K, V>> lList : buckets)
            if(lList != null)
                for (int i = 0; i < lList.size(); i++)
                    if(((Entry<K, V>)lList.get(i)).getKey().equals(key)){
                        Entry<K, V> entry = (Entry<K, V>) lList.remove(i);
                        size--;
                        return entry.getValue();
                    }
        return null;
    }

    @Override
    public void clear() {
        size = 0;
        buckets = new LinkedList[0];
        buckets = new LinkedList[capacity];
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> values = new ArrayList<>();
        for (LinkedList<Entry<K, V>> lList : buckets) 
            if(lList != null)
                for (int i = 0; i < lList.size(); i++) 
                    values.add(((Entry<K, V>)lList.get(i)).getValue());
        return values;
    }

    @Override
    public Collection<K> keySet() {
        ArrayList<K> keys = new ArrayList<>();
        for (LinkedList<Entry<K, V>> lList : buckets) 
            if(lList != null)
                for (int i = 0; i < lList.size(); i++) 
                    keys.add(((Entry<K, V>)lList.get(i)).getKey());
        return keys;
    }

    @Override
    public Collection<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> entries = new ArrayList<>();
        for (LinkedList<Entry<K, V>> lList : buckets) 
            if(lList != null)
                for (int i = 0; i < lList.size(); i++) 
                    entries.add((Entry<K, V>)lList.get(i));
        return entries;
    }
}