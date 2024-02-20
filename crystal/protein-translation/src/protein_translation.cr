module ProteinTranslation
  def self.proteins(strand : String) : Array(String)

    result = [] of String
    i = 0
    while i < strand.size
      case strand[i, 3]
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

      i = i + 3
    end

    result
  end
end
