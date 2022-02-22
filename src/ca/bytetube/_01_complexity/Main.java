package ca.bytetube._01_complexity;

public class Main {

    public static void main(String[] args) {
//        Times.test("fib1", new Times.Task() {
//            @Override
//            public void execute() {
//                System.out.println(fib1(50));
//            }
//        });

        Times.test("fib2", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fib2(50));
            }
        });

    }


    public static int fib1(int n) {

        if (n <= 1) return n;

        return fib1(n-1) + fib1(n-2);
    }


    public static int fib2(int n) {
        if (n <= 1) return n;

        int first = 0;
        int second = 1;


        for (int i = 0; i < n-1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }

       return second;
    }


    public static void test1(int n){
        //1
        if (n > 10) {
            System.out.println("n > 10");
        }
        else  if (n > 5) {
            System.out.println("n > 5");
        }

        else  {
            System.out.println("n < 5");
        }

        //1+ 4 + 4 + 4
        for (int i = 0; i < 4; i++) {
            System.out.println("test1");
        }

        //14 O(1)
    }

    public static void  test2(int n){
        //1 + n + n + n = 3n + 1 O(n)
        for (int i = 0; i < n; i++) {

            System.out.println("test2");
        }
    }

    public static void test3(int n){
        //1 + n(3n + 1) + 2n = 3n^2 + 3n + 1    O(n^2)
        for (int i = 0; i < n; i++) {
            //3n + 1
            for (int j = 0; j < n; j++) {
                System.out.println("test3");
            }
        }
    }
    public static void test5(int n){
    //外层是1 + 2log2(n), 内层是1 + 3n， 总共是1 + 2log2(n) + log2(n)*(3n + 1) => n*log(n)
        for (int i = 0; i < n; i = i * 2) {


            for (int j = 0; j < n; j++) {
                System.out.println("test5");
            }


        }

    }

    public static void test4(int n){
        /**
         * n = 8 = 2^3
         *
         * n = 4 = 2^2  1
         *
         * n = 2 = 2^1  1
         *
         * n = 1 = 2^0  1
         *
         * n = 0
         * log2(8) = 3
         *
         * log2(n)
         * log5(n)
         */

        while ((n = n /5) > 0){
            System.out.println("test4");
        }
    }


}
