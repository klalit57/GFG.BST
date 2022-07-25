package GFG;

public class InsertInBST {
    public static Node insertInBST(Node root,int x){
        if(root==null){
            return new Node(x);
        }
        if(x<root.data){
            root.left=insertInBST(root.left,x);
        }else if(x>root.data){
            root.right=insertInBST(root.right,x);
        }
        return root;
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

        System.out.println(insertInBST(root,17).data);

    }
}
