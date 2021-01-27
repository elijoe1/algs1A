package uk.ac.cam.ej349;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BubbleSort {

    public static <T> void sort(List<T> list, Comparator<T> comparator) {
        boolean swapsOnPass = true;
        while (swapsOnPass) {
            swapsOnPass = false;
            for (int i = 0; i < list.size() - 1; i++) {
                if (comparator.compare(list.get(i), list.get(i+1)) > 0) {
                    T temp = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1, temp);
                    swapsOnPass = true;
                }
            }
            System.out.println(list);
        }
    }

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(List.of(9,2,3,5,4,0,7));
        sort(intList, Comparator.naturalOrder());
        System.out.println(intList);
    }
}
