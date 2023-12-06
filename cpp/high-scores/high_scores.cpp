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

        std::sort(scores.rbegin(), scores.rend());

        std::vector<int> three(scores.begin(), scores.begin() + 3);

        return three;
    }

}  // namespace arcade
