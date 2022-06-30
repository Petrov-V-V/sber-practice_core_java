package generics.collections_2;

import generics.collections_1.ArrayList;
import generics.collections_1.Collection;

public class TreeMap<K, V> implements Map<K, V>{
    private int size;
    private Node<Entry<K, V>> root;
    private boolean isFound = false;

    public TreeMap() {
        size = 0;
        root = null;
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
    public boolean containsKey(K key) {
        isFound = false;
        return keySearching(root, key);
    }

    private boolean keySearching(Node<Entry<K, V>> descendant, K key) {
        if (key.equals(((Entry<K, V>) descendant.getValue()).getKey()))
            isFound = true;
        if (descendant.getLeft() != null && !isFound) 
            keySearching(descendant.getLeft(), key);
        if (descendant.getRight() != null && !isFound) 
            keySearching(descendant.getRight(), key);
        return isFound;
    }

    @Override
    public boolean containsValue(V value) {
        isFound = false;
        return valueSearching(root, value);
    }

    private boolean valueSearching(Node<Entry<K, V>> descendant, Object value) {
        try{
            if (value.equals(((Entry<K, V>) descendant.getValue()).getValue()))
                isFound = true;
        }catch(NullPointerException exception){
            if (value == null)
                isFound = true;
        }
        if (descendant.getLeft() != null && !isFound) 
            valueSearching(descendant.getLeft(), value);
        if (descendant.getRight() != null && !isFound)
            valueSearching(descendant.getRight(), value);
        return isFound;
    }

    @Override
    public V get(K key) {
        Node<Entry<K, V>> descendant = root;
        while (true) {
            if (key.equals(((Entry<K, V>)descendant.getValue()).getKey()))
                return ((Entry<K, V>) descendant.getValue()).getValue();
            else if (key.hashCode() < ((Entry<K, V>)descendant.getValue()).getKey().hashCode()) {
                descendant = descendant.getRight();
                if (descendant == null)
                    return null;
            }else {
                descendant = descendant.getLeft();  
                if (descendant == null)
                    return null;
            }
        }
    }

    @Override
    public Entry<K, V> put(K key, V value) {
        Node<Entry<K, V>> descendant = root;
        Node<Entry<K, V>> ancestor;
        Node<Entry<K, V>> newNode = new Node<>(new Entry<>(key, value));
        if (root == null) {
            size++;
            root = newNode;
        } else 
            while (!false) {
                ancestor = descendant;
                if (((Entry<K, V>) descendant.getValue()).getKey().equals(key)) {
                    descendant.setValue(new Entry<>(key, value));
                    return newNode.getValue();
                } else if (key.hashCode() < ((Entry<K, V>) descendant.getValue()).getKey().hashCode()) {
                    descendant = descendant.getRight();
                    if (descendant == null) {
                        ancestor.setRight(newNode);
                        size++;
                        return newNode.getValue();
                    }
                } else {
                    descendant = descendant.getLeft();
                    if (descendant == null) {
                        ancestor.setLeft(newNode);
                        size++;
                        return newNode.getValue();
                    }
                }
            }
        return newNode.getValue();
    }

    @Override
    public V remove(K key) {
        Node<Entry<K, V>> curNode = root;
        Node<Entry<K, V>> ancestor = root;
        boolean isRight = false;

        while (!((Entry<K, V>)curNode.getValue()).getKey().equals(key)) {
            ancestor = curNode;
            if (key.hashCode() < ((Entry<K, V>) curNode.getValue()).getKey().hashCode()) {
                isRight = true;
                curNode = curNode.getRight();
            } else {
                isRight = false;
                curNode = curNode.getLeft();
            }
            if (curNode == null)
                return null;
        }
        if (curNode.getLeft() == null && curNode.getRight() == null)
            if (curNode == root)
                root = null;
            else if (isRight)
                ancestor.setRight(null);
            else
                ancestor.setLeft(null);
        else if (curNode.getRight() == null)
            if (curNode == root) 
                root = curNode.getLeft();
            else if (isRight)
                ancestor.setRight(curNode.getLeft());
            else
                ancestor.setLeft(curNode.getLeft());
        else if (curNode.getLeft() == null)
            if (curNode == root)
                root = curNode.getRight();
            else if (isRight)
                ancestor.setRight(curNode.getRight());
            else
                ancestor.setLeft(curNode.getRight());
        else {
            Node<Entry<K, V>> successor = getSuccessor(curNode);
            if (curNode == root)
                root = successor;
            else if (isRight)
                ancestor.setRight(successor);
            else
                ancestor.setLeft(successor);
        }
        size--;
        return ((Entry<K, V>) curNode.getValue()).getValue();
    }

    private Node<Entry<K, V>> getSuccessor(Node<Entry<K, V>> node) {
        Node<Entry<K, V>> ancestor = node;
        Node<Entry<K, V>> successor = node;
        Node<Entry<K, V>> curNode = node.getRight();
        while (curNode != null) {
            ancestor = successor;
            successor = curNode;
            curNode = curNode.getLeft();
        }
        if (successor != node.getRight()) {
            ancestor.setLeft(successor.getRight());
            successor.setRight(node.getRight());
        }
        return successor;
    }

    @Override
    public void clear() {
        size = 0;
        root = null;
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> aList = new ArrayList<>();
        addValue(root, aList);
        return aList;
    }

    private void addValue(Node<Entry<K, V>> descendant, ArrayList<V> aList) {
        aList.add(((Entry<K, V>) descendant.getValue()).getValue());
        if (descendant.getRight() != null)
            addValue(descendant.getRight(), aList);
        if (descendant.getLeft() != null)
            addValue(descendant.getLeft(), aList);
    }

    @Override
    public Collection<K> keySet() {
        ArrayList<K> aList = new ArrayList<>();
        addKey(root, aList);
        return aList;
    }

    private void addKey(Node<Entry<K, V>> descendant, ArrayList<K> aList) {
        aList.add(((Entry<K, V>) descendant.getValue()).getKey());
        if (descendant.getRight() != null) 
            addKey(descendant.getRight(), aList);
        if (descendant.getLeft() != null) 
            addKey(descendant.getLeft(), aList);
    }

    @Override
    public Collection<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> aList = new ArrayList<>();
        addEntry(root, aList);
        return aList;
    }

    private void addEntry(Node<Entry<K, V>> descendant, ArrayList<Entry<K, V>> aList) {
        aList.add(descendant.getValue());
        if (descendant.getRight() != null)
            addEntry(descendant.getRight(), aList);
        if (descendant.getLeft() != null)
            addEntry(descendant.getLeft(), aList);
    }
}