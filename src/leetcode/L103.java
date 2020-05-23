package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L103 {

	public static void main(String[] args) {
		L103 solution=new L103();
	}

	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> lists=new ArrayList<List<Integer>>();
		ArrayList<TreeNode> now=new ArrayList<TreeNode>();
		ArrayList<TreeNode> next=new ArrayList<TreeNode>();
		boolean flip=false;
		if (root==null) return lists;
		now.add(root);
		while(now.size()>0) {
			ArrayList<Integer> list=new ArrayList<Integer>();
			for (TreeNode node:now) {
				list.add(node.val);
				if (node.left!=null) next.add(node.left);
				if (node.right!=null) next.add(node.right);
			}
			
			if (flip) {
				ArrayList<Integer> flipList=new ArrayList<Integer>();
				for (int i=0;i<list.size();i++)
					flipList.add(list.get(list.size()-1-i));
				list=flipList;
			}
			lists.add(list);
			flip=!flip;
			now=next;
			next=new ArrayList<TreeNode>(); 
		}
		return lists;
    }

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}




