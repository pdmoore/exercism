module ProteinTranslation
  def self.proteins(strand : String) : Array(String)

   result = [] of String

   strand.chars.in_groups_of(3).each do |codon|
      case codon.join("")
      when "AUG"        then result << "Methionine"
      when "UUC", "UUU" then result << "Phenylalanine"
      when "UUA", "UUG" then result << "Leucine"
      when "UCA", "UCC",
           "UCG", "UCU" then result << "Serine"
      when "UAC", "UAU" then result << "Tyrosine"
      when "UGC", "UGU" then result << "Cysteine"
      when "UGG"        then result << "Tryptophan"
      when "UAA", "UAG",
           "UGA"        then break
      else
        raise ArgumentError.new("Unknown codon {codon}")
      end
    end

    result
  end
end
