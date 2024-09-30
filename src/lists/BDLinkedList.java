package lists;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

//implementation class BDlinkedList for a non-static method sort()
//public class BDLinkedList<E extends Comparable<E>>{
public class BDLinkedList<E>{
    private BNode<E> head;
    private BNode<E> tail;
    private int size = 0;
    private boolean isSorted = false;

    public BDLinkedList(){
    }

    public BDLinkedList(Collection<? extends E> c){
        this();
        addAll(c);
    }

    public void add(E data){
        if (head == null) {
            BNode<E> newNode = new BNode<>(data);
            head = tail = newNode;
        }
        else {
            BNode<E> newNode = new BNode<>(tail, data);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
        isSorted = false;
    }

    public void addAll(Collection<? extends E> c){
        Object[] a = c.toArray();

        if (a.length == 0)
            return;

        for (Object o : a){
            @SuppressWarnings("unchecked") E e = (E) o;
            BNode<E> newNode = new BNode<E>(tail, e);
            tail.setNext(newNode);
            tail = newNode;
        }

        size += a.length;
        isSorted = false;
    }

    public E get(int index){
        if (checkElement(index))
            return searchElement(index).getData();
        throw new IndexOutOfBoundsException();
    }

    public void remove(){
        if (head != null){
            head = head.getNext();
            head.setPrev(null);
            size--;
        }
    }

    public void remove(int index){
        if (checkElement(index)) {
            BNode<E> x = searchElement(index);
            if (x.getPrev() == null){
                head = x.getNext();
                head.setPrev(null);
            }
            else if (x.getNext() == null){
                tail = x.getPrev();
                tail.setNext(null);
            }
            else {
                x.getPrev().setNext(x.getNext());
                x.getNext().setPrev(x.getPrev());
                x.setPrev(null);
                x.setNext(null);
            }
            size--;
        }
        else
            throw new IndexOutOfBoundsException();
    }

    //implementation of a non-static method sort()
    /*
    public void sort(){
        if (!isSorted) {
            for (int i = size - 1; i > 0; i--) {
                BNode<E> curNode = head;
                BNode<E> nextNode = head.getNext();
                for (int j = 0; j < i; j++) {
                    if (curNode.getData().compareTo(nextNode.getData()) > 0) {
                        E tempData = curNode.getData();
                        curNode.setData(nextNode.getData());
                        nextNode.setData(tempData);
                    }
                    curNode = nextNode;
                    nextNode = nextNode.getNext();
                }
            }
            isSorted = true;
        }
    }
    */

    public static <E extends Comparable<E>> void sort(BDLinkedList<E> list){
        if (!list.isSorted) {
            for (int i = list.size - 1; i > 0; i--) {
                BNode<E> curNode = list.head;
                BNode<E> nextNode = list.head.getNext();
                for (int j = 0; j < i; j++) {
                    if (curNode.getData().compareTo(nextNode.getData()) > 0) {
                        E tempData = curNode.getData();
                        curNode.setData(nextNode.getData());
                        nextNode.setData(tempData);
                    }
                    curNode = nextNode;
                    nextNode = nextNode.getNext();
                }
            }
            list.isSorted = true;
        }
    }

    public int getSize() {
        return size;
    }

    private boolean checkElement(int index){
        return index >= 0 && index < size;
    }

    private BNode<E> searchElement(int index){
        if (index <= (size / 2)){
            BNode<E> x = head;
            int count = 0;
            while (true){
                if (index == count)
                    return x;
                x = x.getNext();
                count++;
            }
        }
        else {
            BNode<E> x = tail;
            int count = size-1;
            while (true){
                if (index == count)
                    return x;
                x = x.getPrev();
                count--;
            }
        }
    }
}
