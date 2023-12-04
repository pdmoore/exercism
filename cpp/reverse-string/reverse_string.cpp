#include "reverse_string.h"



namespace reverse_string {
    std::string reverse_string(const std::string forwards) {

        std::string result = "";

        for (int i = forwards.length(); i > 0; i--) {
            result += forwards[i - 1];
        }

        return result;
    }

}  // namespace reverse_string
