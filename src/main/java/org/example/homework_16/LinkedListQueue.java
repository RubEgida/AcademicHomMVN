package org.example.homework_16;

/**
 * Queue implementation with LinkedList.Task 1.
 * @param <T>
 * @author Ruben
 */
public class LinkedListQueue<T> {

    private Node<T> front;
    private Node<T> rear;

    /**
     * Inner class for LinkedList logic.
     * @param <T>
     */
    private static class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Constructor.
     */
    public LinkedListQueue() {
        front = null;
        rear = null;
    }

    /**
     * For member adding.
     * @param data .
     */
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (rear == null) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
    }

    /**
     * Delete first elem.
     * @return firs element
     */
    public T dequeue() {
        if (front == null) {
            return null;
        } else {
            T data = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return data;
        }
    }

    /**
     * Check empty or no.
     * @return result
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * List printing.
     */
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            Node<T> current = front;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    /**
     * Working method.
     * @param args .
     */
    public static void main(String[] args) {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        queue.enqueue("apple");
        queue.enqueue("banana");
        queue.enqueue("orange");

        String fruit = queue.dequeue();
        System.out.println(fruit);

        if (queue.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Queue is not empty");
        }

        queue.printQueue();

    }
}

