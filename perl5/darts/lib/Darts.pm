package Darts;

use v5.38;

use Exporter qw<import>;
our @EXPORT_OK = qw<score_dart>;

sub score_dart ( $x, $y ) {
    my $distance_from_center = sqrt($x**2 + $y**2);

    return 0 if ($distance_from_center > 10);
    return 1 if ($distance_from_center > 5);
    return 5 if ($distance_from_center > 1);
    return 10;
}
