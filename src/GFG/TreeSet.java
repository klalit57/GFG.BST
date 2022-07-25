package GFG;  //treeSet,add,print, remove, contains, higher, lower, floor, ceiling, size, isEmpty , iterator, for loo[ iteration

import java.util.Iterator;

public class TreeSet {

    public static void main(String[] args) {

        java.util.TreeSet<Integer> s= new java.util.TreeSet<>();

        s.add(10);
        s.add(5);
        s.add(2);
        s.add(15);

        System.out.println(s);

        System.out.println(s.contains(5));

        Iterator<Integer> i= s.iterator();

        while(i.hasNext()){
            System.out.print(i.next()+" ");
        }

        s.remove(15);

        for(Integer x:s){
            System.out.print(x+" ");
        }

        System.out.println(s.lower(5));
        System.out.println(s.higher(5));
        System.out.println(s.floor(5));
        System.out.println(s.ceiling(5));


    }
}
