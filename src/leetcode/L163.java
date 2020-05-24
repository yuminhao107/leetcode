package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int len = nums.length;
        long llower = lower;
        long lupper = upper;
        List<String> ret = new ArrayList<>();
        if (len==0){
            add(ret,llower-1,lupper+1);
            return ret;
        }
        add(ret,llower-1,nums[0]);
        if (len > 1)
            for (int i=0;i<len-1;++i) add(ret,nums[i],nums[i+1]);
        add(ret,nums[len-1],lupper+1);
        return ret;
    }

    void add(List<String> list, long left, long right){
        if (left + 1 >= right) return;
        if (left + 2 == right)  list.add(String.valueOf(left + 1));
        else  list.add((left + 1) + "->" + (right - 1));
    }

}
