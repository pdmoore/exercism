<?php

class rnatranscription {

    public static function toRna(string $rna): string
    {

        //TODO - iterate over whole rna string, converting each character as you go
        $nucleotides = str_split($rna);
        $result = "";

        foreach ($nucleotides as $char) {
            $result .= rnatranscription::convert($char);
        }
        return $result;
    }

    public static function convert(string $rna) {
        switch ($rna) {
            case 'A':
                return 'U';
            case 'C':
                return 'G';
            case 'G':
                return 'C';
            case 'T':
                return 'A';
        }
        return 'bad input';
    }

}
