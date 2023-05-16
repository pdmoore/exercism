space_age("Earth", AgeSec, Years) :- Years = AgeSec / 31557600.
space_age("Mercury", AgeSec, Years) :- Years = (AgeSec / 31557600) / 0.2408467. 
space_age("Venus", AgeSec, Years) :- Years = (AgeSec / 31557600) / 0.61519726.
space_age("Mars", AgeSec, Years) :- Years = (AgeSec / 31557600) / 1.8808158.
space_age("Jupiter", AgeSec, Years) :- Years = (AgeSec / 31557600) / 11.862615.
space_age("Saturn", AgeSec, Years) :- Years = (AgeSec / 31557600) / 29.447498.
space_age("Uranus", AgeSec, Years) :- Years = (AgeSec / 31557600) / 84.016846.
