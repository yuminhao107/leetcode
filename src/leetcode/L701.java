package leetcode;

import java.util.Arrays;

public class L701 {
    int[] blacklist;
    int len;
    int N;
    public L701(int N, int[] blacklist) {
        this.N = N;
        this.blacklist = blacklist;
        len = blacklist.length;
        Arrays.sort(this.blacklist);
    }

    public int pick() {
        int rand = (int)Math.floor((N - len) * Math.random());
        if (len == 0) return rand;
        if (rand < blacklist[0]) return rand;
        if (rand + len > blacklist[len - 1]) return rand + len;
        int left = 0;
        int right = len - 1;
        while (right - left > 1){
            int mid = (left + right) / 2;
            if (rand + mid + 1 > blacklist[mid]) left = mid;
            if (rand + mid < blacklist[mid]) right = mid;
        }
        return rand + right;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */