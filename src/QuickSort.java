import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 43, 12, 44, 123, 32, -12, 0, 23, 1344, 5, 33));
        System.out.println("Initial list:          " + list);
        System.out.println("Quick sorted list:     " + quicksort(list));
    }

    public static ArrayList<Integer> quicksort(ArrayList<Integer> list) {
        int pivot;
        if (list.size() < 2) {
            return list;
        } else {
            pivot = list.get(0);
            ArrayList<Integer> greater = new ArrayList<>();
            ArrayList<Integer> less = new ArrayList<>();

            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) > pivot) {
                    greater.add(list.get(i));
                } else {
                    less.add(list.get(i));
                }
            }

            ArrayList<Integer> result = new ArrayList<>(quicksort(less));
            result.add(pivot);
            result.addAll(quicksort(greater));
            return result;
        }
    }
}
