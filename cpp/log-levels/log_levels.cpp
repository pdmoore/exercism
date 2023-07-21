#include <string>

namespace log_line {

    const std::string message(std::string message_contents) {
        int colon_index = message_contents.find(":");
        int start_of_description = colon_index + 2;
        return message_contents.substr(start_of_description);
    };
} // namespace log_line
