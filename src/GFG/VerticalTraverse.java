package GFG;
import java.util.*;

public class VerticalTraverse {

    static java.util.TreeMap<Integer,HashSet<Integer>> m= new java.util.TreeMap<>();
    static void verticalTraverse(Node root, java.util.TreeMap<Integer,HashSet<Integer>> m,int count ){
        if(root==null){
            return;
        }
        verticalTraverse(root.left,m,count-1);

        if(m.containsKey(count)){
            m.get(count).add(root.data);
        }else{
            m.put(count,new HashSet<>() );
            m.get(count).add(root.data);
        }
        verticalTraverse(root.right,m,count+1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(8);
        root.right.right.left.left = new Node(9);
        //root.left.right.right.right = new Node(80);

        verticalTraverse(root,m,0);

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
        for(Map.Entry<Integer,HashSet<Integer>> x:m.entrySet()){
            System.out.print(x.getValue()+" ");
        }

    }
}