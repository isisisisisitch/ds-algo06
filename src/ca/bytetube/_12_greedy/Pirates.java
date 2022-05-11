package ca.bytetube._12_greedy;

import java.util.Arrays;

public class Pirates {
    public static void main(String[] args) {
        int count = loadAntiques(30, new int[]{3, 5, 4, 10, 7, 14, 2, 11});
        System.out.println("==============");
        System.out.println(count);

    }


    public static int loadAntiques(int capacity,int[] weights){//3, 5, 4, 10, 7, 14, 2, 11
        if (weights == null || weights.length == 0 || capacity <= 0) return 0;

        Arrays.sort(weights);
        int weight = 0;
        int count = 0;
        for (int i = 0; i < weights.length && weight < capacity; i++) {
            int newWeight = weights[i] + weight;
            if (newWeight <= capacity) {
                weight = newWeight;
                count++;
                System.out.println(weights[i]);
            }

        }

        return count;


    }

}
