package leetcode;

import java.util.HashMap;
import java.util.Map;

public class L904 {
    public int totalFruit(int[] tree) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int i = 0;
        int j = 0;
        while(i<tree.length){
            inc(map,tree[i]);
            while(map.size()>2){
                dec(map,tree[j]);
                ++j;
            }
            max = Math.max(max, i - j + 1);
            ++i;
        }
        return max;
    }

    void inc(Map<Integer,Integer> map, int key){
        if (map.containsKey(key)){
            map.put(key,map.get(key)+1);
        }else{
            map.put(key,1);
        }
    }

    void dec(Map<Integer,Integer> map, int key){
        int val = map.get(key);
        if (val==1){
            map.remove(key);
        }else{
            map.put(key,val - 1);
        }
    }
}
