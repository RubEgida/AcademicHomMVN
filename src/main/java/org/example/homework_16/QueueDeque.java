package org.example.homework_16;

import java.util.*;

/**
 * Homeworks writing.
 * @author Ruben
 */
public class QueueDeque {
    /**
     * Working method.
     * All tasks in main.
     * @param args .
     */
    public static void main(String[] args) {
        //Task 3.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        pq.add(5);

        System.out.println(pq);

        //Task 4.
        PriorityQueue<String> pqs = new PriorityQueue<>();
        pqs.add("a");
        pqs.add("b");
        pqs.add("c");
        pqs.add("d");
        pqs.add("f");

        System.out.println(pqs);

        //Task 5.
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.add(1);
        ad.add(2);
        ad.add(3);
        ad.add(4);
        ad.add(5);

        System.out.println(ad);

        //Task 6.
//        PriorityQueue<Object> pqo = new PriorityQueue<>();
//        pqo.add(1);
//        pqo.add(1.1);
//        pqo.add(1.2F);
//        pqo.add("a");
//        pqo.add('b');
//
//        System.out.println(pqo); //ClassCast exception.

        //Task 7.
        while (!pq.isEmpty()) {
            int elem = pq.remove();
            System.out.println(elem + " removed!");
        }

        System.out.println(pq);

        //Task 8.
        while (!ad.isEmpty()) {
            int elem = ad.remove();
            System.out.println(elem + " removed!");
        }

        System.out.println(ad);

        //Task 9.
        String searchElem = "c";
        boolean isPresent = false;

        for (String elem : pqs) {
            if (elem.equals(searchElem)) {
                isPresent = true;
                break;
            }
        }

        if (isPresent) {
            System.out.println(searchElem + " is present in queue");
        } else {
            System.out.println(searchElem + " is not present in queue");
        }

        //Task 10.
        ad.add(10);
        ad.add(20);
        ad.add(30);
        ad.add(40);

        int searchElemDeque = 20;
        boolean isPresentDeque = false;

        for (int elem : ad) {
            if (elem == searchElemDeque) {
                isPresentDeque = true;
                break;
            }
        }

        if (isPresentDeque) {
            System.out.println(searchElemDeque + " is present in deque");
        } else {
            System.out.println(searchElemDeque + " is not present in deque");
        }

        //Task 11.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int n = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i += 2) {
            queue.add(i);
        }

        System.out.println("First 50 members of the queue:");
        for (int i = 1; i <= 50; i++) {
            int member = queue.remove();
            System.out.print(member + " ");
            queue.add(member + n);
        }

        //Task 12.
        PriorityQueue<String> colors = new PriorityQueue<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");

        System.out.println("Elements of the priority queue:");
        while (!colors.isEmpty()) {
            System.out.println(colors.remove());
        }

        //Task 13.
        PriorityQueue<String> colors2 = new PriorityQueue<>();
        colors2.add("Orange");

        colors.addAll(colors2);

        //Task 14.
        String elem = pqs.poll();

        System.out.println(elem + " is removed at priorityQueue");

        //Task 15.
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(10);
        priorityQueue.add(20);
        priorityQueue.add(15);

        System.out.println("Elements of the priority queue: " + priorityQueue);

        PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        maxPriorityQueue.addAll(priorityQueue);

        System.out.println("Elements of the maximum priority queue: " + maxPriorityQueue);
    }
}
