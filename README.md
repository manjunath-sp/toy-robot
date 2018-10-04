## Design 

The application accepts and input file with the instructions for the toy robot. If no input file is 
supplied as a command line argument the file in the resources file is taken as the default file. 

The application is designed such that any new Commands or business logic can be easily incorporated without much refactoring to the application.
The application is extensible and also testable.  

### Parsing the commands
The file is parsed and the respective commands are created based on the content of the file. 
A command that cannot be be parsed or is an invalid command will be treated as a NullCommand and 
the position of the robot is not impacted by this.

### Executing the commands

The parsed commands is executed by the Robot class which maintains the state (Position) of the robot as each command is executed.
The Robot class returns the state of the Robot for each REPORT command it encounters, provided the Robot has be placed on the table.


### Assumption

A square tabletop, of dimensions 5 units x 5 units.
* There are no other obstructions on the table surface.
* The robot is free to roam around the surface of the table, but must be prevented from falling to destruction - `Only valid moves are considered, others are ignored.`
* Any movement that would result in the robot falling from the table must be prevented, however further valid movement commands must still be allowed. - `Only valid moves are considered, others are ignored.`

Only these commands are considered:
```
PLACE X,Y,F
MOVE
LEFT
RIGHT
REPORT
```


###  Unit testing

I used JUnit 5 for unit testing this application. I did not see the need for using mocks as it is a simple application.

## System Requirements

To run this application you will need java 8 and maven.
This application was built using jdk1.8.0_181 and Apache Maven 3.5.4.

The application can be imported as a maven project into any IDE such as Eclipse/Intellij

## Running the application

Clone the git repository `git@gitlab.com:connect.manjunath/toy-robot.git`

Navigate to the directory where the git repository was cloned and run:

`mvn clean install`

This will run all tests and generate the jar at below location:

`toy-robot/target/toy-robot-simulator-1.0.0.jar`

### Executing the application

#### By supplying file path as command line arguments

`java -jar target/target/toy-robot-simulator-1.0.0.jar absolute_path_to_robot_instruction_file`

for example : `java -jar target/toy-robot-simulator-1.0.0.jar src/main/resources/input-4.txt`

This will generate an out as follows in the console:

```
Sep. 28, 2018 6:26:02 PM org.toyrobot.simulator.utils.FileUtils createFile
INFO: Output file path:/Users/manjunath/Documents/code_challenge/iress/toy-robot/result.txt
Sep. 28, 2018 6:26:02 PM org.toyrobot.simulator.utils.FileUtils createFile
INFO: 3,3,NORTH
Sep. 28, 2018 6:26:02 PM org.toyrobot.simulator.utils.FileUtils createFile
INFO: 3,3,EAST
```

The _**output file path**_ represents the location of the _**result file**_.