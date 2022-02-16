package ca.bytetube.leetcode.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * @author dal
 */
public class ValidParentheses_20 {
//    public boolean isValid(String s) {
//       //
//        while (s.contains("()")||s.contains("[]")||s.contains("{}")){
//            s.replace("()","");
//            s.replace("[]","");
//            s.replace("{}","");
//        }
//
//        return s.isEmpty();
//    }

//    public boolean isValid(String s) {
//        Stack<Character> stack = new Stack<>();
//        //( )  [ { } ]
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (ch == '('|| ch == '['|| ch == '{')  stack.push(ch);//left brackets
//                else {//right brackets
//                if (stack.isEmpty())  return false;
//                char left = stack.pop();
//                //char right = ch;
//                if (left == '(' && ch != ')')  return false;
//                if (left == '[' && ch != ']')  return false;
//                if (left == '{' && ch != '}') return false;
//            }
//        }
//      return stack.isEmpty();
//    }

    static HashMap<Character,Character> map = new HashMap<>();
    static {
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        map.put('|','|');
    }


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
                //( )  [ { } ]
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char ch = chars[i];
            if (map.containsKey(ch))  stack.push(ch);//left brackets
                else {//right brackets
                if (stack.isEmpty())  return false;
                char left = stack.pop();
                if (ch != map.get(left)) return false;
            }
        }
      return stack.isEmpty();
    }
}
