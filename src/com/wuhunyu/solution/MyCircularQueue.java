package com.wuhunyu.solution;

/**
 * 622. 设计循环队列
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/2 9:43
 */

public class MyCircularQueue {

    private final int[] queue;

    private final int k;

    private int front;

    private int rear;

    private int size;

    public MyCircularQueue(int k) {
        queue = new int[k];
        this.k = k;
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (size >= k) {
            return false;
        }
        size++;
        queue[rear] = value;
        rear = rear >= k - 1 ? 0 : rear + 1;
        return true;
    }

    public boolean deQueue() {
        if (size <= 0) {
            return false;
        }
        size--;
        front = front >= k - 1 ? 0 : front + 1;
        return true;
    }

    public int Front() {
        if (this.isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    public int Rear() {
        if (this.isEmpty()) {
            return -1;
        }
        return queue[rear == 0 ? k - 1 : rear - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.Front());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.Front());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.Front());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.Front());
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.enQueue(3));
        System.out.println(circularQueue.enQueue(3));
    }

}
