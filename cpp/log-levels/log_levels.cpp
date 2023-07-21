#include <string>

namespace log_line {

    const std::string message(std::string message_contents) {
        int colon_index = message_contents.find(":");
        int start_of_description = colon_index + 2;
        return message_contents.substr(start_of_description);
    };

    const std::string log_level(std::string message_contents) {
        int end_of_level_index = message_contents.find("]") - 1;
        return message_contents.substr(1, end_of_level_index);
    }

    const std::string reformat(std::string message_contents) {
        return log_line::message(message_contents) + " (" + log_line::log_level(message_contents) + ")";
    }
} // namespace log_line
