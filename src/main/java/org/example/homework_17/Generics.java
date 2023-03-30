package org.example.homework_17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/**
 * Homework writing.
 * @author Ruben
 */
public class Generics {
    /**
     * Generic method for given indexes values changing.Task 1.
     * @param array .
     * @param i .
     * @param j .
     * @param <T> .
     */
    public static <T> void exchange(T[] array, int i, int j) {
        if (array == null || i < 0 || j < 0 || i >= array.length || j >= array.length) {
            return;
        }
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Write version for code.Task 2.
     * @param x .
     * @param y .
     * @return .
     * @param <T> .
     */
    public static <T extends Comparable<T>> T max(T x, T y) {
        return x.compareTo(y) > 0 ? x : y;
    }

    /**
     * Yes this code is compile.Task 3.
     * @param list .
     */
    public static void print(List<? extends Number> list) {
        for (Number n : list)
            System.out.print(n + " ");
        System.out.println();
    }

    /**
     * Find max elem in list.Task 4.
     * @param list .
     * @param begin .
     * @param end .
     * @return max elem
     * @param <T> .
     */
    public static <T extends Comparable<T>> T findMax(List<T> list, int begin, int end) {
        if (list == null || list.isEmpty() || begin < 0 || end > list.size() || begin >= end) {
            throw new IllegalArgumentException("Invalid input arguments");
        }
        T max = list.get(begin);
        for (int i = begin + 1; i < end; i++) {
            T current = list.get(i);
            if (current.compareTo(max) > 0) {
                max = current;
            }
        }
        return max;
    }

    /**
     * @param collection .
     * @param predicate .
     * @return count
     * @param <T> .
     */
    public static <T> int count(Collection<T> collection, Predicate<T> predicate) {
        int count = 0;
        for (T element : collection) {
            if (predicate.test(element)) {
                count++;
            }
        }
        return count;
    }


    /**
     * Working method.
     * @param args .
     */
    public static void main(String[] args) {
        //Task 1
        Integer[] arr = new Integer[] {1,2,3,4,5};
        exchange(arr,2,3);
        System.out.println(Arrays.toString(arr));

        //Task 4
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(9);
        list.add(32);

        System.out.println(findMax(list,0, list.size()));

        //Task 5
        Pair<String, Integer> p = new Pair<>("hello", 42);

        //Task 7
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int count = count(numbers, n -> n % 2 != 0);
        System.out.println("Number of odd integers: " + count);
    }
}

/**
 * Generic class.Task 5.
 * @param <T>
 * @param <U>
 */
class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}

/**
 * Library class.Task 6.
 */
class MediaLibrary {
    private List<String> books;
    private List<String> videos;
    private List<String> newspapers;

    public MediaLibrary() {
        books = new ArrayList<>();
        videos = new ArrayList<>();
        newspapers = new ArrayList<>();
    }

    public void addBook(String book) {
        books.add(book);
    }

    public void addVideo(String video) {
        videos.add(video);
    }

    public void addNewspaper(String newspaper) {
        newspapers.add(newspaper);
    }

    public List<String> getBooks() {
        return books;
    }

    public List<String> getVideos() {
        return videos;
    }

    public List<String> getNewspapers() {
        return newspapers;
    }
}

/**
 * Library class with generics.Task 6.
 * @param <T>
 */
class MediaLibraryGeneric<T> {
    private List<T> media;

    public MediaLibraryGeneric() {
        media = new ArrayList<>();
    }

    public void addMedia(T item) {
        media.add(item);
    }

    public List<T> getMedia() {
        return media;
    }
}

