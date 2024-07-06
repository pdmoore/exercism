=begin
Write your code for the 'Space Age' exercise in this file. Make the tests in
`space_age_test.rb` pass.

To get started with TDD, see the `README.md` file in your
`ruby/space-age` directory.
=end
class SpaceAge

  def initialize(seconds)
    @seconds = seconds
  end

  def on_earth
    return @seconds / 31_557_600.0
  end

end