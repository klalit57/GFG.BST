package GFG;

public class createBalancedBstFromSorted {
    static Node balancedTree(int [] arr, int low,int high){
        if(low>high){
            return null;
        }
            int mid = (low + high) / 2;
            Node root = new Node(arr[mid]);
            root.left=balancedTree(arr,low,mid-1);
            root.right=balancedTree(arr,mid+1,high);
            return root;

    }
    static void printInOrder(Node root){
        if(root==null){
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data+" ");
        printInOrder(root.right);
    }
    public static void main(String[] args) {
        int [] arr={7,10,11,15,30,35,40};

        Node root= balancedTree(arr,0,arr.length-1);
        printInOrder(root);
    }
}
