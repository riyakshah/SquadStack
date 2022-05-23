
About the project
--------------------

This is an object-oriented architecture for a parking lot system that assigns a spot to each automobile when it enters the lot.
Cars are assigned to the nearest empty slot.

Features
-------------------

createParking(int slots)  - Create Parking system with given number of slots
park(String registration_number,int age) - Creates car object, finds the nearest empty slot ans assigns to the car
printTicket(String registration_number,int allocated_slot) - It prints to console (to emulate real life print ticket function)
getSlotNumbersByAge(int age) - prints all the slot numbers corresponding to the drivr age of the car parked there 
getSlotByRegNum(String registration_number) - prints slot number of the car parked whose registration number is given
getRegNumbersByAge(int age) - prints all the car's registration number corresponding to specified driver age
getCarBySlot(int slot) - return Car which is parked currently in given slot
leave(int allocated_slot) - release the slot corresponding to the car which left

Assumptions
--------------------

Parking lot can be craeted of at max 1000 slots.
All registartion numbers are of 13 digit and drivers age is between 1 to 1000.
There would be only one obejct creation possile for parking class (Used singleton design pattern to implement it) and if user will try to create 2 parking lots it will print invalid command and then will continue with other code
The code will run correctly only if user enters correct command.
If user gives wrong input command it will print invalid command and continue with other part of the program except for the fisrt command
(for creating parking lot) which must be correct from user otherwise it will print the error and terminate the program.
All cars will have distinct registration numbers.
If in any of the query, output is of size 0, then it will not print anything in the console and will go to the next command.
The slot that is provided by user while leaving is correct.


Design
--------------------

There are 3 classes in total.
1) Main class - Reading input file from this class
2) Car.java - Car class has attributes named registration_number, age and allocated_slot
3) Parking - This has all the functionalities related to allotment, releasing of slots and also for fetching of required information.

Singleton design pattern have been implemented on Parking class because only one object of this class needs to be craeted.

***Important: While giving input in file take extreme care of spaces and extra lines. Even if there is one more space after the command it will give invalid command. So take care while copy pasting command.Typing input is preferable than copy pasting it from previous inputs.

