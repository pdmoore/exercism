using System;
using System.Collections.Generic;

public class NucleotideCount {
    private readonly Dictionary<char, int> countByNucleotide = new Dictionary<char, int> {
        ['A'] = 0,
        ['C'] = 0,
        ['G'] = 0,
        ['T'] = 0
    };

    public NucleotideCount(string sequence) {
        foreach (var nucleotide in sequence) {
            if (!countByNucleotide.ContainsKey(nucleotide)) {
                throw new ArgumentException();
            }
            countByNucleotide[nucleotide] += 1;
        }
    }

    public IDictionary<char, int> NucleotideCounts => countByNucleotide;
}