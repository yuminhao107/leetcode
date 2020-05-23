package leetcode;

public class MyUtils {
    public static void print2DArray(int[][] arr,String pattern) {
        for (int i=0;i<arr.length;i++) {
            for (int j=0;j<arr[0].length;j++) {
                System.out.print(String.format(pattern, arr[i][j]));
            }
            System.out.println();
        }
    }
}
