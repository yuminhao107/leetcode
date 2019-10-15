package leetcode;

public class L59 {

	public static void main(String[] args) {
		Solution solution=new Solution();
		int[][] result=solution.generateMatrix(10);
		print2DArray(result,"%-4d ");
	}
	
	public static void print2DArray(int[][] arr,String pattern) {
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[0].length;j++) {
				System.out.print(String.format(pattern, arr[i][j]));
			}
			System.out.println();
		}
	}

}

class Solution {
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
