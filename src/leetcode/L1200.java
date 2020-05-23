package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ret=new ArrayList<>();
        Arrays.sort(arr);
        int min=Integer.MAX_VALUE;
        for (int i=1;i<arr.length;++i){
            int m=arr[i]-arr[i-1];
            if (m<min){
                min=m;
                ret=new ArrayList<>();
                List<Integer> list=new ArrayList<>(2);
                list.add(arr[i-1]);
                list.add(arr[i]);
                ret.add(list);
            }else if (m==min){
                List<Integer> list=new ArrayList<>(2);
                list.add(arr[i-1]);
                list.add(arr[i]);
                ret.add(list);
            }
        }
        return ret;
    }
}
