package GFG;

import jdk.swing.interop.SwingInterOpUtils;

public class CeilingOnLeftSide {

    public static void printCeil1(int [] arr, int n){  //gfg naive
        System.out.print(-1+" ");
        for(int i=1;i<n;i++){
            int diff=Integer.MAX_VALUE;
                    for(int j=0;j<i;j++){
                        if(arr[j]>=arr[i]){
                            diff=Math.min(diff,arr[j]-arr[i]);
                        }
                    }
                    if(diff==Integer.MAX_VALUE){
                        System.out.print(-1+" ");
                    }
                    else{
                        System.out.print(arr[i]+diff+" ");
                    }
        }
    }

    public static void printCeil2(int [] arr, int n){ //gfg efficient
        System.out.print(-1+" ");

        java.util.TreeSet<Integer> s= new java.util.TreeSet<Integer>();

        s.add(arr[0]);

        for(int i=1;i<n;i++){
            if(s.ceiling(arr[i])!=null){
                System.out.print(s.ceiling(arr[i])+" ");
            }else{
                System.out.print(-1+" ");
            }
            s.add(arr[i]);
        }
    }

    public static void main(String[] args) {
          int [] arr= {2,8,30,15,25,12};

          printCeil1(arr,arr.length);
        System.out.println();
          printCeil2(arr,arr.length);

    }
}
