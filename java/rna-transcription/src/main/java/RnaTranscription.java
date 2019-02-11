class RnaTranscription {

    String transcribe(String dnaStrand) {

        return dnaStrand.chars()
                .mapToObj(x -> transcribeNucleotide((char) x))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    private char transcribeNucleotide(char nucleotide) {
        if (nucleotide == 'C') return 'G';
        else if (nucleotide == 'G') return 'C';
        else if (nucleotide == 'T') return 'A';
        else if (nucleotide == 'A') return 'U';

        return Character.MIN_VALUE;
    }
}
