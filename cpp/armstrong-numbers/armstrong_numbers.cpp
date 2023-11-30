#include "armstrong_numbers.h"
#include <math.h>

namespace armstrong_numbers {

    bool is_armstrong_number(int candidate) {

        // IN PROGRESS
        // refactoring to a genersal solution
        // Need to know how to split candidate into individual numbers
        // need to add each individual number to a list
        // need to iterate the list, riasing each item to number of items in list
        // need to sum that iteration
        // return should stay the same

        // need to slice off each digit into a list
        // need to sum each listed digit to the power of number of digits
        // return if sum == i

        // num_digits is same as length of the list of individual digits


        int num_digits = floor(log10(candidate) + 1);
        int digits[10];
        int number = candidate;
        for (int i = num_digits; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }


        int sum_of_powers = 0;

//        if (candidate == 0) return true;

        for (int i = 1; i <= num_digits; ++i) {
            sum_of_powers += pow(digits[i], num_digits);
        }

        return sum_of_powers == candidate;
    }
}  // namespace armstrong_numbers
