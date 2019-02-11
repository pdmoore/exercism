import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

class ProteinTranslator {

    private Map<String, String> codon2peptide;
    private List<String> stopCodons;

    private static final String CYSTEINE      = "Cysteine";
    private static final String LEUCINE       = "Leucine";
    private static final String METHIONINE    = "Methionine";
    private static final String PHENYLALANINE = "Phenylalanine";
    private static final String SERINE        = "Serine";
    private static final String TRYPTOPHAN    = "Tryptophan";
    private static final String TYROSINE      = "Tyrosine";

    public ProteinTranslator() {
        codon2peptide = new HashMap<>();
        codon2peptide.put("AUG", METHIONINE);
        codon2peptide.put("UAC", TYROSINE);
        codon2peptide.put("UAU", TYROSINE);
        codon2peptide.put("UCA", SERINE);
        codon2peptide.put("UCC", SERINE);
        codon2peptide.put("UCG", SERINE);
        codon2peptide.put("UCU", SERINE);
        codon2peptide.put("UGC", CYSTEINE);
        codon2peptide.put("UGG", TRYPTOPHAN);
        codon2peptide.put("UGU", CYSTEINE);
        codon2peptide.put("UUA", LEUCINE);
        codon2peptide.put("UUC", PHENYLALANINE);
        codon2peptide.put("UUG", LEUCINE);
        codon2peptide.put("UUU", PHENYLALANINE);

        stopCodons = new ArrayList<>();
        stopCodons.add("UAA");
        stopCodons.add("UAG");
        stopCodons.add("UGA");
    }

    List<String> translate(String rnaSequence) {
        List<String> proteins = new ArrayList<>();

        recurseTranslate(rnaSequence, proteins);

        return proteins;
    }

    private void recurseTranslate(String rnaSequence, List<String> proteins) {
        if (rnaSequence.isEmpty()) return;

        String nextCodon = rnaSequence.substring(0, 3);
        if (stopCodons.contains(nextCodon)) return;

        String protein = codon2peptide.get(nextCodon);
        proteins.add(protein);

        recurseTranslate(rnaSequence.substring(3), proteins);
    }
}
