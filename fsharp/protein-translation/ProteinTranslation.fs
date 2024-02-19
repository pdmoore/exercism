module ProteinTranslation

let proteins (rna: string): string list =
    let doProteins (rna: string): (string * string) option =
        match rna[0..2] with
        | "AUG" -> Some ("Methionine",  rna[3..])
        | "" -> None
        | _ -> failwith "Unknown coding"
        
    List.unfold doProteins rna