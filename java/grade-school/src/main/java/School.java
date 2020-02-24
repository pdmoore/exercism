import java.util.*;

public class School {
    Map<Integer, List<String>> namesByGrade;

    public School() {
        namesByGrade = new HashMap<>();
    }

    public void add(String name, int grade) {
        if (!namesByGrade.containsKey(grade)) {
            List<String> names = new ArrayList<>();
            namesByGrade.put(grade, names);
        }

        namesByGrade.get(grade).add(name);
    }

    public List<String> roster() {
        List<String> allNames = new ArrayList<>();
        namesByGrade.keySet().iterator().forEachRemaining(grade -> allNames.addAll(grade(grade)));
        return allNames;
    }

    public List<String> grade(int grade) {
        if (!namesByGrade.containsKey(grade)) {
            return Collections.emptyList();
        }

        List<String> allNames = new ArrayList<>();
        List<String> namesForThisGrade = namesByGrade.get(grade);
        Collections.sort(namesForThisGrade);
        allNames.addAll(namesForThisGrade);
        return allNames;
    }
}
