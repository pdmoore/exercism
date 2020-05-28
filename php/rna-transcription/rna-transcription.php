<?php

class rnatranscription {

    public static function toRna(string $dnaStrand): string
    {
        $nucleotides = str_split($dnaStrand);
        $rnaComplement = "";

        foreach ($nucleotides as $char) {
            $rnaComplement .= rnatranscription::transcribe($char);
        }
        return $rnaComplement;
    }

    public static function transcribe(string $nucleotide) {
        switch ($nucleotide) {
            case 'A':
                return 'U';
            case 'C':
                return 'G';
            case 'G':
                return 'C';
            case 'T':
                return 'A';
        }

        // not sure this is the best approach
        throw new Exception('invalid nucleotide' . $nucleotide);
    }

}
