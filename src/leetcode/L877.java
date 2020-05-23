package leetcode;

public class L877 {
    /*
    * M[i,j] is the max advantage the player can achieve if it's his turn
    * when left piles are indexed for i to j is.
    * M[i,j] = abs(piles[i] - piles[j]) if j - i = 2
    * M[i,j] = max(piles[i] - M[i+1, j], piles[j] - M[i, j-1]) if j - i > 2
    * */
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[][] m=new int[len][len];
        for (int i = 0; i < len - 1; ++i){
            m[i][i+1] = Math.abs(piles[i]-piles[i+1]);
        }
        for (int k = 2; k < len; ++k)
            for (int i = 0; i + k < len; ++i){
                int j = i + k;
                m[i][j] = Math.max(piles[i] - m[i+1][j], piles[j] - m[i][j-1]);
            }
        return m[0][len - 1] > 0;
    }
}
