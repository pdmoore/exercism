package HighScoreBoard;

use v5.38;

our %Scores;

sub set_player_scores (%new_scores) {
  %Scores = ( %Scores, %new_scores);
}

sub get_player_score ($player) {
  return %Scores{$player};
}

sub increase_player_scores (%additional_scores) {
  while (my($key, $value) = each %additional_scores) {
    $Scores{$key} += $value;
  }
}

sub sort_players_by_name {
    (sort(keys %Scores))
}

sub sort_players_by_score {
    sort { $Scores{$b} <=> $Scores{$a} } keys %Scores;
}

sub delete_player ($player) {
    delete %Scores{$player};
}
