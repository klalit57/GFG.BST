package GFG;

public class FloorInBST {
    Node res=null;
    public Node floorOfBST1(Node root, int x){  //MyCode
        if(root==null){
            return res;
        }
        if(root.data==x){
            res=root;
        }else if(root.data>x){
            floorOfBST1(root.left,x);
        }else{
            res=root;
            floorOfBST1(root.right,x);
        }
        return res;
    }

    public static Node floorOfBST2(Node root, int x) {  //GFG Code
        Node res = null;
        while (root != null) {
            if (root.data == x) {
                return root;
            } else if (root.data > x) {
                root = root.left;
            } else {
                res = root;
                root = root.right;
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

        FloorInBST o= new FloorInBST();

        System.out.println(o.floorOfBST1(root,30).data);
        System.out.println(floorOfBST2(root,30).data);

    }
}
