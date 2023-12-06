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

        // hmmm std::max didn't work
        int num_to_copy = scores.size();
        if (num_to_copy > 3) {
            num_to_copy = 3;
        }

        std::vector<int> three(sorted_copy.begin(), sorted_copy.begin() + num_to_copy);

//        if (scores.size() == 2) {
//            three.pop_back();
//        }
//        if (scores.size() == 1) {
//            three.pop_back();
//            three.pop_back();
//        }

        return three;
    }

}  // namespace arcade
