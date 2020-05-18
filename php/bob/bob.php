<?php

class Bob
{
    public function respondTo(string $string)
    {
        if (strpos($string, "!") !== false) {
            return "Whoa, chill out!";
        }

        return "Whatever.";
    }
}
