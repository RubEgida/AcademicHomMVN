package org.example.homework_17;

import java.util.*;

/**
 * Homework writing.
 * @author Ruben
 */
public class SetAndMap {
    /**
     * Find the common elems in two HashSets.Task 1.A.
     * @param first .
     * @param second .
     * @return common elems
     */
    public static ArrayList<Integer> hashSetCommonElems(HashSet<Integer> first, HashSet<Integer> second) {
        ArrayList<Integer> commonElems = new ArrayList<>();
        for (Integer elem : first) {
            if (second.contains(elem)){
                commonElems.add(elem);
            }
        }
        return commonElems;
    }

    /**
     * The uniq elems adding in new HashSet and return.Task 1.C.
     * @param set .
     * @return new HashSet
     */
    public static HashSet<String> getUniqueWordsIgnoreCase(HashSet<String> set) {
        HashSet<String> uniqueSet = new HashSet<>();

        for (String str : set) {
            uniqueSet.add(str.toLowerCase());
        }

        return uniqueSet;
    }

    /**
     * Find and remove even numbers.Task 2.A.
     * @param set .
     * @return set
     */
    public static LinkedHashSet<Integer> evenNumRemoving(LinkedHashSet<Integer> set) {
        set.removeIf(elem -> elem % 2 == 0);
        return set;
    }

    /**
     * Find not common elems in two TreeSets and add in new TreeSet.Task 3.B.
     * @param first .
     * @param second .
     * @return new TreeSet
     */
    public static TreeSet<Integer> treeSetNotCommonElems(TreeSet<Integer> first, TreeSet<Integer> second) {
        TreeSet<Integer> third = new TreeSet<>();
        for (Integer elem : first) {
            if (!second.contains(elem)) {
                third.add(elem);
            }
        }
        return third;
    }

    /**
     * The uniq elems adding in new TreeSet and return.Task 1.C.
     * @param set .
     * @return new TreeSet
     */
    public static TreeSet<String> getUniqueWordsIgnoreCase(TreeSet<String> set) {
        TreeSet<String> treeSet = new TreeSet<>();

        for (String elem : set) {
            treeSet.add(elem.toLowerCase());
        }
        return treeSet;
    }

    /**
     * Longest subsequence finding with HashMap.Task 4.A.
     * @param arr .
     * @return longest subsequence
     */
    public static int getLongestConsecutiveSubsequence(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int k : arr) {
            map.put(k, true);
        }

        int longestConsecutiveSubsequence = 0;

        for (int k : arr) {
            if (map.containsKey(k - 1)) {
                continue;
            }

            int j = k;
            while (map.containsKey(j)) {
                j++;
            }

            longestConsecutiveSubsequence = Math.max(longestConsecutiveSubsequence, j - k);
        }

