package BookingUpForBeauty;

use v5.38;

# Suggested datetime modules you can use:
use Time::Piece;
#use DateTime::Tiny;
#use DateTime::Format::Strptime qw( );

# Recommended, commented out for portability.
#use Readonly;

use Exporter ('import');
our @EXPORT_OK = ('appointment_has_passed', 'is_afternoon_appointment', 'describe_appointment');

my $STRPTIME_FORMAT = '%Y-%m-%d' . 'T' . '%H:%M:%S';
#Readonly::Scalar $STRPTIME_FORMAT => $STRPTIME_FORMAT;

# Private subroutines conventionally start with an underscore.
# It isn't necessary, but provided for convenience.
sub _parse_datetime ($date_string) {
#    return DateTime::Tiny->from_string(Time::Piece->strptime($date_string, $STRPTIME_FORMAT));
    #return DateTime::Tiny->from_string($date_string, $STRPTIME_FORMAT);
    #return $date_string;
    return Time::Piece->strptime($date_string, $STRPTIME_FORMAT);
#    my $format = DateTime::Format::Strptime->new($STRPTIME_FORMAT);
#    return $format->parse_datetime($date_string);
}

sub appointment_has_passed ($date_string) {
    my $time = _parse_datetime($date_string);
    #my $now  = DateTime::Tiny->now;
    #return DateTime->compare($time, $now);
    # parens are necessary, why?
    return ($time < gmtime);
    #return $time < gmtime;

#    my $now = DateTime::Tiny->now;
#    my $diff = $now - $time;
#    return $diff;
}

sub is_afternoon_appointment ($date_string) {
    my $time = _parse_datetime($date_string);
    my $afternoon_start = _parse_datetime('2019-08-09T12:00:00');
    my $afternoon_end   = _parse_datetime('2019-08-09T18:00:00');
    return (($time->hour >= $afternoon_start->hour) and ($time->hour < $afternoon_end->hour));
}

sub describe_appointment ($date_string) {
    my $time = _parse_datetime($date_string);
    my $ampm = $time->hour > 12 ?  'PM' : 'AM';
    my $hour = $time->hour % 12;
    $hour = 12 if $hour == 0;
    return sprintf('You have an appointment on %02d/%02d/%04d %d:%02d %s', ($time->mon), ($time->day_of_month), ($time->year), ($hour), ($time->min), ($ampm));
}
