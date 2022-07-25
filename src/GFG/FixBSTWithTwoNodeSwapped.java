package GFG;

public class FixBSTWithTwoNodeSwapped {
    static Node prev=null;
    static Node first=null;
    static Node second=null;
    public static void fixBST(Node root){ //gfg method
       if(root==null){
           return;
       }
        fixBST(root.left);
       if(prev!=null && root.data<prev.data){
           if(first==null){
               first=prev;
           }
           second=root;
       }
       prev=root;
        fixBST(root.right);
    }

    static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(18);
        root.left = new Node(60);
        root.right = new Node(70);
        root.left.left = new Node(4);
        root.right.left = new Node(8);
        root.right.right = new Node(80);
        //root.right.left.left = new Node(16);

        inOrder(root);
        System.out.println();
        fixBST(root);
        int temp=second.data;
        second.data= first.data;
        first.data=temp;

        inOrder(root);
    }
}
