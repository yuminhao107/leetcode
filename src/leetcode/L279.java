package leetcode;

public class L279 {
	public static void main(String[] args) {
		L279 solution=new L279();
		System.out.println(solution.numSquares(12));
		System.out.println(solution.numSquares(13));
	}
	
	public int numSquares(int n) {
        int[] nums= new int[n+1];
        nums[0]=0;
        for (int i=1;i<nums.length;i++) {
        	nums[i]=Integer.MAX_VALUE;
        }
        for (int i=0;i<n;i++) {
        	int j=1;
        	int update=i+j*j;
        	int newNum=nums[i]+1;
        	while(update<=n) {
        		if (newNum<nums[update]) {
        			nums[update]=newNum;
        		}		
        		j++;
        		update=i+j*j;
        	}
        }
		return nums[n];
    }
}
