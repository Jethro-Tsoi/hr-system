public class printCommand implements Command {
    private static printCommand instance = new printCommand();
    private printCommand() {};
    public static printCommand getInstance() {return instance;}

    public void execute(Employee employee) {
        employee.printCommand();
    }
}