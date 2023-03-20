package org.example.homework_8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringStringBuilderTest {
    StringStringBuilder s = new StringStringBuilder();
    @Test
    void reverseStringTest() {
        String str = s.reverseString("simple");
        assertNotNull(str);
        assertEquals("elpmis",str);
    }

    @Test
    void countSubStringTest() {
        int count = s.countSubString("We are living in Armenia","i");
        assertEquals(4,count);
    }

    @Test
    void stringUpperCaseTest() {
        String str = s.stringUpperCase("abc");
        assertNotNull(str);
        assertEquals("ABC",str);
    }

    @Test
    void stringBuilderUpperCaseTest() {
        String str = s.stringBuilderUpperCase(new StringBuilder("abc"));
        assertNotNull(str);
        assertEquals("ABC",str);
    }

    @Test
    void twentyLengthStringTest() {
        StringBuilder strB = s.twentyLengthString(new StringBuilder("aaa"));
        assertNotNull(strB);
        assertEquals("aaa*****************",strB.toString());
    }

    @Test
    void largestWordInTextTest() {
        String str = s.largestWordInText("We are live in Armenia");
        assertNotNull(str);
        assertEquals("Armenia",str);
    }

    @Test
    void symbolIndexTest() {
        int index = s.symbolIndex("Ruben");
        assertEquals(-1,index);
    }

    @Test
    void printSubLineTest() {
        String str = s.printSubLine("We are living in Armenia",7);
        assertNotNull(str);
        assertEquals("We are ",str);
    }

    @Test
    void isStringNullAndEmptyTest() {
        boolean b = s.isStringNullAndEmpty("as");
        assertFalse(b);
    }

    @Test
    void largestWordBetweenCommasTest() {
        String str = s.largestWordBetweenCommas("I,am,not, ");
        assertEquals("not",str);
    }
}