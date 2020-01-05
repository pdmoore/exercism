import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class KindergartenGarden {

    private final String[] rows;
    private final List<String> STUDENT_NAMES = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry");
    private HashMap<String, List> plantsPerChild;

    KindergartenGarden(String garden) {
        rows = garden.split("\\n");

        plantsPerChild = new HashMap<>();
        for (int i = 0; i < STUDENT_NAMES.size(); i++) {
            List<Plant> plants = new ArrayList<>();
            plantsPerChild.put(STUDENT_NAMES.get(i), plants);
        }

        assignPlantsByStudent();
    }

    List<Plant> getPlantsOfStudent(String student) {

        return plantsPerChild.get(student);
    }

    private void assignPlantsByStudent() {
        for (String row :
                rows) {
            for (int i = 0; i < row.length(); i += 2) {

                int studentNameIndex = i / 2;
                String thisStudent = STUDENT_NAMES.get(studentNameIndex);
                List<Plant> plants = plantsPerChild.get(thisStudent);

                int studentOffset = i;
                plants.add(convertCupContentToPlantName(row.charAt(studentOffset + 0)));
                plants.add(convertCupContentToPlantName(row.charAt(studentOffset + 1)));

                plantsPerChild.put(thisStudent, plants);
            }

        }
    }

    private Plant convertCupContentToPlantName(char cupContains) {
        switch (cupContains) {
            case 'C' : return Plant.CLOVER;
            case 'G' : return Plant.GRASS;
            case 'R' : return Plant.RADISHES;
            case 'V' : return Plant.VIOLETS;
        }

        return null;
    }

}
