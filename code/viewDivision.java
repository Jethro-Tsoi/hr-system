
public class viewDivision implements Command {

    private static viewDivision instance = new viewDivision(); 
    private viewDivision() {}
    public static viewDivision getInstance(){return instance;}
  
    public void execute(Employee employee) {
        Organization.getInstance().viewDivision();
    }

    static {
      HR.getInstance().add("viewDivision", viewDivision.getInstance());
    }
  
}