#include "reverse_string.h"



namespace reverse_string {
    std::string reverse_string(const std::string forwards) {
        std::string result = "";

        for (int i = forwards.length() - 1; i >= 0; i--) {
            result += forwards[i];
        }

        return result;
    }

}  // namespace reverse_string
