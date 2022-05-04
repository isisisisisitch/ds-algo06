package ca.bytetube._10_recursion;

public class PrintAllSubSequence {
    public static void main(String[] args) {
        printAllSubSequence("abc");
    }


    public static void printAllSubSequence(String s){

        printAllSubSequence(s,0, new String());

    }


    private static void printAllSubSequence(String s, int index,String res) {
        if (index == s.length()) {
            System.out.println(res);
            return;
        }

        printAllSubSequence(s,index + 1,res);
        printAllSubSequence(s,index + 1,res+s.charAt(index));

    }

}
