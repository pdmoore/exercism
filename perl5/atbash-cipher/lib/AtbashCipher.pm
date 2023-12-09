package AtbashCipher;

use v5.38;

use Exporter qw<import>;
our @EXPORT_OK = qw<encode_atbash decode_atbash>;

sub encode_atbash ($phrase) {

    ## abcdefghijklm nopqrstuvwxyz
    ## zyxwvutsrqpon mlkjihgfedcba

    $phrase = lc($phrase);
    $phrase =~ s/[\s,.\?!]//g;
    my $encoded = '';
    my $i = 0;
    foreach my $char (split('', $phrase)) {
        if ($i % 5 == 0 && $i != 0) {
            $encoded .= ' ';
        }
        $i++;        

        if ($char =~ /\d/g) {
            $encoded .= $char;
        } else {
            $encoded .= chr(ord('z') - (ord($char) - ord('a')));
        }
    }
    return $encoded;

}

sub decode_atbash ($phrase) {
    $phrase = lc($phrase);
    $phrase =~ s/[\s]//g;
    
    my $decoded = '';
    foreach my $char (split('', $phrase)) {
        if ($char =~ /\d/g) {
            $decoded .= $char;
        } else {
            $decoded .= chr(ord('z') - (ord($char) - ord('a')));
        }
    }

    return $decoded
}

