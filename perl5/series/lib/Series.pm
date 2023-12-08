package Series;

use v5.38;

use Exporter qw<import>;
our @EXPORT_OK = qw<slices>;

sub slices ( $series, $slice_length ) {

    die "series cannot be empty" unless (length($series) > 0);

    die "slice length cannot be zero"  if  ($slice_length == 0);
    die "slice length cannot be negative" if ($slice_length < 0);
    die "slice length cannot be greater than series length" unless ($slice_length <= length($series));

    my @slices;
    for (my $i = 0; $i < length($series) - $slice_length + 1; $i++) {
        push(@slices, substr($series, $i, $slice_length))
    }

    return \@slices;
}
