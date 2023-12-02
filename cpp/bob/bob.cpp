#include <cstring>
#include <cstdlib>
#include "bob.h"

namespace bob {
    const char *hey(const char *string) {

        int length = strlen(string);
        if (string[length - 1] != '?') {
            return "Sure.";
        }

        char* upperVersion = static_cast<char *>(calloc(length, sizeof(char)));
        strcpy(upperVersion, string);
        if (strcmp(upperVersion, string)) {
            return "Whoa, chill out!";
        }


        if (strcmp(string, "hi")) {
            return "hey";
        }
        return "Whatever.";
    }

}  // namespace bob
