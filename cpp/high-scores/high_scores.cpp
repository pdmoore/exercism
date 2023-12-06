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
        // TODO: Return the highest score for this session.
        return 0;
    }

    std::vector<int> HighScores::top_three() {
        // TODO: Return the top 3 scores for this session in descending order.
        return {0, 1, 2};
    }

}  // namespace arcade
