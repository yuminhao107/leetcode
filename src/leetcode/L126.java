package leetcode;

import java.util.*;

public class L126 {
    public static void main(String[] args){
        L126 solution=new L126();
        String beginWord = "hit";
        String endWord = "cog";
        String[] words={"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(words);
        List<List<String>> ret=solution.findLadders(beginWord,endWord,wordList);
        for (List<String> path:ret){
            for (String word:path) System.out.print(word+" ");
            System.out.println();
        }
//        for (Node node:begin.neighbours) System.out.print(node.word+" ");
//        System.out.println();
//        for (Node node:end.neighbours) System.out.print(node.word+" ");
//        System.out.println();
//        for (Node node:end.pres) System.out.print(node.word+" ");
    }

    List<List<String>> lists=new ArrayList<>();
    Map<String,List<Node>> map=new HashMap<>();
    List<String> path=new ArrayList<>();
    Node begin;
    Node end;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        begin=addMap(beginWord);
        end=null;
        for (String word:wordList){
            Node node=addMap(word);
            if (word.equals(endWord)) end=node;
        }
        if (end==null) return lists;
        List<Node> cur=new ArrayList<>();
        List<Node> next=new ArrayList<>();
        cur.add(begin);
        begin.visited=true;
        while(cur.size()>0){
            for (Node node:cur){
                for (int i=0;i<node.word.length();i++) {
                    String pattern=node.word.substring(0,i)+"*"+node.word.substring(i+1);
                    for (Node n : map.get(pattern)) {
                        if (!n.visited) {
                            n.visited = true;
                            n.inNext = true;
                            next.add(n);
                            n.pres.add(node);
                        } else if (n.inNext) n.pres.add(node);
                    }
                }
            }
            cur=next;
            next=new ArrayList<>();
            for (Node node:cur) node.inNext=false;
        }


        buildPaths(end);

        return lists;
    }

    Node addMap(String word){
        Node node=new Node(word);
        for (int i=0;i<word.length();i++){
            String pattern=word.substring(0,i)+"*"+word.substring(i+1);
            if (map.containsKey(pattern)){
                map.get(pattern).add(node);
            }else{
                List<Node> l=new ArrayList<>();
                l.add(node);
                map.put(pattern,l);
            }
        }
        return node;
    }

    void buildPaths(Node node){
        path.add(node.word);
        if (node==begin){
            List<String> tem=new ArrayList<>();
            for (int i=path.size()-1;i>=0;--i){
                tem.add(path.get(i));
            }
            lists.add(tem);
        }
        for (Node n:node.pres){
            buildPaths(n);
        }
        path.remove(path.size()-1);
    }

    class Node{
        boolean visited;
        boolean inNext;
        List<Node> pres=new ArrayList<>();
        String word;
        List<Node> neighbours=new ArrayList<>();

        Node(String word){
            this.word=word;
        }

    }
}
