package leetcode;

import java.util.HashMap;
import java.util.Map;

public class L1234 {
    public int balancedString(String s) {
        int min=Integer.MAX_VALUE;
        Map<Character,Integer> map=new HashMap<>();
        map.put('Q',0);
        map.put('W',0);
        map.put('E',0);
        map.put('R',0);
        for (char c:s.toCharArray()) map.put(c,map.get(c)+1);
        int n=s.length();
        int k=n/4;
        int j=0;
        for (int i=0;i<n;i++){
            while (j<=n){
                if (map.get('Q')>k||map.get('W')>k||map.get('E')>k||map.get('R')>k){
                    if (j==n) break;
                    char c=s.charAt(j);
                    map.put(c,map.get(c)-1);
                    j++;
                }else{
                    min=Math.min(min,j-i);
                    break;
                }

            }
            char c=s.charAt(i);
            map.put(c,map.get(c)+1);
        }
        return min;
    }
}
