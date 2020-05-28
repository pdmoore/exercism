<?php

class rnatranscription {

    public static function toRna(string $rna): string
    {
        $nucleotides = str_split($rna);
        $result = "";

        foreach ($nucleotides as $char) {
            $result .= rnatranscription::convert($char);
        }
        return $result;
    }

    public static function convert(string $nucleotide) {
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
