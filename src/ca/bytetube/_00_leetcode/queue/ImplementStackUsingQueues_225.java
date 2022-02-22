package ca.bytetube._00_leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues_225 {
    private Queue<Integer> data;
    private Queue<Integer> help;

    public ImplementStackUsingQueues_225() {
        data = new LinkedList<>();
        help = new LinkedList<>();
    }

    public void push(int x) {
        data.offer(x);
    }

    public int pop() {
        //1.依次弹出data中前n-1个元素并存入help中
        while (data.size() > 1) help.offer(data.poll());
        //2.弹出data中的最后一个元素
        int poll = data.poll();

        swap();
        return poll;
    }


    public int top() {
        //1.依次弹出data中前n-1个元素并存入help中
        while (data.size() > 1) help.offer(data.poll());
        //2.弹出data中的最后一个元素
        int poll = data.poll();

        help.offer(poll);


        swap();
        return poll;
    }

    public boolean empty() {
        return data.isEmpty() && help.isEmpty();
    }

    private void swap() {
        Queue<Integer> temp = help;
        help = data;
        data = temp;
    }
}
