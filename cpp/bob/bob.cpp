#include <cstring>
#include <cstdlib>
#include "bob.h"

namespace bob {
    const char *hey(const char *string) {

        char* upperVersion = static_cast<char *>(calloc(strlen(string), sizeof(char)));
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
