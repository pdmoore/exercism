<?php

class Bob
{
    public function respondTo(string $string)
    {
        if ($this->isYelling($string)) {
            return "Whoa, chill out!";
        }

        if ($this->isQuestioning($string)) {
            return "Sure.";
        }

        return "Whatever.";
    }

    public function isYelling(string $bobHeard): bool
    {
        return ($bobHeard === strtoupper($bobHeard)) ||
            (strpos($bobHeard, "!") !== false);
    }

    public function isQuestioning(string $bobHeard): bool
    {
        return strpos($bobHeard, "?") !== false;
    }
}
