package leetcode;

import java.util.Stack;

public class L1190 {


    public String reverseParentheses(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack= new Stack<>();
        for (int i = 0;i < s.length(); i++){
            if (chars[i] == '('){
                stack.push(i);
            } else if (chars[i] == ')'){
                flip(chars, stack.pop() + 1, i - 1);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i < s.length(); i++){
            if (chars[i] != '(' && chars[i] != ')') sb.append(chars[i]);
        }
        return sb.toString();
    }

    void flip(char[] chars, int start, int end){
        if (start > end) return;
        int mid = (start + end) / 2;
        int i = start;
        int j = end;
        while (i <= mid){
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
            i++;
            j--;
        }
    }
}
