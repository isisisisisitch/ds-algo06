package ca.bytetube._10_recursion;

public class NumOfCows {

    public static int numOfCows(int n) {

        if (n < 1) return 0;
        if (n <= 4) return n;

        return numOfCows(n - 1) + numOfCows(n - 3);

    }



    public static void main(String[] args) {
        int num = numOfCows(6);
        System.out.println(num);
    }

}
