

public class viewDepartmentStructure implements Command {

    private static viewDepartmentStructure instance = new viewDepartmentStructure(); 
    private viewDepartmentStructure() {}
    public static viewDepartmentStructure getInstance(){return instance;}
  
    public void execute(Employee employee) {
        Organization.getInstance().viewDepartmentStructure();
    }

    static {
        HR.getInstance().add("viewDepartmentStructure", instance);
    }
  
}