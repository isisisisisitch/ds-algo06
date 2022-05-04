package ca.bytetube._10_recursion;

public class Hanoi {

    public static void main(String[] args) {
        hanoi(5,"A","C","B");
    }

    public static void hanoi(int n,String from, String to,String help){

        if (n == 1) {
            System.out.println("move " + 1 + " from " + from + " to " + to);
        }else {
            hanoi(n-1,from,help,to);
            System.out.println("move " + n + " from " + from + " to " + to);
            hanoi(n-1,help,to,from);
        }

    }
}
