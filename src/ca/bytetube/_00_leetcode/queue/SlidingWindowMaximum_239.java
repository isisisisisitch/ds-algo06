package ca.bytetube._00_leetcode.queue;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum_239 {


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) return new int[0];
        if (k == 1) return nums;

        int[] maxes = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        //每次从队尾添加元素，为了保证从尾到头依次增大，必须清空队尾所有比添加元素小的值
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty()  && nums[i] >= nums[deque.peekLast()] ){
                deque.removeLast();
            }

            //能够来到这，说明队尾的那些<=nums[i]的值已经被清空了
            //这时将i加入队尾
            deque.addLast(i);

            int w = i - k + 1;
            if (w < 0) {
                continue;
            }

            //检查队列队头元素是否已经过期
            if (w > deque.peekFirst()) {//队头元素已经过期
                deque.removeFirst();
            }
            //设置窗口的最大值
            maxes[w]  =  nums[deque.peekFirst()];

        }


        return maxes;
    }
}
