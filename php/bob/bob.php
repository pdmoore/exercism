<?php

class Bob
{
    public function respondTo(string $string)
    {
        if ($this->isSilent($string)) {
            return "Fine. Be that way!";
        }

        $isYelling = $this->isYelling($string);
        $isQuestioning = $this->isQuestioning($string);

        if ($isYelling && $isQuestioning) {
            return "Calm down, I know what I'm doing!";
        }

        if ($isYelling) {
            return "Whoa, chill out!";
        }

        if ($isQuestioning) {
            return "Sure.";
        }

        return "Whatever.";

        //TODO - mostly there, 5 failing tests (from line 95 down
    }

    public function isYelling(string $bobHeard): bool
    {
        $containsLetters = preg_match( '/[a-zA-Z]/', $bobHeard);
        $allUpperCase = $bobHeard === strtoupper($bobHeard);
        return $containsLetters && $allUpperCase;
    }

    public function isQuestioning(string $bobHeard): bool
    {
        $trimmed = rtrim($bobHeard);
        $lastCharPosition = strlen($trimmed) - 1;
        return (substr($trimmed, $lastCharPosition) === "?");
    }

    public function isSilent(string $bobHeard): bool
    {
        return strlen($bobHeard) === 0 || ctype_space($bobHeard);
    }
}
