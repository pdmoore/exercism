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
        namesByGrade.keySet().iterator().forEachRemaining(gradeNumber -> allNames.addAll(grade(gradeNumber)));
        return allNames;
    }

    public List<String> grade(int gradeNumber) {
        if (!namesByGrade.containsKey(gradeNumber)) {
            return Collections.emptyList();
        }

        List<String> allNames = new ArrayList<>();
        List<String> namesForThisGrade = namesByGrade.get(gradeNumber);
        Collections.sort(namesForThisGrade);
        allNames.addAll(namesForThisGrade);
        return allNames;
    }
}
