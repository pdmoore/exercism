package LanguageList;

use v5.38;

our @Languages;

sub add_language ($language) {
    push @Languages, $language;
}

sub remove_language () {
    pop @Languages;
}

sub first_language () {
    $Languages[0];
}

sub last_language () {
    $Languages[-1];
}

sub get_languages (@elements) {
    # elements passed in are 1 based, map to 0 based to access contents
    @Languages[map{ $_ - 1 } @elements];
}

sub has_language ($language) {
    grep( /^$language$/, @Languages);
}
