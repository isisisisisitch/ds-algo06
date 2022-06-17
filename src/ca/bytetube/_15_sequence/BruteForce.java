package ca.bytetube._15_sequence;

public class BruteForce {
    public static void main(String[] args) {
        String text = "hello world";
        String pattern = "ll";

        int index = indexOf(text, pattern);

        System.out.println(index);


    }

    public static int indexOf(String text, String pattern) {
        if (text == null || pattern == null) return -1;
        int pLen = pattern.length();
        int tLen = text.length();
        if (tLen == 0 || pLen == 0) return -1;
        if (pLen > tLen) return -1;
        char[] tChars = text.toCharArray();
        char[] pChars = pattern.toCharArray();
        int pi = 0;
        int ti = 0;

        while (pi < pLen && ti < tLen) {
            //1.match successfully
            //pi++,ti++
            if (tChars[ti] == pChars[pi]) {
                pi++;
                ti++;
            } else {
                //match unsuccessfully
                //ti –= pi – 1,pi = 0
                ti -= pi - 1;
                pi = 0;

            }
        }
        //pi == pLen

        return pi == pLen ? ti - pi : -1;

    }
}
