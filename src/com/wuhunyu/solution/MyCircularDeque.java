package com.wuhunyu.solution;

/**
 * 641. 设计循环双端队列
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/15 8:43
 */

public class MyCircularDeque {

    private class DequeNode {

        private int val;

        private DequeNode prev;

        private DequeNode next;

        public DequeNode(int val, DequeNode prev, DequeNode next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

    }

    private DequeNode head;

    private DequeNode tail;

    private int k;

    private int size;

    public MyCircularDeque(int k) {
        head = new DequeNode(-1, null, null);
        tail = head;
        this.k = k;
    }

    public boolean insertFront(int value) {
        if (this.isFull()) {
            return false;
        }
        size++;
        DequeNode next = head.next;
        DequeNode newNode = new DequeNode(value, head, next);
        head.next = newNode;
        if (next != null) {
            next.prev = newNode;
        } else {
            tail = newNode;
        }
        return true;
    }

    public boolean insertLast(int value) {
        if (this.isFull()) {
            return false;
        }
        size++;
        tail.next = new DequeNode(value, tail, null);
        tail = tail.next;
        return true;
    }

    public boolean deleteFront() {
        if (this.isEmpty()) {
            return false;
        }
        size--;
        DequeNode next = head.next.next;
        if (next == null) {
            head.next = null;
            tail = head;
            return true;
        }
        head.next = next;
        next.prev = head;
        return true;
    }

    public boolean deleteLast() {
        if (this.isEmpty()) {
            return false;
        }
        size--;
        tail = tail.prev;
        tail.next = null;
        return true;
    }

    public int getFront() {
        return this.isEmpty() ? -1 : head.next.val;
    }

    public int getRear() {
        return this.isEmpty() ? -1 : tail.val;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return size == k;
    }

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        System.out.println(myCircularDeque.insertLast(1));
        System.out.println(myCircularDeque.insertLast(2));
        System.out.println(myCircularDeque.insertFront(3));
        System.out.println(myCircularDeque.insertFront(4));
        System.out.println(myCircularDeque.getRear());
        System.out.println(myCircularDeque.isFull());
        System.out.println(myCircularDeque.deleteLast());
        System.out.println(myCircularDeque.insertFront(4));
        System.out.println(myCircularDeque.getFront());
    }

}
