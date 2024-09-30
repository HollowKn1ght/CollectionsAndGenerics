import lists.BDLinkedList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Java List:");
        LinkedList<Integer> javaList = new LinkedList<Integer>();
        javaList.add(23);
        javaList.add(22);
        javaList.add(21);
        javaList.remove();
        javaList.remove(1);

        Collection<Integer> collectionForJavaList = new ArrayList<Integer>();
        collectionForJavaList.add(23);
        collectionForJavaList.add(22);
        collectionForJavaList.add(21);

        javaList.addAll(collectionForJavaList);
        for (int elem : javaList)
            System.out.print(elem + " ");

        System.out.println();

        javaList.sort(null);
        for (int elem : javaList)
            System.out.print(elem + " ");

        System.out.println();

        //----------------------------------------------------

        System.out.println("My List Integers:");

        BDLinkedList<Integer> myList = new BDLinkedList<Integer>();
        myList.add(23);
        myList.add(22);
        myList.add(21);
        myList.remove();
        myList.remove(1);

        Collection<Integer> collectionForMyList = new ArrayList<Integer>();
        collectionForMyList.add(23);
        collectionForMyList.add(22);
        collectionForMyList.add(21);
        collectionForMyList.add(26);
        collectionForMyList.add(28);

        myList.addAll(collectionForMyList);
        for (int i = 0; i < myList.getSize(); i++)
            System.out.print(myList.get(i) + " ");

        System.out.println();

        for (int i = myList.getSize()-1; i >= 0; i--)
            System.out.print(myList.get(i) + " ");

        System.out.println();

        BDLinkedList.sort(myList);
        for (int i = 0; i < myList.getSize(); i++)
            System.out.print(myList.get(i) + " ");

        System.out.println();
        System.out.println("My List Characters:");

        BDLinkedList<Character> myListCh = new BDLinkedList<>();
        myListCh.add('g');
        myListCh.add('j');
        myListCh.add('u');
        myListCh.add('a');
        myListCh.add('s');

        for (int i = 0; i < myListCh.getSize(); i++)
            System.out.print(myListCh.get(i) + " ");

        System.out.println();

        BDLinkedList.sort(myListCh);
        for (int i = 0; i < myListCh.getSize(); i++)
            System.out.print(myListCh.get(i) + " ");
    }
}