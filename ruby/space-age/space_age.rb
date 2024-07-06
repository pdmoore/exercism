class SpaceAge
  def initialize(seconds)
    @earth_age = seconds / (60 * 60 * 24 * 365.25)
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

  def on_jupiter
    @earth_age / 11.862615# code here
  end

  def on_uranus
    @earth_age / 84.016846# code here
  end

  def on_neptune
    @earth_age / 164.79132# code here
  end
end