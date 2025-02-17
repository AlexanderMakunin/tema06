package com.alexandermakunin.vicente;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PilaTest {

    @Test
    void push() {
        Pila pila = new Pila();

        pila.push(5);
        assertEquals(5, pila.top());

        pila.push(2);
        assertEquals(5, pila.top());

        pila.push(20);
        assertEquals(20, pila.top());

        pila.push(10);
        assertEquals(20, pila.top());

        pila.push(5);
        assertEquals(20, pila.top());
    }
}
