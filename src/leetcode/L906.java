package leetcode;

public class L906 {
    public static void main(String[] args){
        L906 solution = new L906();
        solution.superpalindromesInRange("4","10000");
    }



    int ret = 0;
    long left, right;
    public int superpalindromesInRange(String L, String R) {
        left = Long.valueOf(L);
        right = Long.valueOf(R);
        long lsr= Math.round(Math.sqrt(left));
        long rsr= Math.round(Math.sqrt(right));
        long lodd=0,rodd=0,leven=0,reven=0;
        int ln = numDigits(lsr);
        if (ln % 2 == 1){
//            is odd
            lodd = rightShift(lsr, ln / 2);
            leven = pow(10, ln / 2);
        }else{
            lodd = pow(10, ln / 2);
            leven = rightShift(lsr, ln / 2);
        }
        int rn = numDigits(rsr);
        if (rn % 2 == 1){
//            is odd
            rodd = rightShift(rsr, rn / 2);
            reven = pow(10, rn / 2) - 1;
        }else{
            rodd = pow(10, rn / 2) - 1;
            reven = rightShift(rsr, rn / 2);
        }
//        System.out.println(String.format("even: %s %s odd: %s %s",leven,reven,lodd,rodd));
        findEven(leven,reven);
        findOdd(lodd,rodd);
        return ret;
    }

    void findEven(long left, long right){
        for (long i = left; i<= right; i++){
            long num = i;
            long rev = 0;
            long mul = 1;
            while (num > 0){
                rev = rev * 10 + num % 10;
                num /= 10;
                mul *= 10;
            }
            long p = i * mul + rev;
            long pp = p*p;
            if (isPalidome(pp)) check(pp);
        }
    }

    void findOdd(long left, long right){
        for (long i = left; i<= right; i++){
            long num = i / 10;
            long rev = 0;
            long mul = 1;
            while (num > 0){
                rev = rev * 10 + num % 10;
                num /= 10;
                mul *= 10;
            }
            long p = i * mul + rev;
            long pp = p*p;
            if (isPalidome(pp)) check(pp);
        }
    }

    void check(long num){
        if (num >= left && num <= right) ++ret;
    }

    int numDigits(long num){
        if (num == 0) return 1;
        int ret = 0;
        while (num > 0){
            num /= 10;
            ret++;
        }
        return ret;
    }

    long rightShift(long num, int offset){
        while (offset > 0){
            num /= 10;
            --offset;
        }
        return num;
    }

    boolean isPalidome(long num){
        if (num < 0 || (num % 10 == 0 && num !=0)) return false;
        long rev = 0;
        while (num > rev){
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return num == rev || rev / 10 == num;
    }

    int pow(int a, int n){
        int ret = 1;
        for (int i=0;i<n;i++){
            ret *= a;
        }
        return ret;
    }
}
