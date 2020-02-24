import java.util.*;

public class School {
    Map<Integer, List<String>> namesByGrade;

    public School() {
        namesByGrade = new HashMap<>();
    }

    public void add(String name, int grade) {
        namesByGrade.computeIfAbsent(grade, key -> new ArrayList<>()).add(name);
    }

    public List<String> roster() {
        List<String> allNames = new ArrayList<>();
        namesByGrade.keySet().iterator().forEachRemaining(gradeNumber -> allNames.addAll(grade(gradeNumber)));
        return allNames;
    }

    public List<String> grade(int gradeNumber) {
        List<String> allNamesForGrade = new ArrayList<>();
        allNamesForGrade.addAll(namesByGrade.getOrDefault(gradeNumber, Collections.emptyList()));
        Collections.sort(allNamesForGrade);
        return allNamesForGrade;
    }
}
