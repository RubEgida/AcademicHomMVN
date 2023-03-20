package org.example.homework_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.example.homework_2.Methods.*;

class MethodsTest {

    @Test
    void met1Test() {
        int a = 0;
        assertEquals(met1(1,2),a);
    }

    @Test
    void met4Test() {
        char a = met4('a');
        assertEquals('a',a);
    }

    @Test
    void met5Test() {
        float a = met5(1.2f,23.2f);
        assertEquals(1.2f,a);
    }
}