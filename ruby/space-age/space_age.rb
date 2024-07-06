=begin
Write your code for the 'Space Age' exercise in this file. Make the tests in
`space_age_test.rb` pass.

To get started with TDD, see the `README.md` file in your
`ruby/space-age` directory.
=end
class SpaceAge

  def initialize(seconds)
    @earth_age = seconds / 31_557_600.0
  end

  def on_earth
    @earth_age
  end

  def on_mercury
    @earth_age / 0.2408467
  end

  def on_venus
    @earth_age / 0.61519726# code here
  end

  def on_mars
    @earth_age / 1.8808158 # code here
  end

  def on_saturn
    @earth_age / 29.447498# code here
  end

end