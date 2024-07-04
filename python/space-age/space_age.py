class SpaceAge:
    def __init__(self, seconds):
        self.seconds = seconds

    def on_earth(self):
        return round(self.earth_years(), 2)

    def on_mercury(self):
        return round(self.earth_years() / 0.2408467, 2)

    def on_venus(self):
        return round(self.earth_years() / 0.61519726, 2)

    def earth_years(self):
        return self.seconds / 31557600

    def on_mars(self):
        return round(self.earth_years() / 1.8808158, 2)
