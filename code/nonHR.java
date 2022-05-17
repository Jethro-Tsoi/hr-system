import java.util.*;
public class nonHR implements Position{

    private static nonHR instance = new nonHR();
    private nonHR() {CommandMap = new HashMap<>();}
    public static nonHR getInstance() {return instance;}

    private HashMap<String, Command> CommandMap = new HashMap<>();
    // private String name;

    // public nonHR(String name){
    //     this.name = name;
    // }

    // @Override
    // public void viewDivision() {
    //     System.out.println("You have no right to the current option.");
    // }

    // @Override
    // public String getName() {
    //     return name;
    // }

    // @Override
    // public void viewOrganizationStructure() {
    //     System.out.println("You have no right to the current option.");
    // }

    // @Override
    // public void viewDepartmentStructure() {
    //     System.out.println("You have no right to the current option.");
    // }

    
    // public void addSalary(){
    //   System.out.println("You are eligible to apply a raise on salary.");
    // } 

    public HashMap<String,Command> getCommand(){
      return CommandMap;
    }

    public void add(String name, Command command) {
      CommandMap.put(name, command);
    }
}
