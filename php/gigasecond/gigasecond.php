<?php

function from($date) : DateTimeImmutable
{
    $gigasecond = 1000000000;
    return $date->add(new DateInterval('PT'.$gigasecond.'S'));
}

