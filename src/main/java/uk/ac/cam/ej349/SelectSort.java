package uk.ac.cam.ej349;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SelectSort {

    public static <T> void sort(List<T> list, Comparator<T> comparator) {
        for (int i=0; i < list.size(); i++) {
            int mindex = i;
            for (int j=i+1; j < list.size(); j++) {
                if (comparator.compare(list.get(j), list.get(mindex)) < 0) {
                    mindex = j;
                }
            }
            T temp = list.get(i);
            list.set(i, list.get(mindex));
            list.set(mindex, temp);
        }
    }

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(List.of(1, 4, 3, 2, 65, 3));
        sort(intList, Comparator.reverseOrder());
        System.out.println(intList);
    }
}
