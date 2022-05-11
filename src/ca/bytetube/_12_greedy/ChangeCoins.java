package ca.bytetube._12_greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ChangeCoins {

    public static void main(String[] args) {
        int coins = ChangeCoins(new int[]{25, 10, 5, 1}, 39);
        System.out.println(coins);
    }

    /**
     * money = 39
     * faces = {25,10,5,1}
     * 1.face = 25 ,  money = 14
     * 2.face = 10 ,  money = 4
     * 3.face = 5 ,
     * 4.face = 1 ,
     *
     */

    public static int ChangeCoins(int[] faces,int money){
        int coins = 0;

        Arrays.sort(faces);
        for (int i = faces.length - 1; i >= 0 ; i--) {
            if (money < faces[i]) continue;
            System.out.println(faces[i]);
            money -= faces[i];
            coins++;
            i++;
        }

        return coins;
    }

}
