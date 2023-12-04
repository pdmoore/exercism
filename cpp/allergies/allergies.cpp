#include "allergies.h"

namespace allergies {

    static const std::array<std::string, 8> items = {
            "eggs", "peanuts", "shellfish", "strawberries",
            "tomatoes", "chocolate", "pollen", "cats"
    };

    allergy_test::allergy_test(int score) {
        for (std::size_t i = 0; i < items.size(); ++i) {
            if (score & (1 << i)) {
                allergies.insert(items[i]);
            }
        }
    }

    bool allergy_test::is_allergic_to(const std::string& item) const {
        return allergies.find(item) != allergies.end();
    }

    const std::unordered_set<std::string>& allergy_test::get_allergies() const {
        return allergies;
    }

}  // namespace allergies
