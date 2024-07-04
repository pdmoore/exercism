class SpaceAge:
    def __init__(self, seconds):
        self.seconds = seconds

    def on_earth(self):
        return round(self.seconds / 31557600, 2)

    def on_mercury(self):
        return round((self.seconds / 31557600) / 0.2408467, 2)
