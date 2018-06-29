eval(ge, X, X).
eval(ge, X, V) :- eval(gt, X, V) .
eval(le, X, X).
eval(le, X, V) :-  eval(lt, X, V).
evalCondition(start):- curTemperatureValue(TEMP), eval(lt, TEMP, 25),curTimeValue(TIME),  eval(ge, TIME, 15),eval(le,TIME,17).
evalCondition(halt) :- curTemperatureValue(TEMP), limitTemperatureValue(MAX), eval(ge, TEMP, MAX).
evalCondition(halt) :- curTimeValue(TIME), limitTimeValue(MIN, _), eval(lt, TIME, MIN).
evalCondition(halt) :- curTimeValue(TIME), limitTimeValue(_, MAX), eval(gt, TIME, MAX).
aTheoryInit :- output("initializing the robotCleanerTheory ...").
initialization(aTheoryInit).