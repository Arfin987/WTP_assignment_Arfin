package day_10_Assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeList {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6);
        List<Integer> list3 = Arrays.asList(6, 7, 8, 1);

       
        ArrayList<Integer> merge= new ArrayList<>();

      
        add(merge, list1);
        add(merge, list2);
        add(merge, list3);

        System.out.println("Unique  List: " + merge);
    }
    public static void add(List<Integer> a, List<Integer> b) {
        for (Integer i : b) {
            if (!a.contains(i)) {
                a.add(i);
            }
        }
    }
}
