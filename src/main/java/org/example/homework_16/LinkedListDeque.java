package org.example.homework_16;

/**
 * Dequeue implementation with LinkedList.Task 2.
 * @param <T>
 * @author Ruben
 */
public class LinkedListDeque<T> {

    private Node<T> front;
    private Node<T> rear;

    /**
     * Inner class for LinkedList logic.
     * @param <T>
     */
    private static class Node<T> {
        private final T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * Constructor.
     */
    public LinkedListDeque() {
        front = null;
        rear = null;
    }

    /**
     * Element adding at first index.
     * @param data .
     */
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (front == null) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
    }

    /**
     * Element adding at last index.
     * @param data .
     */
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (rear == null) {
            front = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
        }
        rear = newNode;
    }

    /**
     * First element removing.
     * @return first element
     */
    public T removeFirst() {
        if (front == null) {
            return null;
        } else {
            T data = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            } else {
                front.prev = null;
            }
            return data;
        }
    }

    /**
     * Last element removing.
     * @return last element
     */
    public T removeLast() {
        if (rear == null) {
            return null;
        } else {
            T data = rear.data;
            rear = rear.prev;
            if (rear == null) {
                front = null;
            } else {
                rear.next = null;
            }
            return data;
        }
    }

    /**
     * Check list empty or no.
     * @return result
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * List printing.
     */
    public void printDeque() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
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
        LinkedListDeque<String> deque = new LinkedListDeque<>();
        deque.addFirst("apple");
        deque.addLast("banana");
        deque.addLast("orange");

        String fruit1 = deque.removeFirst();
        String fruit2 = deque.removeLast();
        System.out.println(fruit1 + " " + fruit2);

        if (deque.isEmpty()) {
            System.out.println("Deque is empty");
        } else {
            System.out.println("Deque is not empty");
        }

        deque.printDeque();

    }
}

