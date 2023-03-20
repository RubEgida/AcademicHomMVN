package org.example.homework_14;

import org.junit.jupiter.api.Test;

import static org.example.homework_14.SortAlgorithms.*;
import static org.junit.jupiter.api.Assertions.*;

class SortAlgorithmsTest {
    private final int[] arr = new int[] {0,5,4,7,8,6,2,1,9,3};
    private final int[] sortedArr = new int[] {0,1,2,3,4,5,6,7,8,9};
    @Test
    void bubbleSortTest() {
        assertArrayEquals(sortedArr,bubbleSort(arr));
        assertArrayEquals(bubbleSort(arr),insertionSort(arr));
    }

    @Test
    void selectionSortTest() {
        assertArrayEquals(sortedArr,selectionSort(arr));
    }

    @Test
    void insertionSortTest() {
        assertArrayEquals(sortedArr,insertionSort(arr));
    }

    @Test
    void mergeSortTest() {
        assertArrayEquals(sortedArr,mergeSort(arr,arr.length));
    }

    @Test
    void quickSortTest() {
        assertArrayEquals(sortedArr,quickSort(arr,arr.length));
    }
}