package ca.bytetube._17_sort.cmp;

import ca.bytetube._17_sort.Sort;
import ca.bytetube._17_sort.utils.Integers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShellSort<T extends Comparable<T>> extends Sort<T> {

    public static void main(String[] args) {
        Integer[] randomArr = Integers.random(10, 1, 100);
        Integers.println(randomArr);
        new ShellSort().sort(randomArr);
        Integers.println(randomArr);
    }

    @Override
    protected void sort() {
        List<Integer> stepSequence = shellStepSequence();
        for (Integer step : stepSequence) {
            sort(step);
        }
    }

    /**
     * 分成step列进行排序
     */
    private void sort(int step) {

        for (int col = 0; col < step; col++) {//对col列进行排序

            //col, col + step, col + 2step,col+ 3step
            for (int begin = col + step; begin < array.length; begin += step) {
                int cur = begin;
                while (cur > col && cmp(cur, cur - step) < 0) {
                    swap(cur, cur - step);
                    cur -= step;
                }
            }

        }


    }


    private List<Integer> shellStepSequence() {

        List<Integer> stepSequence = new ArrayList<>();
        int step = array.length;//16

        while ((step >>= 1) > 0){
            stepSequence.add(step);//boxing,unboxing
        }


        return stepSequence;
    }

    private List<Integer> sedgewickStepSequence() {
        List<Integer> stepSequence = new LinkedList<>();
        int k = 0, step = 0;
        while (true) {
            if (k % 2 == 0) {
                int pow = (int) Math.pow(2, k >> 1);
                step = 1 + 9 * (pow * pow - pow);
            } else {
                int pow1 = (int) Math.pow(2, (k - 1) >> 1);
                int pow2 = (int) Math.pow(2, (k + 1) >> 1);
                step = 1 + 8 * pow1 * pow2 - 6 * pow2;
            }
            if (step >= array.length) break;
            stepSequence.add(0, step);
            k++;
        }
        return stepSequence;
    }


}
