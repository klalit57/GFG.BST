package GFG;

public class CheckForBST {
    static boolean checkBST2(Node root){
        if(root==null){
            return true;
        }
        boolean left=checkBST2(root.left);
        boolean right=checkBST2(root.right);

        boolean res= root.data>(findLeftMax(root)) && root.data<(findRightMin(root));

        return (left && right) && res;
    }

    static boolean checkBST3(Node root, int min, int max){  //gfg method-3
        if(root==null){
            return true;
        }
        boolean left=checkBST3(root.left,min,root.data);
        boolean right=checkBST3(root.right,root.data,max);
        boolean res=root.data<max && root.data>min;

        return (left && right) && res;
    }

    static int prev1=Integer.MIN_VALUE;
    static boolean checkBST4(Node root){  //My Method-4
        if(root==null){
            return true;
        }
        boolean left=checkBST4(root.left);
        boolean res=false;
        if(root.data>prev1){
            prev1=root.data;
            res= true;
        }
        else if(root.data<=prev1){
            res=false;
        }
        boolean right=checkBST4(root.right);

        return (left && right) && res;
    }

    static int prev2=Integer.MIN_VALUE;
    static boolean checkBST5(Node root){  //GFG MEthod 4
        if(root==null){
            return true;
        }
        if(checkBST5(root.left)==false){
            return false;
        }
        if(root.data<=prev2){
            return false;
        }
        prev2=root.data;
        return checkBST5(root.right);
    }

    static int findRightMin(Node root){
        root=root.right;
        while(root!=null && root.left!=null){
            root=root.left;
        }

        return (root==null)?Integer.MAX_VALUE:root.data;
    }
    static int findLeftMax(Node root){
        root=root.left;
        while(root!=null && root.right!=null){
            root=root.right;
        }

        return (root==null)?Integer.MIN_VALUE:root.data;
    }

    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(6);
        root.right.left = new Node(18);
        root.right.right = new Node(80);
        root.right.left.left = new Node(16);

        System.out.println(checkBST2(root));

        System.out.println(checkBST3(root,Integer.MIN_VALUE,Integer.MAX_VALUE));

        System.out.println(checkBST4(root));

        System.out.println(checkBST5(root));


    }
}
