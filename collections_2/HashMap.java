package collections_2;

import collections_1.ArrayList;
import collections_1.LinkedList;
import collections_1.Collection;

public class HashMap implements Map{
    private int capacity;
    private int size;
    private LinkedList[] buckets;

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
        for(LinkedList lList: buckets)
            if(lList != null)
                for (int i = 0; i < lList.size(); i++) 
                    if(((Entry)lList.get(i)).getKey().equals(key))
                        return true;
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for(LinkedList lList: buckets)
            if(lList != null)
                for (int i = 0; i < lList.size(); i++) {
                    try{
                        if(((Entry)lList.get(i)).getValue().equals(value))
                            return true;
                    }catch(NullPointerException exception){}
                    if(((Entry)lList.get(i)).getValue() == null && value == null)
                        return true;
                }
        return false;
    }

    @Override
    public Object get(Object key) {
        int bucketNumber = key.hashCode() % buckets.length;
        LinkedList lList = buckets[bucketNumber];
        for(int i = 0; i < lList.size(); i++)
            if(((Entry)lList.get(i)).getKey().equals(key))
                return ((Entry)lList.get(i)).getValue();
        return null;
    }

    @Override
    public Object put(Object key, Object value) {  
        Entry entry = new Entry(key, value);
        int bucketNumber = key.hashCode() % buckets.length;
        var lList = buckets[bucketNumber];
        if(lList != null){
            for(int i = 0; i < lList.size(); i++)
                if(((Entry) lList.get(i)).getKey().equals(key)){
                    ((Entry) lList.get(i)).setValue(value);
                    return entry;
                }
        }else
            lList = new LinkedList();
        lList.addLast(entry);
        buckets[bucketNumber] = lList;
        size++;
        return entry;
    }

    @Override
    public Object remove(Object key) {
        for (LinkedList lList : buckets)
            if(lList != null)
                for (int i = 0; i < lList.size(); i++)
                    if(((Entry)lList.get(i)).getKey().equals(key)){
                        Entry entry = (Entry) lList.remove(i);
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
    public Collection values() {
        ArrayList values = new ArrayList();
        for (LinkedList lList : buckets) 
            if(lList != null)
                for (int i = 0; i < lList.size(); i++) 
                    values.add(((Entry)lList.get(i)).getValue());
        return values;
    }

    @Override
    public Collection keySet() {
        ArrayList keys = new ArrayList();
        for (LinkedList lList : buckets) 
            if(lList != null)
                for (int i = 0; i < lList.size(); i++) 
                    keys.add(((Entry)lList.get(i)).getKey());
        return keys;
    }

    @Override
    public Collection entrySet() {
        ArrayList entries = new ArrayList();
        for (LinkedList lList : buckets) 
            if(lList != null)
                for (int i = 0; i < lList.size(); i++) 
                    entries.add((Entry)lList.get(i));
        return entries;
    }
}