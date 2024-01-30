=begin
Write your code for the 'Raindrops' exercise in this file. Make the tests in
`raindrops_test.rb` pass.

To get started with TDD, see the `README.md` file in your
`ruby/raindrops` directory.
=end
class Raindrops
  def self.convert(number)
    _result = ""
    if number % 3 == 0
      _result += "Pling"
    end
    if number % 5 == 0
      _result += "Plang"
    end
    if number % 7 == 0
      _result += "Plong"
    end

    if _result.empty?
      _result = number.to_s
    end
    return _result
  end
end