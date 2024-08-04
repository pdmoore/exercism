_score_by_letter = (
    ("aeioulnrst", 1),
    ("dg", 2),
    ("bcmp", 3),
    ("fhvwy", 4),
    ("k", 5),
    ("jx", 8),
    ("qz", 10)
)

SCORES = {}
for letter, score in _score_by_letter:
    SCORES.update((dict.fromkeys(letter, score)))


def score(word):
    return sum(SCORES[char] for char in word.lower())
