package leetcode;

public class L1071 {

	public static void main(String[] args) {
		L1071 solution=new L1071();
		String result=solution.gcdOfStrings("ABAB","ABC");
		System.out.println(result);
	}
	
	public String gcdOfStrings(String str1, String str2) {
        if (str1.length()>str2.length()) {
        	String tem=str1;
        	str1=str2;
        	str2=tem;
        }
        if (str1.length()==0) {
        	return "";
        }
        if (str1.equals(str2)) {
        	return str1;
        }
		String front=str2.substring(0, str1.length());
		if (front.equals(str1)) {
			return gcdOfStrings(str1,str2.substring(str1.length()));
		}else
			return "";
    }

}
