class SpaceAge
  EARTH_YEAR_IN_SECONDS = 60 * 60 * 24 * 365.25
  def initialize(seconds)
    @seconds = seconds
  end

  YEAR_DURATION_RELATIVE_TO_EARTH = {
    mercury: 0.2408467,
    venus:     0.61519726,
    earth:     1.0,
    mars:      1.8808158,
    jupiter:  11.862615,
    saturn:   29.447498,
    uranus:   84.016846,
    neptune: 164.79132
  }.each do |planet, earth_years|
    define_method :"on_#{planet}" do
      @seconds.fdiv(EARTH_YEAR_IN_SECONDS * earth_years).round(2)
    end
  end
end