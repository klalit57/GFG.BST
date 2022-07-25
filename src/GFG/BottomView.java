package GFG;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BottomView {
    static void  bottomView(Node root){
        if(root==null){
            return;
        }
        java.util.TreeMap<Integer,Integer> m= new java.util.TreeMap<>();
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(root,0));

        while (!q.isEmpty()){
            Pair temp=q.poll();
            Node node=temp.root;
            int count=temp.count;

                m.put(count, node.data);

            if(node.left!=null){
                q.add(new Pair(node.left,count-1));
            }
            if(node.right!=null){
                q.add(new Pair(node.right,count+1));
            }
        }

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
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node( 50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        //root.right.right.left = new Node(8);
        //root.right.right.left.left = new Node(9);

        bottomView(root);

    }
}
