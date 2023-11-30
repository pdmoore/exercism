#include "armstrong_numbers.h"
#include <math.h>

namespace armstrong_numbers {

    bool is_armstrong_number(int candidate) {
        int num_digits = floor(log10(candidate) + 1);
        int digits[10];
        int number = candidate;
        for (int i = num_digits; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }

        int sum_of_powers = 0;
        for (int i = 1; i <= num_digits; ++i) {
            sum_of_powers += pow(digits[i], num_digits);
        }

        return sum_of_powers == candidate;
    }
}  // namespace armstrong_numbers
