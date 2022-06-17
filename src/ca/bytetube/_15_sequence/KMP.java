package ca.bytetube._15_sequence;

public class KMP {

    public static void main(String[] args) {
//        int[] next = next("ABCDABCE");
//        printArray(next);

        String text = "hello world";
        String pattern = "rld";

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

        int[] next = next(pattern);

        while (pi < pLen && ti < tLen) {
            //1.match successfully
            //pi++,ti++
            if (pi < 0 || tChars[ti] == pChars[pi]) {
                pi++;
                ti++;
            } else {//match unsuccessfully

                //pi位置失配
                //ti不动，等待下一次匹配
                //通过next表决定pi向右跳动的距离
                pi = next[pi];

            }
        }
        //pi == pLen

        return pi == pLen ? ti - pi : -1;

    }

    /**
     * next[i] = n
     * ① if Pattern[i] == Pattern[n]
     * then next[i + 1] = n + 1
     * ② if Pattern[i] != Pattern[n], next[n] = k
     * if Pattern[i] == Pattern[k]
     * then next[i + 1] = k + 1
     * if Pattern[i] != Pattern[k]
     * Substitute k for n and repeat ②
     */
    private static int[] next(String pattern) {
        int[] next = new int[pattern.length()];

        next[0] = -1;
        int n = -1;

        int i = 0;
        char[] chars = pattern.toCharArray();
        while (i < chars.length - 1) {
            //① if Pattern[i] == Pattern[n]
            //then next[i + 1] = n + 1
            if (n < 0 || chars[i] == chars[n]) {
                next[++i] = ++n;
            } else {//if Pattern[i] != Pattern[n],
                //next[n] = k

                n = next[n];

            }

        }


        return next;

    }


    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }


}
