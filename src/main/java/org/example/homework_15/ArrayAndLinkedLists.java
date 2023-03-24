package org.example.homework_15;


import java.util.*;

/**
 * Homework writing.
 * @author Ruben
 */
public class ArrayAndLinkedLists {
    private static final Scanner sc = new Scanner(System.in);
    /**
     * ArrayList elements printing.Task 1.
     * @param arr .
     */
    public static void listElementsPrinting(ArrayList<Integer> arr) {
        for (Integer i: arr) {
            System.out.print(i + ", ");
        }
    }

    /**
     * Insert given element at first position in ArrayList.Task 2.
     * @param arr .
     * @param elem .
     */
    public static void elementInsertionAtFirstIndexInList(ArrayList<Integer> arr, int elem) {
        arr.set(0, elem);
    }

    /**
     * Specific elem updating to given elem.Task 3.
     * @param arr .
     * @param specificElem .
     * @param updateElem .
     */
    public static void specificElementUpdating(ArrayList<Integer> arr, int specificElem, int updateElem) {
        int specificElemIndex = arr.indexOf(specificElem);
        try {
            arr.set(specificElemIndex,updateElem);
        } catch (Exception e){
            System.out.println("In this list no specific element!!!");
        }
    }

    /**
     * Given elem searching in list.Task 4.
     * @param arr .
     * @param elem .
     */
    public static void elemSearching(ArrayList<Integer> arr, int elem) {
        if (arr.contains(elem)) {
            System.out.println("The element " + elem + " found in ArrayList.");
        }
        System.out.println("The element " + elem + " not found in ArrayList");
    }

    /**
     * ArrayList copy in another ArrayList.Task 5.
     * @param arr .
     * @return cloned ArrayList
     */
    public static ArrayList<Integer> arrayClone(ArrayList<Integer> arr) {
        return new ArrayList<>(arr);
    }

    /**
     * Elements reverse in ArrayList.Task 6.
     * @param arr .
     */
    public static void arrayElementsRevers(ArrayList<Integer> arr) {
        Collections.reverse(arr);
    }

    /**
     * Elements swap in ArrayList.Task 7.
     * @param arr .
     * @param firstElem .
     * @param secondElem .
     */
    public static void twoElementsSwap(ArrayList<Integer> arr, int firstElem, int secondElem) {
        try {
            Collections.swap(arr, arr.indexOf(firstElem), arr.indexOf(secondElem));
        } catch (Exception e) {
            System.out.println("Element/Elements not found!!!");
        }
    }

    /**
     * ArrayList empty or no.Task 8.
     * @param arr .
     */
    public static void listEmpty(ArrayList<Integer> arr) {
        if (arr.isEmpty()) {
            System.out.println("This ArrayList is empty.");
        } else {
            System.out.println("This ArrayList is not empty.");
        }
    }

    /**
     * Size changing.Task 9.//Պահանջը անհասկանալի էր))
     * @param arr .
     */
    public static void listSizeChanging(ArrayList<Integer> arr) {
        arr.add(6);
        arr.add(7);
    }

    /**
     * Task 1 for LinkedList.Task 10.
     * @param link .
     */
    public static void listElementsPrinting(LinkedList<Integer> link) {
        for (Integer i: link) {
            System.out.print(i + ", ");
        }
    }

    /**
     * Revers order printing.Task 11.
     * @param link .
     */
    public static void listElementsReversOrderPrinting(LinkedList<Integer> link) {
        ListIterator<Integer> i = link.listIterator(link.size());

        while (i.hasPrevious()) {
            int elem = i.previous();
            System.out.print(elem + ", ");
        }
    }

    /**
     * Elems insertion at first and last indexes in LinkedList.Task 12.
     * @param link .
     * @param firstElem .
     * @param lastElem .
     */
    public static void elementsInsertionAtFirstAndLastIndexes(LinkedList<Integer> link, int firstElem, int lastElem) {
        link.addFirst(firstElem);
        link.addLast(lastElem);
    }

    /**
     * Given elem adding,Task 13.
     * @param link .
     * @param elem .
     */
    public static void elementAddingAtLastIndex(LinkedList<Integer> link, int elem) {
        link.add(elem);
    }

    /**
     * First and last elems removing.Task 14.
     * @param link .
     */
    public static void firstAndLastElemsRemoving(LinkedList<Integer> link) {
        link.removeFirst();
        link.removeLast();
    }

    /**
     * Task 5 for LinkedList.Task 15.
     * @param link .
     * @return cloned LinkedList
     */
    public static LinkedList<Integer> arrayClone(LinkedList<Integer> link) {
        return new LinkedList<>(link);
    }

    /**
     * Task 8 for LinkedList.Task 16.
     * @param link .
     */
    public static void listEmpty(LinkedList<Integer> link) {
        if (link.isEmpty()) {
            System.out.println("This LinkedList is empty.");
        } else {
            System.out.println("This LinkedList is not empty.");
        }
    }

