fun transcribeToRna(dna: String): String {
    if (dna.isEmpty()) return ""

    when (dna) {
        "C" -> return "G"
        "G" -> return "C"
        "T" -> return "A"
        "A" -> return "U"
    }
    return "oops"
}
