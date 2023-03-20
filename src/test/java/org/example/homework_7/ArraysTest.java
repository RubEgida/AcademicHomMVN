package org.example.homework_7;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.example.homework_7.Arrays.*;

class ArraysTest {

    @Test
    void positiveNumsTest() {
        String str = positiveNums(new int[]{2,0,-4,35,4});
        assertEquals("2 35 4 ", str);
    }

    @Test
    void reverseArrayElementsTest() {
        short[] s = reverseArrayElements(new short[]{1,2,3,4,5});
        assertEquals(java.util.Arrays.toString(new short[]{5,4,3,2,1}),java.util.Arrays.toString(s));
    }

    @Test
    void largestElementInArrayTest() {
        long l = largestElementInArray(new long[]{1,33,678,665,-6654});
        assertEquals(678,l);
    }

    @Test
    void smallerElementInArrayTest() {
        float f = smallerElementInArray(new float[]{1.2f,0.44f,34.5f,0.1f});
        assertEquals(0.1f,f);
    }

    @Test
    void arrayCloneTest() {
        int[] a = arrayClone(new int[]{1,2,3,4,5});
        assertEquals(java.util.Arrays.toString(new int[]{1,2,3,4,5}),java.util.Arrays.toString(a));
    }

    @Test
    void twoArraysAddingTest() {
        int[] a = twoArraysAdding(new int[]{1,1,1,1},new int[]{2,2,2,2});
        assertEquals(new int[]{3,3,3,3},a);
    }

    @Test
    void givenNumInArrayTest() {
        int k = givenNumInArray(new int[]{2,5,3,34,5,3},3);
        assertEquals(2,k);
    }

    @Test
    void treeElementsArrayTest() {
        int[] input = {1, 2, 3, 4};

        ArrayList<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("[1, 2, 3]");
        expectedOutput.add("[1, 3, 4]");
        expectedOutput.add("[2, 3, 4]");
        expectedOutput.add("[3, 1, 2]");
        expectedOutput.add("[4, 1, 2]");
        expectedOutput.add("[4, 2, 3]");

        ArrayList<String> actualOutput = treeElementsArray(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void atLargestToSmallerTest() {
        int[] a = atLargestToSmaller(new int[]{3,2,4,6,89,7,9});
        assertEquals(java.util.Arrays.toString(new int[]{89,9,7,6,4,3,2}), java.util.Arrays.toString(a));
    }

    @Test
    void oddElementsTest() {
        int[] a = oddElements(new int[]{2,3,22,7,5,45});
        assertEquals(java.util.Arrays.toString(new int[]{2,22,3,7,5,45}), java.util.Arrays.toString(a));
    }

    @Test
    void arrayPrintWithoutZeroTest() {
        String a = arrayPrintWithoutZero(new int[]{22,0,4,0,444,0,0});
        assertEquals("224444",a);
    }
}