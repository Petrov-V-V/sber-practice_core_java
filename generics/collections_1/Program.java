package generics.collections_1;

import java.util.NoSuchElementException;

public class Program {
    public static void main(String[] args) {
        System.out.println("\tLIST TESTING\n");
        System.out.println("\tadd testing");
        ArrayList<Integer> testList = new ArrayList<>();
        for (int i = 0; i < 8; i++) 
            testList.add(i);
        for (Object item : testList) 
            System.out.print(item + " ");
            System.out.println();
        try{
            testList.add(9, 10);
        } catch (IndexOutOfBoundsException exception){
            System.out.println("IndexOutOfBoundsException");
        }
        
        System.out.println("\tset testing");
        for (int i = 7; i >= 0; i--) 
            testList.set(i, 7-i);
        testList.set(7, 7);
        for (Object item : testList) 
            System.out.print(item + " ");
        System.out.println();
        try{
            testList.set(9, 10);
        } catch (IndexOutOfBoundsException exception){
            System.out.println("IndexOutOfBoundsException");
        }

        System.out.println("\tget testing");
        System.out.println(testList.get(4)); 
        try {
            testList.get(-2);
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("IndexOutOfBoundsException");
        }

        System.out.println("\tindexOf testing");
        System.out.println(testList.indexOf(7));
        System.out.println(testList.indexOf(-2));
          
        System.out.println("\tlastIndexOf testing");
        System.out.println(testList.lastIndexOf(7));
        System.out.println(testList.lastIndexOf(-2));
          
        System.out.println("\tremove testing");
        testList.remove(7);
        for (Object item : testList) 
            System.out.print(item + " ");
        System.out.println();
        try {
            testList.remove(-2);
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("IndexOutOfBoundsException");
        }
        
        System.out.println("\tsubList testing");
        ArrayList<Integer> testSubList1 = (ArrayList<Integer>) testList.subList(0, 6);
        ArrayList<Integer> testSubList2 = (ArrayList<Integer>) testList.subList(3, 5);
        for (Object item : testSubList1) 
            System.out.print(item + " ");
        System.out.println();
        for (Object item : testSubList2) 
            System.out.print(item + " ");
        System.out.println();
        try {
            testList.subList(6, 0);
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("IndexOutOfBoundsException");
        } 

        System.out.println("\tcontains testing");
        System.out.println(testList.contains(7));
        System.out.println(testList.contains(0));

        System.out.println("\tisEmpty and clear testing");
        System.out.println(testList.isEmpty());
        testList.clear();
        System.out.println(testList.isEmpty());


        System.out.println("\n\tLINKED LIST TESTING\n");
        System.out.println("\tadd testing");
        LinkedList<Integer> testLinkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) 
            testLinkedList.add(i);
        for (Object item : testLinkedList) 
            System.out.print(item + " ");
        System.out.println();
        try {
            testLinkedList.add(12, 5);
        } catch (NoSuchElementException exception) {
            System.out.println("NoSuchElementException");
        }
        
        System.out.println("\tset testing");
        for (int i = 9; i >= 0; i--) 
            testLinkedList.set(i, 9-i);
        testLinkedList.set(9, 9);
        for (Object item : testLinkedList) 
            System.out.print(item + " ");
        System.out.println();
        try {
            testLinkedList.set(11, 6);
        } catch (NoSuchElementException exception) {
            System.out.println("NoSuchElementException");
        }

        System.out.println("\tget testing");
        System.out.println(testLinkedList.get(5)); 
        try {
            testLinkedList.get(-2);
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("IndexOutOfBoundsException");
        }

        System.out.println("\tindexOf testing");
        System.out.println(testLinkedList.indexOf(9));
        System.out.println(testLinkedList.indexOf(-2));
          
        System.out.println("\tlastIndexOf testing");
        System.out.println(testLinkedList.lastIndexOf(9));
        System.out.println(testLinkedList.lastIndexOf(-2));
          
        System.out.println("\tremove testing");
        testLinkedList.remove(9);
        for (Object item : testLinkedList) 
            System.out.print(item + " ");
        System.out.println();
        try {
            testLinkedList.remove(-2);
        } catch (NoSuchElementException exception) {
            System.out.println("NoSuchElementException");
        }

        System.out.println("\tsubList testing");
        LinkedList<Integer> testSubLinkedList1 = (LinkedList<Integer>) testLinkedList.subList(0, 9);
        LinkedList<Integer> testSubLinkedList2 = (LinkedList<Integer>) testLinkedList.subList(4, 6);
        for (Object item : testSubLinkedList1) 
            System.out.print(item + " ");
        System.out.println();
        for (Object item : testSubLinkedList2) 
            System.out.print(item + " ");
        System.out.println();
        try {
            testLinkedList.subList(5, 1);
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("IndexOutOfBoundsException");
        }

        System.out.println("\tcontains testing");
        System.out.println(testLinkedList.contains(9));
        System.out.println(testLinkedList.contains(0));

        System.out.println("\tisEmpty and clear testing");
        System.out.println(testSubLinkedList1.isEmpty());
        testSubLinkedList1.clear();
        System.out.println(testSubLinkedList1.isEmpty());

        System.out.println("\taddFirst and getFirst testing");
        for (int i = 6; i >= 5; i--) {
            testSubLinkedList2.addFirst(i);
            System.out.println(testSubLinkedList2.getFirst());
        }
        for (Object item : testSubLinkedList2) 
            System.out.print(item + " ");
        System.out.println();
        try {
            System.out.println(testSubLinkedList1.getFirst());
        } catch (NoSuchElementException exception) {
            System.out.println("NoSuchElementException");
        }

        System.out.println("\taddLast and getLast testing");
        for (int i = 5; i < 7; i++) {
            testSubLinkedList2.addLast(i);
            System.out.println(testSubLinkedList2.getLast());
        }
        for (Object item : testSubLinkedList2) 
            System.out.print(item + " ");
        System.out.println();
        try {
            System.out.println(testSubLinkedList1.getLast());
        } catch (NoSuchElementException exception) {
            System.out.println("NoSuchElementException");
        }

        System.out.println("\tpollFirst and removeFirst testing");
        testSubLinkedList2.pollFirst();
        for (Object item : testSubLinkedList2) 
            System.out.print(item + " ");
        System.out.println();
        testSubLinkedList2.removeFirst();
        for (Object item : testSubLinkedList2) 
            System.out.print(item + " ");
        System.out.println();
        System.out.println(testSubLinkedList1.pollFirst());
        try {
            System.out.println(testSubLinkedList1.removeFirst());
        } catch (NoSuchElementException exception) {
            System.out.println("NoSuchElementException");
        }

        System.out.println("\tpollLast and removeLast testing");
        testSubLinkedList2.pollLast();
        for (Object item : testSubLinkedList2) 
            System.out.print(item + " ");
        System.out.println();
        testSubLinkedList2.removeLast();
        for (Object item : testSubLinkedList2) 
            System.out.print(item + " ");
        System.out.println();
        System.out.println(testSubLinkedList1.pollLast());
        try {
            System.out.println(testSubLinkedList1.removeLast());
        } catch (NoSuchElementException exception) {
            System.out.println("NoSuchElementException");
        }
    }
}