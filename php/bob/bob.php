<?php

class Bob
{
    public function respondTo(string $string)
    {

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
    }

    public function isYelling(string $bobHeard): bool
    {
        $containsLetters = preg_match( '/[a-zA-Z]/', $bobHeard);
        $allUpperCase = $bobHeard === strtoupper($bobHeard);
        return $containsLetters && $allUpperCase;
    }

    public function isQuestioning(string $bobHeard): bool
    {
        return strpos($bobHeard, "?") !== false;
    }
}
