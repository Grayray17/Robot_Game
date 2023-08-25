import java.util.Scanner;

public class Statement implements RobotProgramNode{

    RobotProgramNode Token ;

    public Statement(Scanner scan){
        if(scan.hasNext(Parser.ACTION)){
            this.Token = new Action();
        }
        else if(scan.hasNext(Parser.LOOPS)){
            this.Token = new Loop(scan);
        }
        else{
            Parser.fail("Invalid Pattern", scan);
        }
    }
@Override 
public void execute (Robot robot){
    Token.execute(robot);

}

public String toString() {
return Token.toString();
}









}