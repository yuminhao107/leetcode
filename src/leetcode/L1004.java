package leetcode;

import java.util.Stack;

public class L1004 {
    public boolean isValid(String S) {
        char[] stack=new char[S.length()];
        int top=-1;
        for (int i=0;i<S.length();++i){
            char c=S.charAt(i);
            if (c=='a' || c=='b') stack[++top]=c;
            else{
                if (top==-1) return false;
                if (stack[top--]!='b') return false;
                if (top==-1) return false;
                if (stack[top--]!='a') return false;
            }
        }
        return top==-1;
    }
}
