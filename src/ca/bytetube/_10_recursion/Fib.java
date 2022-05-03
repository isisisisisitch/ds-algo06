package ca.bytetube._10_recursion;

/**
 * https://leetcode.com/problems/fibonacci-number/
 */
public class Fib {


    public int fib1(int n) {
        if (n <= 1) return n;
        //f(n) = f(n-1) + f(n-2)
        return fib1(n - 1) + fib1(n - 2);
    }


    //Memoization
    public int fib2(int n) {
        if (n <= 1) return n;

        int[] arr = new int[n + 1];//heap
        arr[1] = 1;
        arr[2] = 1;

        return fib2(n, arr);
    }

    private int fib2(int n, int[] arr) {
        //f(n) = f(n-1) + f(n-2)
        if (arr[n] == 0) {
            arr[n] = fib2(n - 1, arr) + fib2(n - 2, arr);
        }

        return arr[n];

    }


    //without Recursion
    public int fib3(int n) {
        if (n <= 1) return n;

        int[] arr = new int[n + 1];//heap
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }


    /**

     * 3%2 = 1  0b011 & 0b001 = 001
     * 4%2 = 0  0b100 & 0b001 = 000
     * 5%2 = 1
     * 6%2 = 0
     * ...
     *
     *
     *  0b100
     *& 0b001
     * ---------
     *    000
     */

    public int fib4(int n) {
        if (n <= 1) return n;

        int[] arr = new int[2];//heap
        arr[0] = 1;//fib(1)
        arr[1] = 1;//fib(2)
        for (int i = 3; i <= n; i++) {
            arr[i % 2] = arr[(i-1) % 2] + arr[(i-2) % 2];
        }

        return arr[n % 2];
    }

    public int fib5(int n) {
        if (n <= 1) return n;

        int[] arr = new int[2];//heap
        arr[0] = 1;//fib(1)
        arr[1] = 1;//fib(2)
        for (int i = 3; i <= n; i++) {
            arr[i & 1] = arr[(i-1) & 1] + arr[(i-2) & 1];
        }

        return arr[n & 1];
    }

    public int fib6(int n) {
        if (n <= 1) return n;

        int first = 0;
        int second = 1;
        for (int i = 0; i < n-1 ; i++) {//n表示相加的次数
            int sum = first + second;
            first = second;
            second = sum;

        }

        return second;
    }


}
