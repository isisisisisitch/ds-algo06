package ca.bytetube._12_greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LowLexicographicalOrderStr {
    public static void main(String[] args) {
        String str = lowLexicographicalOrderStr(new String[]{"b", "ba"});
        System.out.println(str);
    }

    public static String lowLexicographicalOrderStr(String[] strs){
        if (strs == null || strs.length == 0) return null;
        if (strs.length == 1) return strs[0];

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        String res = "";

        for (int i = 0; i <strs.length ; i++) {
            res += strs[i];
        }
        return res;
    }

}
