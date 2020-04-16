<?php

const GIGASECOND = 1e9;

function from($date) : DateTimeImmutable
{
    return $date->add(new DateInterval('PT'.GIGASECOND.'S'));
}

