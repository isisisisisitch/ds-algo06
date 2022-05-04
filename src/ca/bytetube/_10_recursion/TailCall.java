package ca.bytetube._10_recursion;

public class TailCall {
    public static void main(String[] args) {
        test1();
    }


    public static void test1(){
        int a = 10;
        int b = a + 20;
        test2(b);
        int c = a + b;
        System.out.println(c);
    }

    public static void test2(int b) {
        int x1 = 200;
        int x2 = 300;

    }

    //1*2*3*4*5*...*(n-2)*(n-1)*n
    //n = 7
    //1*2***7
    public static int factorial(int n){//f(n) f(n-1)
        if (n <= 1) return n;

        return n * factorial(n-1);

    }

}
