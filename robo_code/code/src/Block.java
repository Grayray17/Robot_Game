import java.util.*;

public class Block implements RobotProgramNode {

    List<Statement> commands = new ArrayList<>();

    public Block(Scanner scan){
        Parser.require("\\{", "a block must be followed by a { ", scan);
        while(addStatement(scan)){}
        Parser.require("\\}", "a block must be followed by a } ", scan);
    }

public Boolean addStatement(Scanner scan){
if(scan.hasNext(Parser.STATEMENT)){
    this.commands.add(new Statement(scan));
    return true;
}
return false;
}

@Override
public void execute (Robot robot) {
    for(Statement stat : commands){
        stat.execute(robot);
     }
    }
 
public String toString(){
List <String> list = new ArrayList<>();
for(Statement s : commands){
    list.add(s.toString());
}
return String.join(" , " ,list);
 }   
}
    