        return longestConsecutiveSubsequence;
    }

    /**
     * Find and return how much anagram pairs in array with HashMap.Task 4.B.
     * @param arr .
     * @return anagram pairs count
     */
    public static int countAnagramPairs(String[] arr) {
        HashMap<String, Integer> map = new HashMap<>();
        int numAnagramPairs = 0;
        for (String str : arr) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            if (map.containsKey(sortedStr)) {
                int count = map.get(sortedStr);
                numAnagramPairs += count;
                map.put(sortedStr, count + 1);
            } else {
                map.put(sortedStr, 1);
            }
        }
        return numAnagramPairs;
    }

    /**
     * Find and return merged intervals.Task 5.A.
     * @param intervals .
     * @return list of merged intervals
     */
    public static List<Interval> mergeIntervals(List<Interval> intervals) {
        List<Interval> mergedIntervals = new ArrayList<>();
        if (intervals == null || intervals.isEmpty()) {
            return mergedIntervals;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Interval interval : intervals) {
            map.put(interval.start, map.getOrDefault(interval.start, 0) + 1);
            map.put(interval.end, map.getOrDefault(interval.end, 0) - 1);
        }
        int start = -1;
        int count = 0;
        for (int point : map.keySet()) {
            count += map.get(point);
            if (count == 1) {
                start = point;
            } else if (count == 0) {
                mergedIntervals.add(new Interval(start, point));
                start = -1;
            }
        }
        return mergedIntervals;
    }

    /**
     * Find and return frequent strings.Task 5.B.
     * @param strings .
     * @param k .
     * @return list of frequent strings
     */
    public static List<String> getTopKFrequentStrings(List<String> strings, int k) {
        List<String> topKFrequentStrings = new ArrayList<>();
        if (strings == null || strings.isEmpty() || k <= 0) {
            return topKFrequentStrings;
        }
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String string : strings) {
            map.put(string, map.getOrDefault(string, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        while (!heap.isEmpty()) {
            topKFrequentStrings.add(0, heap.poll().getKey());
        }
        return topKFrequentStrings;
    }
    /**
     * Working method.
     * @param args .
     */
    public static void main(String[] args) {
        //Task 1.A
        HashSet<Integer> first = new HashSet<>();
        first.add(1);
        first.add(5);
        first.add(8);
        first.add(11);
        HashSet<Integer> second = new HashSet<>();
        second.add(2);
        second.add(55);
        second.add(8);
        second.add(5);

        System.out.println("Common elements two HashSets is " + hashSetCommonElems(first,second));

        //Task 1.B
        HashSet<Person> set = new HashSet<>();
        set.add(new Person("Alice", 25));
        set.add(new Person("Bob", 30));
        set.add(new Person("Charlie", 20));

        ArrayList<Person> list = new ArrayList<>(set);
        list.sort(new AgeComparator());

        for (Person p : list) {
            System.out.println(p);
        }

        //Task 1.C
        HashSet<String> setSt = new HashSet<>();
        setSt.add("Hello");
        setSt.add("world");
        setSt.add("hello");
        setSt.add("WORLD");
        setSt.add("Java");

        HashSet<String> uniqueSet = getUniqueWordsIgnoreCase(setSt);
        System.out.println(uniqueSet);

        //Task 2.A
        LinkedHashSet<Integer> numbers = new LinkedHashSet<>();
        numbers.add(1);
        numbers.add(6);
        numbers.add(8);
        numbers.add(4);

        System.out.println("Even elems removed set is " + evenNumRemoving(numbers));

        //Task 2.B
        LinkedHashSet<Person> nameAge = new LinkedHashSet<>();
        nameAge.add(new Person("Davit",24));
        nameAge.add(new Person("Lianna",19));
        nameAge.add(new Person("Davit",30));
        nameAge.add(new Person("Rozalia",12));

        ArrayList<Person> list1 = new ArrayList<>(nameAge);
        list1.sort(new AgeComparator());

        for (Person per : list1) {
            System.out.println(per);
        }

        //Task 2.C
        LinkedHashSet<Person> setP = new LinkedHashSet<>();

        for (Person p : nameAge) {
            boolean isDuplicate = false;
            for (Person newP : setP) {
                if (newP.getName().equals(p.getName())) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                setP.add(p);
            }
        }
        nameAge = setP;
        System.out.println("Set without duplicate names >>> " + nameAge);

        //Task 3.A
        TreeSet<Person> treeSetPerson = new TreeSet<>(new AgeComparator());
        treeSetPerson.add(new Person("Rafael", 23));
        treeSetPerson.add(new Person("Ruben", 24));
        treeSetPerson.add(new Person("Liza", 21));
        treeSetPerson.add(new Person("Leila", 18));

        System.out.println(treeSetPerson);

        //Task 3.B
        TreeSet<Integer> firstTS = new TreeSet<>();
        firstTS.add(1);
        firstTS.add(5);
        firstTS.add(7);
        firstTS.add(9);
        TreeSet<Integer> secondTS = new TreeSet<>();
        secondTS.add(3);
        secondTS.add(5);
        secondTS.add(8);
        secondTS.add(2);

        System.out.println("Not common elems in two TreeSets >>> " + treeSetNotCommonElems(firstTS,secondTS));

        //Task 3.C
        TreeSet<String> uniq = new TreeSet<>();
        uniq.add("Ruben");
        uniq.add("RUBen");
        uniq.add("RubeN");
        uniq.add("RUBEN");
        uniq.add("ruben");

        System.out.println(getUniqueWordsIgnoreCase(uniq));

        //Task 4.A
        int[] arr = {1, 3, 2, 4, 7, 5, 6};
        int longestConsecutiveSubsequence = getLongestConsecutiveSubsequence(arr);
        System.out.println("Length of longest consecutive subsequence: " + longestConsecutiveSubsequence);

        //Task 4.B
        String[] arr1 = {"dog", "god", "cat", "act", "mice"};
        int numAnagramPairs = countAnagramPairs(arr1);
        System.out.println("Number of anagram pairs: " + numAnagramPairs);

        //Task 5.A
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        List<Interval> mergedIntervals = mergeIntervals(intervals);
        System.out.println("Merged intervals: " + mergedIntervals);

        //Task 5.B
        List<String> strings = new ArrayList<>();
        strings.add("apple");
        strings.add("banana");
        strings.add("apple");
        strings.add("cherry");
        strings.add("banana");
        strings.add("apple");
        strings.add("date");
        int k = 2;
        List<String> topKFrequentStrings = getTopKFrequentStrings(strings, k);
        System.out.println("Top " + k + " frequent strings: " + topKFrequentStrings);
    }
}

/**
 * Class person for HashSet elem.Task 1.B, 2.B and 3.A.
 * @author Ruben
 */
class Person {
    String name;
    int age;

    /**
     * Constructor.
     * @param name .
     * @param age .
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * @return toString form
     */
    public String toString() {
        return name + " (" + age + ")";
    }

    /**
     * Getter for name.
     * @return name
     */
    public String getName() {
        return name;
    }
}

/**
 * Comparator for Person class.Task 1.B, 2.B and 3.A.
 * @author Ruben
 */
class AgeComparator implements Comparator<Person> {
    /**
     * @param p1 the first object to be compared.
     * @param p2 the second object to be compared.
     * @return higher one
     */
    public int compare(Person p1, Person p2) {
        return p1.age - p2.age;
    }
}

/**
 * Interval elem for list.Task 5.A.
 * @author Ruben
 */
class Interval {
    int start;
    int end;

    /**
     * Constructor.
     * @param start .
     * @param end .
     */
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * @return toString form
     */
    @Override
    public String toString() {
        return "(" + start + ", " + end + ")";
    }
}