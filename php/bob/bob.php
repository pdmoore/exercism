<?php

class Bob
{
    public function respondTo(string $string)
    {
        if ($this->isYelling($string)) {
            return "Whoa, chill out!";
        }

        if (strpos($string, "?") !== false) {
            return "Sure.";
        }

        return "Whatever.";
    }

    public function isYelling(string $bobHeard): bool
    {
        return ($bobHeard === strtoupper($bobHeard)) ||
            (strpos($bobHeard, "!") !== false);
    }
}
