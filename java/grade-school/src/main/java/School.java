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
        if (noOneEnrolledIn(gradeNumber)) {
            return Collections.emptyList();
        }

        List<String> allNamesForGrade = new ArrayList<>();
        allNamesForGrade.addAll(namesByGrade.get(gradeNumber));
        Collections.sort(allNamesForGrade);
        return allNamesForGrade;
    }

    private boolean noOneEnrolledIn(int grade) {
        return !namesByGrade.containsKey(grade);
    }
}
