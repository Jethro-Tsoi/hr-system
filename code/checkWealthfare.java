public class checkWealthfare implements Command {
    private static checkWealthfare instance = new checkWealthfare();
    private checkWealthfare() {}
    public static checkWealthfare getInstance() {return instance;}

    public void execute(Employee employee) {
        employee.checkWealthfare();
    }

    static {
        CommonCommand.getInstance().add("checkWealthfare", new checkWealthfare());
    }
}