import java.util.Scanner;

public class Loop implements RobotProgramNode {

    Block token; 
    public Loop (Scanner scan){
        Parser.require("loop", "loop must come first", scan);
        this.token = new Block(scan);
    }

    @Override
    public void execute (Robot robot) {
        //TODO Auto-generated method sub
        while(true){
            token.execute(robot);
        }
    }

    public String toString(){
        return "loop" + token.toString();
    }
}


