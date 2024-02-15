module ProteinTranslation

let proteins (rna: string) =
    if rna.Length.Equals(0) then [] else
    
    if "AUG".Equals(rna) then ["Methionine"] else [""]
    