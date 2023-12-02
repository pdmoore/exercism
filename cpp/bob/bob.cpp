#include <cstring>
#include <cstdlib>
#include "bob.h"

namespace bob {
    std::string right_trim(const std::string & source) {
        std::string s(source);
        s.erase(s.find_last_not_of(" \t\n\r")+1);
        return s;
    }

    std::string hey(const std::string you_said) {

        std::string trimmedInput = right_trim(you_said);

        bool upperCaseFound = false;
        bool lowerCaseFound = false;
        for (char c : trimmedInput) {
            if (isupper(c)) {
                upperCaseFound = true;
            }
            if (islower(c)) {
                lowerCaseFound = true;
            }
        }

        bool shouting = upperCaseFound && !lowerCaseFound;
        bool question = trimmedInput.back() == '?';
        if (trimmedInput.length() == 0) {
            return "Fine. Be that way!";
        } else if (question) {
            if (shouting) {
                return "Calm down, I know what I'm doing!";
            }
            return "Sure.";
        } else if (shouting) {
            return "Whoa, chill out!";
        }
        return "Whatever.";
    }
}  // namespace bob
