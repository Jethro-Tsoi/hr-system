public class changePassword implements Command {

    // private static changePassword instance = new changePassword();

    // private changePassword() {}

    // public static changePassword getInstance() {return instance;}
    private final Login login = Login.getInstance();

    public void execute(Employee employee) {
        login.changePassword(employee.getID());
        
    }

    static {
        CommonCommand.getInstance().add("changePassword", new changePassword());
    }
}