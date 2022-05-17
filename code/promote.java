public class promote implements Command {
    private final Personnel personnel = Personnel.getInstance();
    public void execute(Employee employee) {
        personnel.promote();
    }
}