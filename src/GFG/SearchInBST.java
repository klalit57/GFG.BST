package GFG;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}

public class SearchInBST {
    static boolean searchInBst(Node root, int k){
        if(root==null){
            return false;
        }
        if(root.data==k){
            return true;
        }
        if(k<root.data){
            return searchInBst(root.left,k);
        }
        else{
            return searchInBst(root.right,k);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.right.left = new Node(18);
        root.right.right = new Node(80);
        root.right.left.left = new Node(16);
        //root.right.left.right = new Node(70);
        //root.right.right.right = new Node(80);


        System.out.println(searchInBst(root,3));
    }
}
