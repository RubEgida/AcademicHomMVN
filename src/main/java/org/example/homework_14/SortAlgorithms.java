package org.example.homework_14;

import java.util.Arrays;

/**
 * Homework adding.
 * @author Ruben
 */
public class SortAlgorithms {
    /**
     * Bubble sort algorithm writing.
     * @param arr .
     * @return sorted array
     */
     public static int[] bubbleSort(int[] arr) {
         int elem;
         for (int i = 0; i < arr.length - 1; i++) {
             for (int j = 0; j < arr.length - i - 1; j++) {
                 if (arr[j] > arr[j + 1]) {
                     elem = arr[j + 1];
                     arr[j + 1] = arr[j];
                     arr[j] = elem;
                 }
             }
         }
         return arr;
     }

    /**
     * Selection sort algorithm writing.
     * @param arr .
     * @return sorted array
     */
     public static int[] selectionSort(int[] arr) {
          int min , elem;
         for (int i = 0; i < arr.length; i++) {
             min = i;
             for (int j = i + 1; j < arr.length; j++) {
                 if (arr[min] > arr[j]) {
                     min = j;
                 }
             }
             elem = arr[min];
             arr[min] = arr[i];
             arr[i] = elem;

         }
         return arr;
     }

    /**
     * Insertion sort algorithm writing.
     * @param arr .
     * @return sorted array
     */
     public static int[] insertionSort(int[] arr) {
         int elem;
         for (int i = 1; i < arr.length; i++) {
             if (arr[i] < arr[i - 1]) {
                 elem = arr[i];
                 for (int j = i - 1; j >= 0; j--) {
                     if (arr[j] > elem) {
                         arr[j + 1] = arr[j];
                     } else {
                         arr[j + 1] = elem;
                         break;
                     }
                 }
             }
         }
         return arr;
     }

    /**
     * Merge sort algorithm writing.
     * @param arr .
     * @param n length
     * @return sorted array
     */
     public static int[] mergeSort(int[] arr, int n) {
         if (n < 2) {
             return arr;
         }
         int mid = n / 2;
         int[] l = new int[mid];
         int[] r = new int[n - mid];

         System.arraycopy(arr, 0, l, 0, mid);

         if (n - mid >= 0) System.arraycopy(arr, mid, r, 0, n - mid);

         mergeSort(l, mid);
         mergeSort(r, n - mid);

         merge(arr, l, r, mid, n - mid);

         return arr;
     }

    /**
     * Merge sort continue.
     * @param a .
     * @param l .
     * @param r .
     * @param left .
     * @param right .
     */
    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    /**
     * Quick sort algorithm writing.
     * @param arr .
     * @param elements arr length
     * @return sorted array
     */
    public static int[] quickSort(int[] arr, int elements) {
        if (elements < 2) {
            return arr;
        }

        int current_position = 0;
        int temp;

        for (int i = 1; i < elements; i++){
            if (arr[i] <= arr[0]) {
                current_position++;
                temp = arr[i];
                arr[i] = arr[current_position];
                arr[current_position] = temp;
            }
        }

        temp = arr[0];
        arr[0] = arr[current_position];
        arr[current_position] = temp;

        int[] left = quickSort(arr, current_position);
        int[] arr2 = Arrays.copyOfRange(arr, current_position + 1, elements);
        int[] right = quickSort(arr2, elements - current_position - 1);

        int[] final_array = new int[elements];

        System.arraycopy(left, 0, final_array, 0, current_position);

        final_array[current_position] = arr[current_position];
        for (int i = current_position + 1; i < elements; i++) {
            final_array[i] = right[i - current_position - 1];
        }
        return final_array;
    }


    /**
     * Working method.
     * @param args .
     */
    public static void main(String[] args) {
        //bubble sort
        System.out.println(Arrays.toString(bubbleSort(new int[] {5,4,78,8,7,4,9,3})));

        //selection sort
        System.out.println(Arrays.toString(selectionSort(new int[] {2,3,422,12,34,5665,6,9,1})));

        //insertion sort
        System.out.println(Arrays.toString(insertionSort(new int[] {2,34,553,23,55,78,6})));

        int[] a = new int[] {4,5,3,1,8,7,2,9,22,4,0,4344,53,455,45,532,3};
        //merge sort
        System.out.println(Arrays.toString(mergeSort(a,a.length)));

        System.out.println(Arrays.toString(quickSort(a,a.length)));
    }
}
