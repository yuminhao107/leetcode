package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class L481 {

	public static void main(String[] args) {
		L481 solution=new L481();
		int result=solution.magicalString(13);
		System.out.println(result);
	}
	
	public int magicalString(int n) {
		if (n==0) return 0;
        int result=1;
		int count=3;
		boolean next=false;
		Queue<Boolean> queue=new LinkedList<Boolean>();
		queue.add(true);
		while (count<n) {
			boolean now=queue.remove();
			if (now) {
				queue.add(next);
				queue.add(next);
				count+=2;
				if (!next)
					result+=2;
			}else {
				queue.add(next);
				count+=1;
				if (!next)
					result+=1;
			}
			next=!next;
		}
		if (count>n && next) {
			result--;
		}
		return result;
    }

}
