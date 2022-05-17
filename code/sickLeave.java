public class sickLeave implements Command {

    public void execute(Employee e) {
        e.getAttendance().sickLeave();
    }

    static {
        CommonCommand.getInstance().add("sickLeave", new sickLeave());
    }
}