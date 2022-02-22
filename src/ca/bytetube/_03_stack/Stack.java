package ca.bytetube._03_stack;

import ca.bytetube._03_stack.list.LinkedList;


public class Stack<E> {

    private LinkedList<E> list = new LinkedList<>();

    // Clear all elements in stack
    public void clear() {
        list.clear();
    };

    // Number of elements
   public int size() {
        return list.size();
    };

    // Is stack empty Top of stack
    public boolean isEmpty() {
        return list.isEmpty();
    };


    public void push(E element) {
        list.add(element);
    };


    public E pop() {
        return list.remove(list.size() - 1);
    };


    // Get the top element of the stack
    public E top() {
        return list.get(list.size() - 1);
    } ;

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i+10);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
        }

    }




}
