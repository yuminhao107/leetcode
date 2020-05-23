package leetcode;
import java.util.*;

public class L1048 {
    public static void main(String[] args){
        L1048 solution=new L1048();
        String[] words={"a","b","ba","bca","bda","bdca"};
        System.out.println(solution.longestStrChain(words));
    }
    public int longestStrChain(String[] words) {
        if (words==null || words.length==0) return 0;
        int max=1;
        List<List<String>> lists=new ArrayList<>();
        for (int i=0;i<16;i++) lists.add(new ArrayList<>());
        for (String word:words) lists.get(word.length()-1).add(word);
        Map<String,Integer> map=new HashMap<>();
        for (String word:words) map.put(word,1);
        for (int i=1;i<16;i++){
            for (String w1:lists.get(i)) {
                int m = 1;
                for (String w2 : lists.get(i - 1)) {
                    if (isPre(w2,w1)){
                        int tem=map.get(w2)+1;
                        if (tem>m){
                            m=tem;
                        }
                    }
                }
                map.put(w1,m);
                if (m>max){
                    max=m;
                }
            }
        }
        return max;
    }

    boolean isPre(String pre,String word){
        if (pre.length()!=word.length()-1) return false;
        int i=0;
        int j=0;
        boolean diff=false;
        while(i<pre.length()){
            if (pre.charAt(i)!=word.charAt(j)){
                if (diff){
                    return false;
                }else{
                    diff=true;
                    j++;
                    continue;
                }
            }
            i++;
            j++;
        }
        return true;
    }
}
