<?php

const GIGASECOND = 1_000_000_000;

function from(DateTimeImmutable $date) : DateTimeImmutable
{
    return $date->add(new DateInterval('PT'.GIGASECOND.'S'));
}

