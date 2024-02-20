module ProteinTranslation
  def self.proteins(strand : String) : Array(String)

   result = [] of String

   strand.chars.in_groups_of(3).each do |codon|
      case codon.join("")
      when "AUG"
        result << "Methionine"
      when "UUU", "UUC"
        result << "Phenylalanine"
      when "UUA", "UUG"
        result << "Leucine"
      when "UCU", "UCC", "UCA", "UCG"
        result << "Serine"
      when "UAU", "UAC"
        result << "Tyrosine"
      when "UGU", "UGC"
        result << "Cysteine"
      when "UGG"
        result << "Tryptophan"
      when "UAA", "UAG", "UGA"
        return result
      else
        raise ArgumentError.new("foo")
      end

    end

    result
  end
end
