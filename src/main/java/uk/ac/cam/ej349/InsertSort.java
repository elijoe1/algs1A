package uk.ac.cam.ej349;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InsertSort {

    public static <T> void sort(List<T> list, Comparator<T> comparator) {
        for (int i = 1; i < list.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (comparator.compare(list.get(j),  list.get(j+1)) < 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(List.of(1, 4, 2, 15, -2 , 23));
        List<String> stringList = new ArrayList<>(List.of("hello", "apple", "beans"));
        InsertSort.sort(intList, Comparator.naturalOrder());
        InsertSort.sort(stringList, Comparator.reverseOrder());
        System.out.println(intList);
        System.out.println(stringList);
    }
}
