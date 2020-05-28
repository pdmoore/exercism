<?php

class rnatranscription {

    public static function toRna(string $rna): string {

        //TODO - iterate over whole rna string, converting each character as you go

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
