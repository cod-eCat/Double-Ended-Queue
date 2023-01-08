package com.lpa.assignments;

    /*
    Double-Ended Queue(Deque) Implementation Using Doubly Linked List
    Author @LwinPhyoAung
     */

import java.util.NoSuchElementException;

public class Deque<Item> {

    private class Node{

        private Item item;
        private Node next;
        private Node pre;
        private Node(Item item){
            this.item = item;
        }

    }

    private Node head;
    private Node tail;
    private int size;

    // construct an empty deque
    public Deque(){
    }

    // is the deque empty?
    public boolean isEmpty(){
        return size==0;
    }

    // return the number of items on the deque
    public int size(){
        return size;
    }

    // add the item to the front
    public void addFirst(Item item){

        if (item == null){
            throw new IllegalArgumentException();
        }
        Node node = new Node(item);
        if (isEmpty()){
            head = node;
            tail = node;
            size++;
            return;
        }
        node.next = head;
        head.pre = node;
        head = node;
        size++;

    }

    // add the item to the back
    public void addLast(Item item){

        if (item == null){
            throw new IllegalArgumentException();
        }
        Node node = new Node(item);
        if (isEmpty()){
            head = node;
            tail = node;
            size++;
            return;
        }
        tail.next = node;
        node.pre = tail;
        tail = node;
        size++;

    }

    // remove and return the item from the front
    public Item removeFirst(){

        if (isEmpty()){
            throw new NoSuchElementException();
        }
        if (size()==1){
            Item cur = head.item;
            head = null;
            tail = null;
            size--;
            return cur;
        }
        Item cur = head.item;
        head = head.next;
        head.pre = null;
        size--;
        return cur;

    }

    // remove and return the item from the back
    public Item removeLast(){

        if (isEmpty()){
            throw new NoSuchElementException();
        }
        if (size()==1){
            Item cur = tail.item;
            head = null;
            tail = null;
            size--;
            return cur;
        }
        Item cur = tail.item;
        tail = tail.pre;
        tail.next = null;
        size--;
        return cur;

    }

    //Test Deque
    public static void main(String[] args) {

        Deque<String> deque = new Deque<>();
        deque.addFirst("First");
        deque.addLast("Second");
        deque.addFirst("Third");

        System.out.println(deque.size());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());
        System.out.println(deque.size());
        deque.removeFirst();

    }

}