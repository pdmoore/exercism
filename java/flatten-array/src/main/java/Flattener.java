import java.util.ArrayList;
import java.util.List;

public class Flattener {

    public List<Object> flatten(List<Object> unflatList) {

        return recurseAndFlatten(unflatList, new ArrayList<>());
    }

    private List<Object> recurseAndFlatten(List<Object> unflatList, List<Object> flatList) {

        for (Object o: unflatList) {
            if (o instanceof List<?>) {
                recurseAndFlatten((List<Object>)o, flatList);
            } else if (null != o) {
                flatList.add(o);
            }
        }

        return flatList;
    }

}
