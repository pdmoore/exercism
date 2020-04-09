<?php

function from($date) : DateTimeImmutable
{
    $UTC = new DateTimeZone('UTC');
    return new DateTimeImmutable('2020-04-07', $UTC);
}

