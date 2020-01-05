import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class KindergartenGarden {

    private final String[] rows;
    private final List<String> studentNames = Arrays.asList("Alice", "Bob", "Charlie", "David");
    private HashMap<String, List> plantsPerChild;

    KindergartenGarden(String garden) {
        rows = garden.split("\\n");

        plantsPerChild = new HashMap<>();
        List<Plant> plants = new ArrayList<>();
        plantsPerChild.put("Alice", plants);
        plants = new ArrayList<>();
        plantsPerChild.put("Bob", plants);
        plants = new ArrayList<>();
        plantsPerChild.put("Charlie", plants);
        plants = new ArrayList<>();
        plantsPerChild.put("David", plants);
    }

    List<Plant> getPlantsOfStudent(String student) {
        for (String row :
                rows) {
            for (int i = 0; i < row.length(); i += 2) {

                int studentNameIndex = i / 2;
                String thisStudent = studentNames.get(studentNameIndex);
                List<Plant> plants = plantsPerChild.get(thisStudent);

                int studentOffset = i;
                plants.add(convertCupContentToPlantName(row.charAt(studentOffset + 0)));
                plants.add(convertCupContentToPlantName(row.charAt(studentOffset + 1)));

                plantsPerChild.put(thisStudent, plants);
            }

        }

        return plantsPerChild.get(student);
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
