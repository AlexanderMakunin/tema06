package com.alexandermakunin.tema06pilascolas;

/**
 * JavaDoc no gracias
 **/
public class Pila {
    private DynamicArray stack;

    public Pila() {
        stack = new DynamicArray();
    }

    public boolean push(double value) {
        return stack.add(value);
    }

    public double pop() {
        if (stack.size() == 0) {
            return stack.getError();
        }
        double value = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return value;
    }

    public double peek() {
        if (stack.size() == 0) {
            return stack.getError();
        }
        return stack.get(stack.size() - 1);
    }

    public int size() {
        return stack.size();
    }

    public double top() {
        return stack.get(stack.size()-1);
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }

    @Override
    public String toString() {
        return "Pila: " + stack.toString();
    }
}
