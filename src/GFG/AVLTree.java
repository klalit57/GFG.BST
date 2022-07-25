package GFG;

import java.util.LinkedList;
import java.util.Queue;

class Node1{
    int data;
    Node1 left;
    Node1 right;
    int height;
    Node1(int data){
        this.data=data;
        this.height=0;
        this.left=null;
        this.right=null;
    }
}

public class AVLTree {

    public static Node1 insertInAVL(Node1 root,int x){
        if(root==null){
            Node1 temp= new Node1(x);
            temp.height=1;
            return temp;
        }
        if(x<root.data){
            root.left=insertInAVL(root.left,x);
        }else if(x>root.data){
            root.right=insertInAVL(root.right,x);
        }
        root.height=nodeHeight(root);
        int bf=balancedFactor(root);

        if(bf==2 && balancedFactor(root.left)==1) {
            return leftLeftRotation(root);
        }
        else if(bf==2 && balancedFactor(root.left)==-1){
                return leftRightRotation(root);
        }
        else if(bf==-2 && balancedFactor(root.right)==-1) {
            return rightRightRotation(root);
        }
            else if(bf==-2 && balancedFactor(root.right)==1){
                    return rightLeftRotation(root);
                }
        return root;
    }

    public static Node1 deleteInAVL(Node1 root,int x){
        if(root==null){
            return null;
        }

            if(x<root.data){
                root.left=deleteInAVL(root.left,x);
            }else if(x>root.data){
                root.right=deleteInAVL(root.right,x);
            }
            else if(root.data==x){

            }
            return root;
    }

    static int nodeHeight(Node1 root){

        int leftHeight= (root!=null && root.left!=null)?root.left.height:0;
        int rightHeight= (root!=null && root.right!=null)?root.right.height:0;

        return Math.max(leftHeight,rightHeight)+1;
    }

    static int balancedFactor(Node1 root){

        int leftHeight= (root!=null && root.left!=null)?root.left.height:0;
        int rightHeight= (root!=null && root.right!=null)?root.right.height:0;

        return leftHeight-rightHeight;
    }

    static Node1 leftLeftRotation(Node1 root){
            Node1 rootLeft=root.left;
            Node1 rootLeftRight=rootLeft.right;;
            rootLeft.right=root;
            root.left=rootLeftRight;

            root.height= nodeHeight(root);
            rootLeft.height= nodeHeight(rootLeft);

            root=rootLeft;
        return root;
    }
    static Node1 rightRightRotation(Node1 root){
        Node1 rootRight=root.right;
        Node1 rootRightLeft=rootRight.left;

        rootRight.left=root;
        root.right=rootRightLeft;

        root.height= nodeHeight(root);
        rootRight.height= nodeHeight(rootRight);

        root=rootRight;
        return root;
    }

    static Node1 rightLeftRotation(Node1 root){
       Node1 rootRight= root.right;
       Node1 rootRightLeft=rootRight.left;

       Node1 cr=rootRightLeft.right;
        Node1 cl=rootRightLeft.left;

        root.right=cl;
        rootRight.left=cr;

        rootRightLeft.left=root;
        rootRightLeft.right=rootRight;



        root.height=nodeHeight(root);
        rootRight.height=nodeHeight(rootRight);
        rootRightLeft.height=nodeHeight(rootRightLeft);

        root=rootRightLeft;

        return root;
    }
    static Node1 leftRightRotation(Node1 root){
        Node1 rootLeft= root.left;
        Node1 rootLeftRight=rootLeft.right;

        Node1 cr=rootLeftRight.right;
        Node1 cl=rootLeftRight.left;

        root.left=cr;
        rootLeft.right=cl;

        rootLeftRight.left=rootLeft;
        rootLeftRight.right=root;

        root.height=nodeHeight(root);
        rootLeft.height=nodeHeight(rootLeft);
        rootLeftRight.height=nodeHeight(rootLeftRight);

        root=rootLeftRight;

        return root;
    }



    static void levelOrder(Node1 root){   //code from Apni kaksha
        if(root==null){
            return;
        }
        Queue<Node1> q= new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            Node1 temp=q.poll();
            if(temp==null){
                System.out.println();
                if(q.isEmpty()){
                    return;
                }
                else{
                    q.offer(null);
                }
            }
            else{
                System.out.print(temp.data+" ");
                if(temp.left!=null) {
                    q.offer(temp.left);
                }
                if(temp.right!=null) {
                    q.offer(temp.right);
                }
            }
        }
    }


    public static void main(String[] args) {
        Node1 root=insertInAVL(null,20);
        levelOrder(root);
        System.out.println();

        root=insertInAVL(root,15);
        levelOrder(root);
        System.out.println();

        root=insertInAVL(root,5);
        levelOrder(root);
        System.out.println();

        root=insertInAVL(root,40);
        levelOrder(root);
        System.out.println();

        root=insertInAVL(root,50);
        levelOrder(root);
        System.out.println();

        root=insertInAVL(root,80);
        levelOrder(root);
        System.out.println();

    }
}
