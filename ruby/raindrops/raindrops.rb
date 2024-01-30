=begin
Write your code for the 'Raindrops' exercise in this file. Make the tests in
`raindrops_test.rb` pass.

To get started with TDD, see the `README.md` file in your
`ruby/raindrops` directory.
=end
class Raindrops
  def self.convert(number)
    _result = ""
    _result << "Pling" if number % 3 == 0
    _result << "Plang" if number % 5 == 0
    _result << "Plong" if number % 7 == 0

    _result.empty? ? number.to_s : _result
  end
end