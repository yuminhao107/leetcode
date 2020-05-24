package leetcode;

import java.util.HashMap;

public class L1224 {
    public static void main(String[] args){
        L1224 solution = new L1224();
        int[] nums = {1,2};
        solution.maxEqualFreq(nums);
    }
    public int maxEqualFreq(int[] nums) {
        int max = 1;
        HashMap<Integer, Integer> occurrences = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i){
            int occur = update(occurrences,nums[i],1);
            if (occur > 0) update(map,occur,-1);
            update(map, occur + 1, 1);
            if (isValid(map)) max = i + 1;
            printMap(map);
            System.out.println(isValid(map));
        }
        return max;
    }

    int update(HashMap<Integer, Integer> map, int key, int diff){
        if (map.containsKey(key)){
            int value = map.get(key);
            if (value + diff == 0) map.remove(key);
            else map.put(key, value + diff);
            return value;
        } else {
            map.put(key, diff);
            return 0;
        }
    }

    boolean isValid(HashMap<Integer, Integer> map){
        int keyNum = map.keySet().size();
        if (keyNum > 2 || keyNum == 0) return false;
        if (keyNum == 1) {
            return map.values().iterator().next() == 1 || map.keySet().iterator().next() == 1;
        }
        Integer[] keys = new Integer[2];
        map.keySet().toArray(keys);
        return (Math.min(keys[0],keys[1])==1 && map.get(Math.min(keys[0],keys[1])) == 1)
                || (Math.abs(keys[0]-keys[1]) == 1 && map.get(Math.max(keys[0],keys[1])) == 1);
    }

    <K, V> void printMap(HashMap<K, V> map){
        for (K key:map.keySet()){
            System.out.println(String.format("Key %s Value %s", key,map.get(key)));
        }
    }
}
