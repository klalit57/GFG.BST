package GFG;

public class CeilingOfBST {

    public static Node ceilingOfBST1(Node root, int x){  //GFG & MyCode
        Node res=null;

        while(root!=null){
            if(root.data==x){
                return root;
            }
            else if(root.data<x){
                root=root.right;
            }else{
                res=root;
                root=root.left;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right = new Node(30);
        //root.right.right = new Node(80);
        //root.right.left.left = new Node(16);
        //root.right.left.right = new Node(70);
        //root.right.right.right = new Node(80);

        System.out.println(ceilingOfBST1(root,40).data);

    }
}
