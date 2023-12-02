#include <cstring>
#include <cstdlib>
#include "bob.h"

namespace bob {
    std::string hey(const std::string you_said) {

        bool question = false;
        bool empty = true;
        bool upperCaseFound = false;
        bool lowerCaseFound = false;
        for (char c : you_said) {
            if (!isspace(c)) {
                question = false;
                empty = false;
            }
            if (isupper(c)) {
                upperCaseFound = true;
            }
            if (islower(c)) {
                lowerCaseFound = true;
            }
            if (c == '?') {
                question = true;
            }
        }

        bool shouting = upperCaseFound && !lowerCaseFound;
        if (question) {
            if (shouting) {
                return "Calm down, I know what I'm doing!";
            }
            return "Sure.";
        }
        if (empty) {
            return "Fine. Be that way!";
        }
        if (shouting) {
            return "Whoa, chill out!";
        }
        return "Whatever.";
    }

}  // namespace bob
