#include "high_scores.h"

#include <algorithm>

namespace arcade {

    std::vector<int> HighScores::list_scores() {
        return scores;
    }

    int HighScores::latest_score() {
        return scores.back();
    }

    int HighScores::personal_best() {
        int best = 0;
        for (int i : scores) {
            best = std::max(best, i);
        }
        return best;
    }

    std::vector<int> HighScores::top_three() {
        std::vector<int> sorted_copy(scores.begin(), scores.end());
        std::sort(sorted_copy.rbegin(), sorted_copy.rend());

        int num_to_copy = std::min(std::size(scores), size_t(3));
        std::vector<int> three(sorted_copy.begin(), sorted_copy.begin() + num_to_copy);

        return three;
    }

}  // namespace arcade
