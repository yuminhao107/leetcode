package leetcode;

import java.util.Arrays;

public class L1432 {
    public static void main(String[] args){
        L1432 solution = new L1432();
        solution.maxDiff(765432);
    }
    public int maxDiff(int num) {
        int[] digits = new int[10];
        int size = 0;
        while (num > 0){
            digits[size++] = num % 10;
            num /= 10;
        }
        // find max
        int[] max= Arrays.copyOf(digits, 10);
        for (int i = size - 1;i >= 0; --i){
            if (max[i] != 9){
                replace(max,max[i],9,i);
                break;
            }
        }
        // find min
        if (digits[size - 1] != 1) {
            replace(digits,digits[size - 1],1,size - 1);
        } else {
            for (int i = size - 2;i >= 0; --i){
                if (digits[i] != 0 && digits[i] != digits[size - 1]) {
                    replace(digits, digits[i], 0, i);
                    break;
                }
            }
        }
        System.out.println(String.format("Max %s Min %s", valueOf(max,size),valueOf(digits,size)));
        return valueOf(max, size) - valueOf(digits, size);
    }

    void replace(int[] digits, int old, int neww, int start){
        for (int i = start; i >=0; --i){
            if (digits[i] == old) digits[i] = neww;
        }
    }

    int valueOf(int[] digits, int size){
        int ret = 0;
        for (int i = size - 1; i >= 0; --i) ret = ret * 10 + digits[i];
        return ret;
    }

}
