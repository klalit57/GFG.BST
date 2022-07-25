package GFG;

import java.util.*;

public class PairWithGivenSum {
    static boolean pairSum(Node root, int sum){ // GFG Method-1
        if(root==null){
            return false;
        }
        ArrayList<Integer> l= new ArrayList<>();
        inOrder(root, l);

        return twoPointer(l,sum);
    }

    static boolean twoPointer(ArrayList<Integer>l, int sum){
        int low=0;
        int high=l.size()-1;
        while(low<high){
            int temp=l.get(low)+l.get(high);
            if(temp==sum){
                return true;
            }
            if(temp<sum){
                low=low+1;
            }
            else{
                high=high-1;
            }
        }
        return false;
    }

    static void inOrder(Node root, ArrayList<Integer> l){
        if(root==null){
            return;
        }

        inOrder(root.left,l);
        l.add(root.data);
        inOrder(root.right,l);
    }

    static boolean pairSum2(Node root, int sum, HashSet<Integer> h){  //GFG Method-2
       if(root==null){
           return false;
       }
       if(pairSum2(root.left,sum,h)){
           return true;
       }
       if(h.contains(sum-root.data)){
           return true;
       }
       h.add(root.data);

       return pairSum2(root.right,sum,h);
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(20);
        root.left.left = new Node(4);
        root.left.right = new Node(9);
        root.right.left = new Node(11);
        root.right.right = new Node(30);
        root.right.right.left = new Node(25);

        System.out.println(pairSum(root,0));
    }
}
