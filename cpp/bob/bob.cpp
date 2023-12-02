#include <cstring>
#include <cstdlib>
#include "bob.h"

namespace bob {
    std::string trim(const std::string & source) {
        std::string s(source);
        s.erase(0,s.find_first_not_of(" \n\r\t"));
        s.erase(s.find_last_not_of(" \n\r\t")+1);
        return s;
    }

    std::string hey(const std::string you_said) {

        std::string trimmedInput = trim(you_said);

        bool empty = true;

        bool upperCaseFound = false;
        bool lowerCaseFound = false;
        for (char c : trimmedInput) {
            if (!isspace(c)) {
                empty = false;
            }
            if (isupper(c)) {
                upperCaseFound = true;
            }
            if (islower(c)) {
                lowerCaseFound = true;
            }
        }

        bool shouting = upperCaseFound && !lowerCaseFound;
        bool question = trimmedInput.back() == '?';
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
