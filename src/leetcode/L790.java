package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class L790 {

	public static void main(String[] args) {
		L790 solution=new L790();
		int result=solution.numTilings(30);
		System.out.println(result);
	}
	
	public int numTilings(int N) {
		int mod=1000000007;
		int[] a,b;
		if (N>3) {
			a=new int[N+1];
			b=new int[N+1];
		}else {
			a=new int[4];
			b=new int[4];
		}
        a[0]=1;
        a[1]=1;
        a[2]=2;
        a[3]=5;
        b[0]=0;
        b[1]=0;
        b[2]=1;
        b[3]=2;
        for (int i=4;i<=N;i++) {
        	long tem=0;
        	tem=tem+2*b[i-1]+a[i-2]+a[i-1];
        	a[i]=(int) (tem % mod);
        	b[i]=(b[i-1]+a[i-2])%mod;
        }
        return a[N];
    }

}
