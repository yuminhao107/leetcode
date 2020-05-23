package leetcode;

public class L799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] cur=new double[query_row+1];
        cur[0]=poured;
        for (int i=0;i<query_row;++i){
            double[] next=new double[query_row+1];
            for (int j=0;j<=i;++j){
                double add= cur[j]>1? (cur[j]-1)/2:0;
                next[j]+=add;
                next[j+1]+=add;
            }
            cur=next;
        }
        return cur[query_glass]>1? 1:cur[query_glass];
    }
}
