package leetcode;

public class L484 {
    public int[] findPermutation(String s) {
        int len = s.length();
        int[] ret = new int[len+1];
        int stack = 0;
        int nextInt = 1;
        for (int i = 0; i< len; i++){
            if (s.charAt(i) == 'D'){
                ++stack;
            }else{
                if (stack > 0){
                    for (int j = i; j >= i - stack; --j){
                        ret[j] = nextInt++;
                    }
                    stack = 0;
                } else
                    ret[i] = nextInt++;
            }
        }
        if (stack > 0){
            for (int j = len; j >= len - stack; --j){
                ret[j] = nextInt++;
            }
        } else
            ret[len] = nextInt++;
        return ret;
    }
}
