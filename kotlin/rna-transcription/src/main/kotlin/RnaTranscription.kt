fun transcribeToRna(dna: String): String = dna.map {
        transcribeDNAnucleotide(it)
    }.joinToString("")

fun transcribeDNAnucleotide(nucleotide: Char): String {
    when (nucleotide) {
        'C' -> return "G"
        'G' -> return "C"
        'T' -> return "A"
        'A' -> return "U"
    }
    return "";
}
