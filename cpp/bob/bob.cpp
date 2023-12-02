#include <cstring>
#include <cstdlib>
#include "bob.h"

namespace bob {
    std::string hey(const std::string you_said) {

        bool question = false;
        for (char c : you_said) {
            if (!isspace(c)) {
                question = false;
            }
            if (c == '?') {
                question = true;
            }
        }

        if (question) {
            return "Sure.";
        }
        return "Whatever.";
        // int length = strlen(string);

        // if (length == 0) {
        //     return "Fine. Be that way!";
        // }

        // char* upperVersion = static_cast<char *>(calloc(length, sizeof(char)));
        // strcpy(upperVersion, string);

        // if (string[length - 1] == '?') {
        //     if (strcmp(upperVersion, string)) {
        //         return "Calm down, I know what I'm doing!";
        //     }
        //     return "Sure.";
        // }

        // if (strcmp(upperVersion, string)) {
        //     return "Whoa, chill out!";
        // }


        // if (strcmp(string, "hi")) {
        //     return "hey";
        // }
        // return "Whatever.";
    }

}  // namespace bob
