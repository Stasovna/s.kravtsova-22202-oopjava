package session;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

public class CalculationSession { // используем функции для стека и мапы
    private Stack<Double> calStack = new Stack<>();
    private HashMap<String, Double> values = new HashMap<>();

    public void push(Double val) {
        calStack.push(val);
    }

    public Double pop() throws EmptyStackException {
        return calStack.pop();
    }

    public Double peek() throws EmptyStackException {
        return calStack.peek();
    }

    public void insertValue(String name, Double val) {
        values.put(name, val);
    }

    public Double getValue(String name) {
        return values.get(name);
    }
}