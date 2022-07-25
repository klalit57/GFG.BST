package GFG;
import java.util.*;


class Node3{
    int data;
    Node3 left;
    Node3 right;
    int lCount;
    Node3(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}

public class FindKthSmallest {
    static int count=0;
    public static void kthSmallest1(Node1 root, int k){   //gfg naive
        if(root==null){
            return;
        }
        kthSmallest1(root.left,k);
        count++;
        if(count==k){
            System.out.println(root.data+" ");
            return;
        }
        kthSmallest1(root.right,k);
    }


    public static void kthSmallest2(Node1 root, int k){

    }
    public static void main(String[] args) {

    }
}
