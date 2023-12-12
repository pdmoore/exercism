fun transcribeToRna(dna: String): String {
    if (dna.isEmpty()) return ""

    var transcription = "";
    for (ch in dna.iterator()) {
        transcription += transcribeDNAnucleotide(ch);
    }

    return transcription;
}

fun transcribeDNAnucleotide(ch: Char): String {
    when (ch) {
        'C' -> return "G"
        'G' -> return "C"
        'T' -> return "A"
        'A' -> return "U"
    }
    return "";
}
