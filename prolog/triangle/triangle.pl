triangle(Side1, Side2, Side3, _) :- Side1 = 0, Side2 = 0, Side3 = 0, !, fail.

triangle(Side1, Side2, Side3, _) :- Side1 + Side2 < Side3, !, fail.
triangle(Side1, Side2, Side3, _) :- Side2 + Side3 < Side1, !, fail.
triangle(Side1, Side2, Side3, _) :- Side3 + Side1 < Side2, !, fail.

triangle(Side1, Side2, Side3, Type) :- Type = "equilateral", Side1 = Side2, Side2 = Side3, !.
triangle(Side1, Side2, Side3, Type) :- Type = "scalene", Side1 \= Side2, Side2 \= Side3, Side2 \= Side1, !.
triangle(Side, Side, _, Type) :- Type = "isosceles", !.
triangle(Side, _, Side, Type) :- Type = "isosceles", !.
triangle(_, Side, Side, Type) :- Type = "isosceles", !.