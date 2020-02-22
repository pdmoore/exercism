import java.util.*;

public class School {
    Map<Integer, List<String>> gradeAndNames;

    public School() {
        gradeAndNames = new HashMap<>();
    }


    public void add(String name, int grade) {
        if (!gradeAndNames.containsKey(grade)) {
            List<String> names = new ArrayList<>();
            gradeAndNames.put(grade, names);
        }

        gradeAndNames.get(grade).add(name);
    }

    public List<String> roster() {

        List<String> allNames = new ArrayList<>();

        for (Integer grade :
                gradeAndNames.keySet()) {
            allNames.addAll(gradeAndNames.get(grade));
        }

//        Collections.sort(names);
        return allNames;
    }

    public List<String> grade(int grade) {
        return null;
    }
}
