package GFG;

import java.util.*;

public class VerticalSumInBT {

    static java.util.TreeMap<Integer,Integer> m= new java.util.TreeMap<>();

    static void verticalSum(Node root, java.util.TreeMap<Integer,Integer> m,int count ){
        if(root==null){
            return;
        }
        verticalSum(root.left,m,count-1);
        m.put(count,m.getOrDefault(count,0)+root.data);
        verticalSum(root.right,m,count+1);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(15);
        root.right = new Node(25);
        root.left.left = new Node(35);
        root.left.right = new Node(20);
        root.left.left.left = new Node(40);
        root.left.right.right = new Node(75);
        root.left.right.right.right = new Node(80);

        verticalSum(root,m,0);

        System.out.print(m.entrySet()+" ");  //print map
        System.out.println();
        for(Map.Entry sum:m.entrySet()){  //print map
           System.out.print(sum+" ");
        }
        System.out.println();
        for(Map.Entry sum:m.entrySet()){  //print map
            System.out.print(sum.getValue()+" ");
        }
        System.out.println();
        for(Map.Entry<Integer,Integer> x:m.entrySet()){
            System.out.print(x.getValue()+" ");
        }
        System.out.println();
        for(Map.Entry<Integer,Integer> x:m.entrySet()){
            System.out.print(x.getValue()+" ");
        }
    }
}
