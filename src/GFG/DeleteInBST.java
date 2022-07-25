package GFG;

public class DeleteInBST {
    public static Node deleteInBST(Node root, int x) {
        if (root == null) {
            return null;
        }

        if (x < root.data) {
            root.left = deleteInBST(root.left, x);
        } else if (x > root.data) {
            root.right = deleteInBST(root.right, x);
        } else {
            if(root.right==null){
               return root.left;
            }else if(root.left==null){
                return root.right;
            }else{
                Node succ= getSucc(root);
                root.data=succ.data;
                root.right=deleteInBST(root.right,succ.data);
            }
        }
        return root;
    }

    static Node getSucc(Node root){
        Node curr=root.right;
        while(curr!=null && curr.left!=null){
            curr=curr.left;
        }
        return curr;
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);
        //root.right.left.left = new Node(16);
        //root.right.left.right = new Node(70);
        //root.right.right.right = new Node(80);

        System.out.println(deleteInBST(root,50).data);

    }
}
