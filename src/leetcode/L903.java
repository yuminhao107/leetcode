package leetcode;

import java.util.HashMap;

public class L903 {
	static final int modNum=(int) (1E9+7);
	
	public static void main(String[] args) {
		int num=new L903().numPermsDISequence("IIDIIDDIDDDDIIDDIDIDIDDDDIDDDIIIIDDIDDDDIDIIDDIDID");
		System.out.print(num);
	}
	
	public int numPermsDISequence(String S) {
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        map.put("",1);
        map.put("D",1);
        map.put("I",1);
		return get(map,S);
    }
	
	public int get(HashMap<String,Integer> map,String str) {
		if (map.containsKey(str)) {
			return map.get(str);
		}
		int sum=0;
		if (str.charAt(0)=='D') {
			sum+=get(map,str.substring(1));
			sum%=modNum;
		}
		if (str.charAt(str.length()-1)=='I') {
			sum+=get(map,str.substring(0,str.length()-1));
			sum%=modNum;
		}
		for (int i=0;i<str.length()-1;i++) {
			if (str.charAt(i)=='I' && str.charAt(i+1)=='D') {
				sum+=get(map,str.substring(0,i)+"I"+str.substring(i+2));
				sum%=modNum;
				sum+=get(map,str.substring(0,i)+"D"+str.substring(i+2));
				sum%=modNum;
			}
		}
		
		map.put(str,sum);
		return sum;
	}
	
	
}
