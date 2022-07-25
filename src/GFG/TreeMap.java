package GFG;

//put,remove,containsKey,containsValue, lowerKey,higherKey,floorKey,ceilingKey, getValue,firstEntry,lastEntry...etc

import java.util.*;

public class TreeMap {
    public static void main(String[] args) {
        java.util.TreeMap<Integer,String> t= new java.util.TreeMap<>();

        t.put(10,"geeks");
        t.put(15,"ide");
        t.put(5,"courses");
        t.put(20,"lalit");

        System.out.println(t);

        System.out.println(t.containsKey(5));
        System.out.println(t.containsValue("lalit"));

        t.remove(20);

        for(Map.Entry<Integer,String> e:t.entrySet()){
            System.out.print(e.getKey()+" "+e.getValue());
        }

        System.out.println(t.size());

        System.out.println(t.lowerKey(10));
        System.out.println(t.higherKey(10));
        System.out.println(t.floorKey(10));
        System.out.println(t.ceilingKey(10));

        System.out.println(t.lowerKey(10));
        System.out.println(t.higherKey(5));
        System.out.println(t.floorKey(5));
        System.out.println(t.ceilingKey(5));


    }
}
