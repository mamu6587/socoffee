
_____________________
_____________________
//|||   /||\\  //\\
//|||   /||// //__\\
//|||   /||\\ ||__||
//|||   /|| \\||  ||

How to build
Unzip to desired directory, then use make Trafficsim to compile then follow the steps below to run



Running the traffic sim:
When in the traffic sim dir, run with the command java Simulation a s d f g h j i
where
a = Arrival probability, the chance (out of 10) that a new car will enter the system
s = Turn probability, the chance (out of 10) that a car entering the system will want to enter the turn lane
d = Lane length, the length (in car units) that your entry lane (not counting forward and turn lanes) will cover
f = Turn lane length, the length (in car units) that your turn and forward lanes will cover
g = Traffic light period, how many time units in total (red time + green time) the light cycle will comprise
h = Forward lane light green time, how many time units per period the light will be green
j = Turn lane light green time, see above
i = Simulation run time, how many time units the simulation will run before printing statisticsx


Goals accomplished with this program:
A2
G16
H19


Version history:



Other useful information:

