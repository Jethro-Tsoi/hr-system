public class resign implements Command {
    // private static resign instance = new resign();

    // private resign() {}

    // public static resign getInstance() {return instance;}
    private final Personnel personnel = Personnel.getInstance();

    public void execute(Employee employee) {
        personnel.resign();
    }

    static {
        Manager.getInstance().add("resign", new resign());
        HR.getInstance().add("resign", new resign());
    }
}