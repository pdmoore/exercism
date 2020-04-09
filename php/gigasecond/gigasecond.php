<?php

function from($date) : DateTimeImmutable
{
    $timespan = 1000000000;
    return $date->add(new DateInterval('PT'.$timespan.'S'));
}

