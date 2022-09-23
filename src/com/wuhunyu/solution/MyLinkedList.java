package com.wuhunyu.solution;

/**
 * 707. 设计链表
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-23 8:20
 */

public class MyLinkedList {

    private static class Node {

        private Node prev;

        private int val;

        private Node next;

        public Node() {
        }

        public Node(Node prev, int val) {
            this.prev = prev;
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(Node prev, int val, Node next) {
            this.prev = prev;
            this.val = val;
            this.next = next;
        }
    }

    private Node head;

    private Node tail;

    private int size;

    public MyLinkedList() {
        Node node = new Node();
        head = node;
        tail = node;
    }

    public int get(int index) {
        Node node = this.getNode(index);
        return node == null ? -1 : node.val;
    }

    private Node getNode(int index) {
        if (index >= size) {
            return null;
        }
        Node node = this.head.next;
        int count = 0;
        while (count++ < index) {
            node = node.next;
        }
        return node;
    }

    public void addAtHead(int val) {
        size++;
        Node node = new Node(head, val);
        Node next = this.head.next;
        head.next = node;
        if (head == tail) {
            tail = node;
        } else {
            node.next = next;
            next.prev = node;
        }
    }

    public void addAtTail(int val) {
        size++;
        Node node = new Node(tail, val);
        tail.next = node;
        tail = node;
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            this.addAtHead(val);
        } else {
            Node node = this.getNode(index - 1);
            if (node == null) {
                return;
            }
            size++;
            Node next = node.next;
            Node newNode = new Node(node, val, next);
            node.next = newNode;
            if (next != null) {
                next.prev = newNode;
            } else {
                tail = newNode;
            }
        }
    }

    public void deleteAtIndex(int index) {
        Node node = this.getNode(index);
        if (node == null) {
            return;
        }
        size--;
        if (node == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        if (next != null) {
            next.prev = prev;
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

        linkedList.addAtHead(1);
        linkedList.deleteAtIndex(0);
    }

}
