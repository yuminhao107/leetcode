package leetcode;

import java.util.Arrays;

public class L1140 {
    /*
    * S[i,j] is the max advantage the player can achieve if it's his turn
    * when the left most pile is indexed by i and M = j
    * Say sum(piles, i, j) = piles[i] + piles[i+1] + ... + piles[j-1]
    * Say size = piles.length
    * S[i,j] = sum(piles, i, size) if size - i <= j
    * S[i,j] = max(sum(piles, i, i + k) - S[i + k, max(k, M)]) size - i > j
    * */
    int[][] S;
    int[][] sum;
    int size;
    public int stoneGameII(int[] piles) {
        size = piles.length;
        S=new int[size][size];
        sum=new int[size][size + 1];
        for (int i = 0;i < size;++i){
            Arrays.fill(S[i],Integer.MIN_VALUE);
        }
        for (int i = 0; i < size; ++i){
            sum[i][i+1] = piles[i];
            for (int j = i + 1; j < size; ++j){
                sum[i][j+1] = sum[i][j] + piles[j];
            }
        }
        int sum = 0;
        for (int i = 0;i < size;++i) sum += piles[i];
        return (sum + get(0,1))/2;
    }

    int get(int id, int m){
        if (id >= size) return 0;
        if (S[id][m] != Integer.MIN_VALUE) return S[id][m];
        if (size - id <= m){
            S[id][m] = sum[id][size];
        }else{
            int min = Math.min(size - id, 2*m);
            for (int k = 1; k<=min; ++k){
                S[id][m] = Math.max(S[id][m], sum[id][id+k] - get(id+k, Math.max(k,m)));
            }
        }
        return S[id][m];
    }

}
