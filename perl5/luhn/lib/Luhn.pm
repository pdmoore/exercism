package Luhn;

use v5.38;

use Exporter qw<import>;
our @EXPORT_OK = qw<is_luhn_valid>;

sub is_luhn_valid ($number) {
    $number =~ s/ //g;

    return 0 if (length($number) == 1);
    return 0 if ($number =~ m/[^0-9]/);

    my $sum = 0;
    for (my $i = (length $number) - 1; $i >= 0; $i--) {
        my $digit = int(substr($number, $i, 1));
        
        if ((((length $number) - 1) - $i) % 2 == 1) {
            $digit *= 2;
            $digit -= 9 if ($digit > 9);
        }          
        
        $sum += $digit;        
    }
    return $sum % 10 == 0;
}
