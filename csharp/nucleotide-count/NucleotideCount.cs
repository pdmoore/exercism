using System;
using System.Collections.Generic;

public class NucleotideCount {
    private Dictionary<char, int> empty = new Dictionary<char, int> {
        ['A'] = 0,
        ['C'] = 0,
        ['G'] = 0,
        ['T'] = 0
    };

    public NucleotideCount(string sequence) {
    }

    public IDictionary<char, int> NucleotideCounts => empty;
}