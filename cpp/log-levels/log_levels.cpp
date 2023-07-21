#include <string>

namespace log_line {

    const std::string message(std::string message_contents) {
        return message_contents.substr(9);
    };
} // namespace log_line
