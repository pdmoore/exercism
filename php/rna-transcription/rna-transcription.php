<?php

class rnatranscription {

    public static function toRna(string $rna): string {
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
