module ProteinTranslation

let proteins (rna: string): string list =
    let codonToProtein (rna: string): (string * string) option =
        match rna[0..2] with
        | "AUG" -> Some ("Methionine",  rna[3..])
        | "UAC" | "UAU" -> Some ("Tyrosine", rna[3..])
        | "UCA" | "UCC" | "UCG" | "UCU" -> Some ("Serine", rna[3..])
        | "UGC" | "UGU" -> Some ("Cysteine", rna[3..])
        | "UGG" -> Some("Tryptophan", rna[3..])
        | "UUA" | "UUG" -> Some ("Leucine", rna[3..])
        | "UUU" | "UUC" -> Some ("Phenylalanine", rna[3..])
        | "UAA" | "UAG" | "UGA" | "" -> None
        | _ -> failwith "Unknown coding"
        
    List.unfold codonToProtein rna