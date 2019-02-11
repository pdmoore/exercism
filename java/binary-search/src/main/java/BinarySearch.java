import java.util.List;

public class BinarySearch<T extends Comparable<T>> {
    private List<T> list;

    public BinarySearch(List<? extends T> list) {
        this.list = List.copyOf(list);
    }

    public int indexOf(T element) {
        int begin = 0;
        int end = list.size();

        while (begin < end) {
            int middle = (begin + end) >>> 1;
            int comparisonResult = element.compareTo(list.get(middle));

            if (comparisonResult == 0) {
                return middle;
            }
            else if (comparisonResult < 0) {
                end = middle;
            }
            else {
                begin = middle + 1;
            }
        }

        return -1;
    }

}
