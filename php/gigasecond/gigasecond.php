<?php

const GIGASECOND = 1000000000;

function from($date) : DateTimeImmutable
{
    return $date->add(new DateInterval('PT'.GIGASECOND.'S'));
}

