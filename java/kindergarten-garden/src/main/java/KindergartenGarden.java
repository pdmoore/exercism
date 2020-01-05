import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class KindergartenGarden {

    private final List<String> STUDENT_NAMES = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry");
    private HashMap<String, List> plantsPerChild;
    private final int NUM_PLANTS_PER_STUDENT = 2;

    KindergartenGarden(String garden) {
        initializePlantsByStudent();
        assignPlantsByStudent(garden);
    }

    List<Plant> getPlantsOfStudent(String student) {
        return plantsPerChild.get(student);
    }

    private void initializePlantsByStudent() {
        plantsPerChild = new HashMap<>();
        for (int i = 0; i < STUDENT_NAMES.size(); i++) {
            List<Plant> plants = new ArrayList<>();
            plantsPerChild.put(STUDENT_NAMES.get(i), plants);
        }
    }

    private void assignPlantsByStudent(String garden) {
        String[] rows = garden.split("\\n");

        for (String row :
                rows) {
            for (int i = 0; i < row.length(); i += NUM_PLANTS_PER_STUDENT) {

                int studentNameIndex = i / NUM_PLANTS_PER_STUDENT;
                String thisStudent = STUDENT_NAMES.get(studentNameIndex);
                List<Plant> plants = plantsPerChild.get(thisStudent);

                for (int j = 0; j < NUM_PLANTS_PER_STUDENT; j++) {
                    plants.add(Plant.getPlant(row.charAt(i + j)));
                }

                plantsPerChild.put(thisStudent, plants);
            }

        }
    }
}
