import java.util.Scanner;

public class Action implements RobotProgramNode {
    enum actionType {

        move {
            @Override
            public void execute(Robot robot) {
                robot.move();
            }
        },
        turnL {
            @Override
            public void execute(Robot robot) {
                robot.turnLeft();
            }
        },
        turnR {
            @Override
            public void execute(Robot robot) {
                robot.turnRight();
            }
        },
        takeFuel {
            @Override
            public void execute(Robot robot) {
                robot.takeFuel();
            }
        },
        turnAround {
            @Override
            public void execute(Robot robot) {
                robot.turnAround();
            }
        };

        public void execute(Robot robot) {

        }
    }

    actionType token;

    public void Action(Scanner scan) {
        String next = scan.next();
        if (next.equals("move")) {
            this.token = actionType.move;
        } else if (next.equals("TurnLeft")) {
            this.token = actionType.turnL;
        } else if (next.equals("TurnRight")) {
            this.token = actionType.turnR;
        } else if (next.equals("TakeFuel")) {
            this.token = actionType.takeFuel;
        } else {
            Parser.fail("Invalid Action; ", scan);
        }
        Parser.require(";", "actions must be followed by ; ", scan);
    }

    @Override
    public void execute(Robot robot) {
        // TODO Auto-generated method stub
 
    }
}
