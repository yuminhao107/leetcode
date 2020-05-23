package leetcode;

public class L59 {

	public static void main(String[] args) {
		L59 solution=new L59();
		int[][] result=solution.generateMatrix(10);
		MyUtils.print2DArray(result,"%-4d ");
	}
	
	public int[][] generateMatrix(int n) {
    	int[][] nums=new int[n][n];
        int step=0;
        int nextInt=0;
        while (n>0) {
        	for (int i=0;i<n;i++) {
        		++nextInt;
        		nums[step][step+i]=nextInt;
        	}
        	for (int i=1;i<n;i++) {
        		++nextInt;
        		nums[step+i][step+n-1]=nextInt;
        	}
        	for (int i=1;i<n;i++) {
        		++nextInt;
        		nums[step+n-1][step+n-1-i]=nextInt;
        	}
        	for (int i=1;i<n-1;i++) {
        		++nextInt;
        		nums[step+n-1-i][step]=nextInt;
        	}
        	step++;
        	n-=2;
        }
    	return nums;
    }

}


