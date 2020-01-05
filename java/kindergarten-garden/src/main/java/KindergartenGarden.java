import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class KindergartenGarden {

    private final String garden;

    KindergartenGarden(String garden) {
        this.garden = garden;
    }

    List<Plant> getPlantsOfStudent(String student) {
        List<Plant> plants = new ArrayList<>();
        plants.add(Plant.RADISHES);
        plants.add(Plant.CLOVER);
        plants.add(Plant.GRASS);
        plants.add(Plant.GRASS);

        return plants;
    }

}
