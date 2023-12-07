package Gigasecond;

use v5.38;

use Time::Piece;

use Exporter qw<import>;
our @EXPORT_OK = qw<add_gigasecond>;

my $STRPTIME_FORMAT = "%Y-%m-%dT%H:%M:%S";

sub add_gigasecond ($time) {
    my $t = Time::Piece->strptime($time, $STRPTIME_FORMAT);
    $t += 1_000_000_000;
    return $t->strftime($STRPTIME_FORMAT);
}

