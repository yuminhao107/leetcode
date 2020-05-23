package leetcode;

public class L1359 {
    public int countOrders(int n) {
        long mod=1000000007;
        long ret=1;
        for (int i=2;i<=n;++i){
            ret=(i*(2*i-1)*ret)%mod;
        }
        return (int)ret;
    }
}
