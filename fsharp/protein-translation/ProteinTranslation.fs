module ProteinTranslation

let translateCodon(rna: string, proteins: list<string>) =
    if "AUG".Equals(rna) then proteins @ ["Methionine"] else proteins

let proteins (rna: string) =
    if rna.Length.Equals(0) then [] else
    
    // lists are immutable - need a new list concated with previous
    // something like pass in codon and list
    // return new list of translated codon
    // BUT how to deal with STOP
    let result = []
    translateCodon(rna[0..2], result)
    
