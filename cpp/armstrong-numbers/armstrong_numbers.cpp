#include "armstrong_numbers.h"
#include <math.h>

namespace armstrong_numbers {

    bool is_armstrong_number(int candidate) {
        int num_digits = floor(log10(candidate) + 1);

        int sum_of_powers = 0;
        for (int i = candidate; i > 0;  i /= 10) {
            sum_of_powers += pow(i % 10, num_digits);
        }

        return sum_of_powers == candidate;
    }
}  // namespace armstrong_numbers
