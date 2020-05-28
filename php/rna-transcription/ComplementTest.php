<?php

class ComplementTest extends PHPUnit\Framework\TestCase
{
    public static function setUpBeforeClass() : void
    {
        require_once 'rna-transcription.php';
    }

    public function testTranscribesGuanineToCytosine() : void
    {
        $this->assertSame('G', rnatranscription::toRna('C'));
    }

    public function testTranscribesCytosineToGuanine() : void
    {
        $this->assertSame('C', rnatranscription::toRna('G'));
    }

    public function testTranscribesThymineToAdenine() : void
    {
        $this->assertSame('A', rnatranscription::toRna('T'));
    }

    public function testTranscribesAdenineToUracil() : void
    {
        $this->assertSame('U', rnatranscription::toRna('A'));
    }

    public function testTranscribesAllOccurencesOne() : void
    {
        $this->assertSame('UGCACCAGAAUU', rnatranscription::toRna('ACGTGGTCTTAA'));
    }
}
