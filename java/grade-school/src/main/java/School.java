import java.util.ArrayList;
import java.util.List;

public class School {
    List<String> names;

    public School() {
        this.names = new ArrayList<>();
    }


    public void add(String name, int grade) {
        names.add(name);
    }

    public List<String> roster() {
        return names;
    }

    public List<String> grade(int grade) {
        return null;
    }
}
