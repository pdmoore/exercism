module ProteinTranslation
  def self.proteins(strand : String) : Array(String)

   result = [] of String

   strand.chars.in_groups_of(3).each do |codon|
      case codon.join("")
      when "AUG"        then result << "Methionine"
      when "UUU", "UUC" then result << "Phenylalanine"
      when "UUA", "UUG" then result << "Leucine"
      when "UCU", "UCC", 
           "UCA", "UCG" then result << "Serine"
      when "UAU", "UAC" then result << "Tyrosine"
      when "UGU", "UGC" then result << "Cysteine"
      when "UGG"        then result << "Tryptophan"
      when "UAA", "UAG", "UGA" then return result
      else
        raise ArgumentError.new("foo")
      end

    end

    result
  end
end
