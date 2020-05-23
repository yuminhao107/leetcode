package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L212 {
    Set<String> set=new HashSet<String>();
    boolean[][] visit;
    int rows,cols;
    int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) {
        System.out.println('a'-97);
        char[][] board={
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};
        L212 solution=new L212();
        for (String str:solution.findWords(board,words))
            System.out.println(str+" ");
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> list=new ArrayList<>();
        Node root=new Node();
        rows=board.length;
        cols=board[0].length;

        for (int j=0;j<words.length;++j){
            char[] chars=words[j].toCharArray();
            Node cur=root;
            for (int i=0;i<chars.length;++i){
                int asc=chars[i]-97;
                if (cur.nexts[asc]==null){
                    cur.nexts[asc]=new Node();
                }
                cur=cur.nexts[asc];
            }
            cur.word=words[j];
        }
        visit=new boolean[rows][cols];

        for (int i=0;i<rows;++i)
            for (int j=0;j<cols;++j) dfs(board,i,j,root);


        for (String word:set){
            list.add(word);
        }
        return list;
    }

    void dfs(char[][] board,int i, int j, Node cur){
        cur=cur.nexts[board[i][j]-97];
        if (cur==null) return;
        if (cur.word!=null) set.add(cur.word);
        visit[i][j]=true;
        for (int k=0;k<dirs.length;++k){
            int nexti=i+dirs[k][0];
            int nextj=j+dirs[k][1];
            if (0<=nexti && nexti<rows && 0<=nextj && nextj<cols && !visit[nexti][nextj])
                dfs(board,nexti,nextj,cur);
        }
        visit[i][j]=false;
    }

    class Node{
        String word=null;
        Node[] nexts=new Node[26];
    }
}
