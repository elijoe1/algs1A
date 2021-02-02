package uk.ac.cam.ej349;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BottomUpMergeSort {

    public static <T> List<T> sort(List<T> list, Comparator<T> comparator) {

        int groupSize = 2;
        while(groupSize <= list.size()) {
            List<T> newList = new ArrayList<>();
            for (int i = 0; i < list.size(); i += groupSize) {
                List<T> a1 = list.subList(i, Math.min(i + groupSize / 2, list.size()));
                List<T> a2 = list.subList(Math.min(i + groupSize / 2, list.size()), Math.min(i + groupSize, list.size()));
                newList.addAll(merge(a1, a2, comparator));
            }
            list = newList;
            groupSize *= 2;
        }

        if(list.size() != groupSize/2) {
            List<T> a1 = list.subList(0, groupSize/2);
            List<T> a2 = list.subList(groupSize/2, list.size());
            list = new ArrayList<>(merge(a1, a2, comparator));
        }

        return list;
    }

    private static <T> List<T> merge(List<T> list1, List<T> list2, Comparator<T> comparator) {
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        List<T> mergedList = new ArrayList<>();

        while(i3 < list1.size() + list2.size()) {
            if(i1 < list1.size() && i2 < list2.size()) {
                if(comparator.compare(list1.get(i1), list2.get(i2)) < 0) {
                    mergedList.add(i3, list1.get(i1));
                    i3++;
                    i1++;
                } else {
                    mergedList.add(i3, list2.get(i2));
                    i3++;
                    i2++;
                }
            } else if (i1 < list1.size()) {
                for (int i = i1; i < list1.size(); i++) {
                    mergedList.add(i3, list1.get(i));
                    i3++;
                }
            } else {
                for (int i = i2; i < list2.size(); i++) {
                    mergedList.add(i3, list2.get(i));
                    i3++;
                }
            }
        }

        return mergedList;
    }

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(List.of(-3,4,7,3,2,5,4,2,3, 5, 2));
        List<Integer> sortedList = sort(intList, Comparator.naturalOrder());
        System.out.println(sortedList);
    }
}
