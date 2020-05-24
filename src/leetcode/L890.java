package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ret = new ArrayList<>();
        Permutation p = new Permutation();
        for (String word:words){
            boolean match = true;
            p.init();
            for (int i = 0; i < pattern.length(); ++i){
                if (!p.add(word.charAt(i),pattern.charAt(i))){
                    match = false;
                    break;
                }
            }
            if (match) ret.add(word);
        }
        return ret;
    };

    class Permutation{
        int[] map = new int[26];;
        int[] rev_map = new int[26];;

        void init(){
            Arrays.fill(map, -1);
            Arrays.fill(rev_map, -1);
        }

        boolean add(char a, char b){
            int aa = a - 'a';
            int bb = b - 'a';
            if (map[aa] == -1 && rev_map[bb] == -1){
                map[aa] = bb;
                rev_map[bb] = aa;
                return true;
            }
            return map[aa] == bb && rev_map[bb] == aa;
        }
    }
}
