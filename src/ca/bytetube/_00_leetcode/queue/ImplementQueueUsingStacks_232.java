package ca.bytetube._00_leetcode.queue;

import java.util.Queue;
import java.util.Stack;

public class ImplementQueueUsingStacks_232 {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public ImplementQueueUsingStacks_232() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (inStack.isEmpty() && outStack.isEmpty())  throw new RuntimeException("queue is empty");

        else if (outStack.isEmpty()){
            while (!inStack.isEmpty())  outStack.push(inStack.pop());
        }

        return outStack.pop();

    }

    public int peek() {
        if (inStack.isEmpty() && outStack.isEmpty())  throw new RuntimeException("queue is empty");

        else if (outStack.isEmpty()){
            while (!inStack.isEmpty())  outStack.push(inStack.pop());
        }

        return outStack.peek();
    }

    public boolean empty() {


        return inStack.isEmpty() && outStack.isEmpty();
    }
}
