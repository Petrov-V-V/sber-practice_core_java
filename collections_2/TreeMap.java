package collections_2;

import collections_1.ArrayList;
import collections_1.Collection;

public class TreeMap implements Map{
    private int size;
    private Node root;
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
    public boolean containsKey(Object key) {
        isFound = false;
        return keySearching(root, key);
    }

    private boolean keySearching(Node descendant, Object key) {
        if (key.equals(((Entry) descendant.getValue()).getKey()))
            isFound = true;
        if (descendant.getLeft() != null && !isFound) 
            keySearching(descendant.getLeft(), key);
        if (descendant.getRight() != null && !isFound) 
            keySearching(descendant.getRight(), key);
        return isFound;
    }

    @Override
    public boolean containsValue(Object value) {
        isFound = false;
        return valueSearching(root, value);
    }

    private boolean valueSearching(Node descendant, Object value) {
        try{
            if (value.equals(((Entry) descendant.getValue()).getValue()))
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
    public Object get(Object key) {
        Node descendant = root;
        while (true) {
            if (key.equals(((Entry)descendant.getValue()).getKey()))
                return ((Entry) descendant.getValue()).getValue();
            else if (key.hashCode() < ((Entry)descendant.getValue()).getKey().hashCode()) {
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
    public Object put(Object key, Object value) {
        Node descendant = root;
        Node ancestor;
        Node newNode = new Node(new Entry(key, value));
        if (root == null) {
            size++;
            root = newNode;
        } else 
            while (!false) {
                ancestor = descendant;
                if (((Entry) descendant.getValue()).getKey().equals(key)) {
                    descendant.setValue(new Entry(key, value));
                    return newNode;
                } else if (key.hashCode() < ((Entry) descendant.getValue()).getKey().hashCode()) {
                    descendant = descendant.getRight();
                    if (descendant == null) {
                        ancestor.setRight(newNode);
                        size++;
                        return newNode;
                    }
                } else {
                    descendant = descendant.getLeft();
                    if (descendant == null) {
                        ancestor.setLeft(newNode);
                        size++;
                        return newNode;
                    }
                }
            }
        return newNode;
    }

    @Override
    public Object remove(Object key) {
        Node curNode = root;
        Node ancestor = root;
        boolean isRight = false;

        while (!((Entry)curNode.getValue()).getKey().equals(key)) {
            ancestor = curNode;
            if (key.hashCode() < ((Entry) curNode.getValue()).getKey().hashCode()) {
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
            Node successor = getSuccessor(curNode);
            if (curNode == root)
                root = successor;
            else if (isRight)
                ancestor.setRight(successor);
            else
                ancestor.setLeft(successor);
        }
        size--;
        return ((Entry) curNode.getValue()).getValue();
    }

    private Node getSuccessor(Node node) {
        Node ancestor = node;
        Node successor = node;
        Node curNode = node.getRight();
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
    public Collection values() {
        ArrayList aList = new ArrayList();
        addValue(root, aList);
        return aList;
    }

    private void addValue(Node descendant, ArrayList aList) {
        aList.add(((Entry) descendant.getValue()).getValue());
        if (descendant.getRight() != null)
            addValue(descendant.getRight(), aList);
        if (descendant.getLeft() != null)
            addValue(descendant.getLeft(), aList);
    }

    @Override
    public Collection keySet() {
        ArrayList aList = new ArrayList();
        addKey(root, aList);
        return aList;
    }

    private void addKey(Node descendant, ArrayList aList) {
        aList.add(((Entry) descendant.getValue()).getKey());
        if (descendant.getRight() != null) 
            addKey(descendant.getRight(), aList);
        if (descendant.getLeft() != null) 
            addKey(descendant.getLeft(), aList);
    }

    @Override
    public Collection entrySet() {
        ArrayList aList = new ArrayList();
        addEntry(root, aList);
        return aList;
    }

    private void addEntry(Node descendant, ArrayList aList) {
        aList.add(descendant.getValue());
        if (descendant.getRight() != null)
            addEntry(descendant.getRight(), aList);
        if (descendant.getLeft() != null)
            addEntry(descendant.getLeft(), aList);
    }
}