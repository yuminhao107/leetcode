package leetcode;

public class L233 {
    /*Given an integer n, count the total number of digit 1
    appearing in all non-negative integers less than or
    equal to n.*/

    public static void main(String[] args){
        blueForceCount(2022);
    }

    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        if (n < 10) return 1;
        int[] digits = new int[10];
        int size = 0;
        while (n>0){
            digits[size++] = n % 10;
            n /= 10;
        }
        int ret=0;
        for (int i = 0;i<size;++i) {
            int upper = subint(digits,i+1,size);
            int mul = pow(10,i);
            if (digits[i]==0){
                ret += upper * mul;
            } else if (digits[i]==1){
                ret += upper * mul + subint(digits,0,i) + 1;
            }else{
                ret += (upper+1) * mul;
            }
        }
        return ret;
    }

    int pow(int a, int n){
        int ret = 1;
        for (int i=0;i<n;i++){
            ret *= a;
        }
        return ret;
    }

    int subint(int[] digits, int start, int end){
        int sum = 0;
        int mul = 1;
        for (int i=start;i<end;i++){
            sum += digits[i] * mul;
            mul *= 10;
        }
        return sum;
    }

    public static void blueForceCount(int n){
        int[] count = new int[10];
        int size = 0;
        for (int i=0;i<n;i++){
            size = 0;
            int num = i;
            while (num>0){
                if (num % 10 == 1) count[size]++;
                num /= 10;
                size++;
            }
        }
        for (int i=0;i<size;i++){
            System.out.print(count[i]+" ");
        }
    }
}
