package ca.bytetube._12_greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LessMoney {
    public static void main(String[] args) throws Exception {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        priorityQueue.add(10);
//        priorityQueue.add(12);
//        priorityQueue.add(19);
//        priorityQueue.add(13);
//        System.out.println(priorityQueue);
        int lessMoney = lessMoney(new int[]{10, 20, 30});
        System.out.println(lessMoney);
    }


    public static int lessMoney(int[] arr) throws Exception {
        if (arr == null || arr.length == 0) throw new Exception("data error");
        //1.将所有元素放入小根堆中
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {  return o1 - o2; }
        });
        for (int element : arr) {
            priorityQueue.add(element);
        }

        //2.从小根堆中每次弹出2个元素，相加的和再放回堆中，供下次求和使用，相加的和进行累加即最后的最小代价
        int res = 0;

        while (priorityQueue.size() > 1){
            int cur = priorityQueue.poll() + priorityQueue.poll();
            res += cur;
            priorityQueue.add(cur);
        }

        return res;


    }
}
