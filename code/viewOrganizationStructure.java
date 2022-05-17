

public class viewOrganizationStructure implements Command {

    private static viewOrganizationStructure instance = new viewOrganizationStructure(); 
    private viewOrganizationStructure() {}
    public static viewOrganizationStructure getInstance(){return instance;}
  
    public void execute(Employee employee) {
        Organization.getInstance().viewOrganizationStructure();
    }

    static {
      HR.getInstance().add("viewOrganizationStructure", viewOrganizationStructure.getInstance());
    }
  
}