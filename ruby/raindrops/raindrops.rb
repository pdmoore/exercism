=begin
Write your code for the 'Raindrops' exercise in this file. Make the tests in
`raindrops_test.rb` pass.

To get started with TDD, see the `README.md` file in your
`ruby/raindrops` directory.
=end
class Raindrops
  def self.convert(number)
    if number % 3 == 0
      return "Pling"
    end
    if number % 5 == 0
      return "Plang"
    end
    if number % 7 == 0
      return "Plong"
    end
    return number.to_s
  end
end