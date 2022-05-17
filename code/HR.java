import java.util.*;

public class HR implements Position {
  
    private static HR instance = new HR();
    private HR() {CommandMap = new HashMap<>();}
    public static HR getInstance() {return instance;}
  
    private HashMap<String, Command> CommandMap;

    // public HR(){
      
    //   CommandMap = new HashMap<>();
    //   CommandMap.put("viewDivision", viewDivision.getInstance());
    //   CommandMap.put("viewOrganizationStructure", viewOrganizationStructure.getInstance());
    //   CommandMap.put("viewDepartmentStructure", viewDepartmentStructure.getInstance());
    //   CommandMap.put("addSalary", new addSalary());
    //   CommandMap.put("addScore", new addScore());
    //   CommandMap.put("admit", new admit());
    //   CommandMap.put("resign", new resign());
      
    // }
  
    // protected void addCommand(String commandName, Command command){     
    //   CommandMap.put(commandName, command);
    // }

    public HashMap<String,Command> getCommand(){
      return CommandMap;
    }

    public void add(String name, Command command) {
      CommandMap.put(name, command);
    }
  

}

  