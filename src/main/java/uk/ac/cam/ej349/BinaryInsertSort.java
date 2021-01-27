package uk.ac.cam.ej349;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinaryInsertSort {

    public static <T> void sort(List<T> list, Comparator<T> comparator) {
        for (int i=1; i < list.size(); i++) {
            int low = 0;
            int high = i;
            int j = 0;
            while (low <= high) {
                j = (high + low) / 2;
                if (comparator.compare(list.get(j), list.get(i)) < 0) {
                    low = j + 1;
                } else if (comparator.compare(list.get(j), list.get(i)) > 0) {
                    high = j - 1;
                } else {
                    break;
                }
            }
            if (comparator.compare(list.get(j), list.get(i)) < 0) {
                j = j+1;
            }

            if (j != i) {
                T temp = list.get(i);
                for (int k=i-1; k >= j; k--) {
                    list.set(k+1, list.get(k));
                }
                list.set(j, temp);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(List.of(3,2,1,5,7,3,723));
        sort(intList, Comparator.naturalOrder());
        System.out.println(intList);
    }
}
