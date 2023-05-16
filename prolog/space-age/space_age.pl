orbital_period("Earth", 1.0).
space_age("Earth", AgeSec, Years) :-
    earth_year_in_seconds(S),
    orbital_period("Earth", OP),
    Years = (AgeSec / OP / S).
space_age("Mercury", AgeSec, Years) :- Years = (AgeSec / 31557600) / 0.2408467. 
space_age("Venus", AgeSec, Years) :- Years = (AgeSec / 31557600) / 0.61519726.
space_age("Mars", AgeSec, Years) :- Years = (AgeSec / 31557600) / 1.8808158.
space_age("Jupiter", AgeSec, Years) :- Years = (AgeSec / 31557600) / 11.862615.
space_age("Saturn", AgeSec, Years) :- Years = (AgeSec / 31557600) / 29.447498.
space_age("Uranus", AgeSec, Years) :- Years = (AgeSec / 31557600) / 84.016846.
space_age("Neptune", AgeSec, Years) :- Years = (AgeSec / 31557600) / 164.79132.
earth_year_in_seconds(31557600).
