import java.util.*;

public class School {
    Map<Integer, List<String>> namesByGrade;

    public School() {
        namesByGrade = new HashMap<>();
    }

    public void add(String name, int grade) {
        if (noOneEnrolledIn(grade)) {
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
        if (noOneEnrolledIn(gradeNumber)) {
            return Collections.emptyList();
        }

        List<String> allNames = new ArrayList<>();
        allNames.addAll(namesByGrade.get(gradeNumber));
        Collections.sort(allNames);
        return allNames;
    }

    private boolean noOneEnrolledIn(int grade) {
        return !namesByGrade.containsKey(grade);
    }
}
