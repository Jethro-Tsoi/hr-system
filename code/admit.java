public class admit implements Command {

    private final Personnel personnel = Personnel.getInstance();

    public void execute(Employee employee) {
        personnel.admit();
    }

    static {
        Manager.getInstance().add("admit", new admit());
        HR.getInstance().add("admit", new admit());
    }
}