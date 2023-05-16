space_age("Earth", AgeSec, Years) :- Years = AgeSec / 31557600.
space_age("Mercury", AgeSec, Years) :- Years = (AgeSec / 31557600) / 0.2408467. 
space_age(Planet, AgeSec, Years).
