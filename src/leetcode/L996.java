package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L996 {
    public static void main(String[] args){
        L996 solution = new L996();
        int[] array = {1,17,8};
        System.out.println(solution.numSquarefulPerms(array));
        solution.printG();
    }

    int ret = 0;
    int size;
    List<Node> nodes;
    public int numSquarefulPerms(int[] A) {
        size = A.length;
        Arrays.sort(A);
        nodes = new ArrayList<>();
        int val = A[0];
        int count = 1;
        for (int i = 1;i < size; ++i){
            if (A[i] == val){
                ++count;
            }else{
                nodes.add(new Node(val,count));
                val = A[i];
                count = 1;
            }
        }
        nodes.add(new Node(val,count));

        for (Node ni:nodes){
            for (Node nj:nodes){
                if (ni!=nj && isSquareful(ni.val + nj.val)){
                    ni.neighbours.add(nj);
                }
            }
            if (isSquareful(ni.val * 2)) ni.neighbours.add(ni);
        }

        for (Node ni:nodes){
            for (Node nj:nodes) nj.visit=nj.count;
            visit(ni,1);
        }
        return ret;
    }

    void visit(Node node, int step){
        if (step == size){
            ret++;
            return;
        }
        node.visit--;
        for (Node n:node.neighbours){
            if (n.visit > 0) visit(n, step + 1);
        }
        node.visit++;
    }

    boolean isSquareful(int num){
        double sr = Math.sqrt(num);
        return (sr-Math.floor(sr) == 0);
    };

    class Node{
        int val;
        int count;
        int visit;
        List<Node> neighbours;

        public Node(int val,int count){
            this.val=val;
            this.count=count;
            this.neighbours = new ArrayList<>();
        }
    }

    void printG(){
        for (Node node:nodes){
            System.out.print(String.format("\n val:%s count:%s Neibour:",node.val,node.count));
            for (Node n:node.neighbours){
                System.out.print(n.val+ " ");
            }
        }
    }
}