    /**
     * Numbers sum and average printing.Task 17.
     * @param elem entered number
     */
    public static void userSeqArrayList(String elem) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (Integer.parseInt(elem) > 0) {
            arr.add(Integer.parseInt(elem));
            int sum = 0;
            double average;
            while (true) {
                System.out.print("Enter positive integer number or enter for end >>> ");
                elem = sc.nextLine();
                if (Integer.parseInt(elem) > 0) {
                    if (elem.isEmpty()) {
                        break;
                    }
                    arr.add(Integer.parseInt(elem));
                }
            }

            for (int number : arr) {
                sum += number;
            }

            average = (double) sum/arr.size();

            System.out.println("Your numbers >>> " + arr);
            System.out.println("Numbers sum is " + sum);
            System.out.println("Numbers average is " + average);
        } else {
            System.out.println("Enter positive integer number or press enter for break elements adding!!!");
            userSeqArrayList(sc.nextLine());
        }
    }

    /**
     * Numbers adding in ArrayList.
     * @param elem .
     * @return array
     */
    public static ArrayList<Integer> givenNumbersAddingInArrayList(String elem) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(Integer.parseInt(elem));

        while (true) {
            System.out.print("Enter integer number or enter for end >>> ");
            elem = sc.nextLine();
            if (elem.isEmpty()) {
                break;
            }
            arr.add(Integer.parseInt(elem));
        }

        return arr;
    }

    /**
     * Given numbers printing at smaller to biggest.Task 18.
     * @param number .
     */
    public static void givenNumbersSortingAndPrinting(String number) {
        ArrayList<Integer> arr = givenNumbersAddingInArrayList(number);

        int biggest;
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = 0; j < arr.size() - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    biggest = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, biggest);
                }
            }
        }

        System.out.println("Your numbers at smaller to biggest >>> " + arr);
    }

    /**
     * Negative numbers removing at ArrayList.Task 19.
     * @param number .
     */
    public static void negativeNumbersDeleting(String number) {
        ArrayList<Integer> arr = givenNumbersAddingInArrayList(number);

        for (int i = arr.size() - 1; i >= 0; i--) {
            if (arr.get(i) < 0) {
                arr.remove(i);
            }
        }

        System.out.println("Your numbers without negatives >>> " + arr);
    }

    /**
     * Odd time occur numbers deleting.Task 20.
     * @param number .
     */
    public static void oddTimeOccurNumbersDeleting(String number) {
        ArrayList<Integer> arr = givenNumbersAddingInArrayList(number);

        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int num : arr) {
            if (counts.containsKey(num)) {
                counts.put(num, counts.get(num) + 1);
            } else {
                counts.put(num, 1);
            }
        }

        for (int i = arr.size() - 1; i >= 0; i--) {
            int elem = arr.get(i);
            if (counts.get(elem) % 2 != 0) {
                arr.remove(i);
            }
        }

        System.out.println("Odd time occur numbers deleted! Even time occur numbers >>> " + arr);
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        LinkedList<Integer> link = new LinkedList<>();
        link.add(1);
        link.add(2);
        link.add(3);
        link.add(4);
        link.add(5);

        //ArrayList methods testing
        listElementsPrinting(arr);

        elementInsertionAtFirstIndexInList(arr, 0);
        System.out.println(arr);

        specificElementUpdating(arr, 0, 1);
        System.out.println(arr);

        elemSearching(arr,1);

        System.out.println(arrayClone(arr));

        arrayElementsRevers(arr);
        System.out.println(arr);

        twoElementsSwap(arr,8,2);
        System.out.println(arr);

        listEmpty(arr);

        System.out.println(arr.size());
        listSizeChanging(arr);
        System.out.println(arr.size());

        //LinkedList methods testing
        listElementsPrinting(link);

        listElementsReversOrderPrinting(link);

        elementsInsertionAtFirstAndLastIndexes(link,0,6);
        System.out.println(link);

        elementAddingAtLastIndex(link,7);
        System.out.println(link);

        firstAndLastElemsRemoving(link);
        System.out.println(link);

        System.out.println(arrayClone(link));

        listEmpty(link);

        //
        System.out.print("Enter positive integer number >>> ");
        try {
            userSeqArrayList(sc.nextLine());
        } catch (Exception e) {
            System.out.println("You are loser:-)");
        }

        System.out.print("Enter integer number >>> ");
        try {
            givenNumbersSortingAndPrinting(sc.nextLine());
        } catch (Exception e) {
            System.out.println("You are loser:-)");
        }

        System.out.print("Enter integer number >>> ");
        try {
            negativeNumbersDeleting(sc.nextLine());
        } catch (Exception e) {
            System.out.println("You are loser:-)");
        }

        System.out.print("Enter integer number >>> ");
        try {
            oddTimeOccurNumbersDeleting(sc.nextLine());
        } catch (Exception e) {
            System.out.println("You are loser:-)");
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
    }
}

/**
 * Task 21.
 * @param <T>
 */
class Stack<T> {
    private final ArrayList<T> items;

    public Stack() {
        items = new ArrayList<T>();
    }

    public void push(T item) {
        items.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return items.remove(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
