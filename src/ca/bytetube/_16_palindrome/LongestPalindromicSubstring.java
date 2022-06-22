package ca.bytetube._16_palindrome;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * @author dal
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        lps.preprocess(new char[]{'a', 'b', 'b', 'a', 'b', 'a'});

        String longestPalindrome = lps.longestPalindrome("abbaba");
        System.out.println(longestPalindrome);
    }

    private char[] preprocess(char[] oldChars) {

        char[] cs = new char[(oldChars.length << 1) + 3];
        cs[0] = '^';
        cs[1] = '#';
        cs[cs.length - 1] = '$';
        for (int i = 0; i < oldChars.length; i++) {
            int index = (i + 1) << 1;
            cs[index] = oldChars[i];
            cs[index + 1] = '#';
        }


        return cs;


    }

    public String longestPalindrome(String s) {
        if (s == null) return null;
        if (s.length() <= 1) return s;
        char[] oldChars = s.toCharArray();
        char[] cs = preprocess(oldChars);

        int[] m = new int[cs.length];
        int r = 0;
        int c = 0;
        int index = 0;
        int maxLen = 0;
        for (int i = 2; i < m.length - 2; i++) {
            if (i < r) {
                int li = c * 2 - i;
                if (i + m[li] <= r) {
                    m[i] = m[li];
                } else {
                    m[i] = r - i;
                }
            }


            //以i作为对称中心，向左右两边扩
            while (cs[i + m[i] + 1] == cs[i - m[i] - 1]) m[i]++;

            //更新c，r
            if (i + m[i] > r) {
                c = i;
                r = i + m[i];
                
            }

            //更新最大回文串的长度和开始索引
            if (m[i] > maxLen) {
                maxLen = m[i];
                index = i;
            }
        }

        int beginIndex = (index - maxLen) >> 1;


        return new String(oldChars,beginIndex,maxLen);
    }
}
