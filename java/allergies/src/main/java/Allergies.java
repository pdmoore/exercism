import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Allergies {

    private final int allergenScore;
    private Collection<Allergen> allergens;

    public Allergies(int allergenScore) {
        this.allergenScore = allergenScore;

        allergens = new ArrayList();
        buildAllergenList();
    }

    public Collection getList() {
        return allergens;
    }

    private void buildAllergenList() {
        for (int i = 0; i <= 7; i++) {
            int mask = 1 << i;
            if ((allergenScore & mask) != 0) {
                allergens.add(Allergen.values()[i]);
            }
        }
    }

    public boolean isAllergicTo(Allergen allergen) {
        return (allergenScore & allergen.getScore()) != 0;
    }
}
