import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class KindergartenGarden {

    private final String[] rows;

    KindergartenGarden(String garden) {
        rows = garden.split("\\n");
    }

    List<Plant> getPlantsOfStudent(String student) {
        List<Plant> plants = new ArrayList<>();

        for (String row :
                rows) {
            plants.add(plantFor(row.charAt(0)));
            plants.add(plantFor(row.charAt(1)));
        }

        return plants;
    }

    private Plant plantFor(char charAt) {
        switch (charAt) {
            case 'C' : return Plant.CLOVER;
            case 'G' : return Plant.GRASS;
            case 'R' : return Plant.RADISHES;
            case 'V' : return Plant.VIOLETS;
        }

        return null;
    }

}
