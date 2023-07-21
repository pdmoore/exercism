#include <string>

namespace log_line {

    const std::string message(const char *message_contents) {
        std::string foo = message_contents;
        return foo.substr(9);
    };
} // namespace log_line
