module ProteinTranslation
  def self.proteins(strand : String) : Array(String)

   result = [] of String

   strand.chars.in_groups_of(3).each do |codon|
      result << case codon.join("")
      when "AUG"        then "Methionine"
      when "UUC", "UUU" then "Phenylalanine"
      when "UUA", "UUG" then "Leucine"
      when "UCA", "UCC",
           "UCG", "UCU" then "Serine"
      when "UAC", "UAU" then "Tyrosine"
      when "UGC", "UGU" then "Cysteine"
      when "UGG"        then "Tryptophan"
      when "UAA", "UAG",
           "UGA"        then break
      else
        raise ArgumentError.new("Unknown codon {codon}")
      end
    end

    result
  end
end
