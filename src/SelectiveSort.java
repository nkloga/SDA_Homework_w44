import java.util.ArrayList;
import java.util.Arrays;

public class SelectiveSort {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 43, 12, 44, 123, 32, -12, 0, 23, 1344, 5, 33));
        System.out.println("Initial list:               " + list);
        System.out.println("Selective sorted list:      " + selectiveSort(list));
    }

    public static ArrayList<Integer> selectiveSort(ArrayList<Integer> list) {
        ArrayList<Integer> sortedList = new ArrayList<>();
        while (list.size() != 0) {
            int minValue = list.get(0);
            int minIndex = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) < minValue) {
                    minValue = list.get(i);
                    minIndex = i;
                }
            }
            sortedList.add(minValue);
            list.remove(minIndex);
        }
        return sortedList;
    }
}