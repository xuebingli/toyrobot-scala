# toyrobot-scala

[![CircleCI](https://circleci.com/gh/xuebingli/toyrobot-scala/tree/master.svg?style=svg)](https://circleci.com/gh/xuebingli/toyrobot-scala/tree/master)

The infamous coding challenge in Scala. For a solution in Ruby, see [the toyrobot repo](https://github.com/xuebingli/toyrobot).

This is a simple simulator for a robot placed on a 5x5 board. After the robot is placed on the board, it has coordinates (i.e. `x` and `y`) and faces a certain direction (i.e. `orientation`).

The robot receives command (e.g. `PLACE`, `REPORT` etc.) and is expected to (conditionally) execute the command. Any command that results in the robot falling off board must be ignored.

It is the author's intention to use Scala features (e.g. companion object, option etc.) wherever possible, though the usage may not always lead to the most elegant code.

This program is developed and tested with sbt 0.13.16.

## Dependency
The only optional dependency is [ScalaTest](http://www.scalatest.org/). It is required to run tests in `src/test/scala`.

## Usage
The input should be provided via a plain-text file, with each command on a separate line. See `sample_instructions.txt` for an example.

To run the program with sbt,
```
$ sbt "run sample_instructionsa.txt"
```

Alternatively, the program can be compiled and run directly
```
$ ToyRobot sample_instructions.txt
```

## Testing
To run tests,
```
$ sbt test
```

## Assumptions
* Board size shall not change on the fly
* The robot shall move freely on the board, i.e. no obstacle
* The robot shall preserve itself and silently ignore command that results in falling off the board
* All inputs are in valid format
