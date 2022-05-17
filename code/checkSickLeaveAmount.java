public class checkSickLeaveAmount implements Command{
    private static checkSickLeaveAmount instance = new checkSickLeaveAmount(); 
    private checkSickLeaveAmount() {}
    public static checkSickLeaveAmount getInstance(){return instance;}

    public void execute(Employee e) {
        System.out.println(e.getAttendance().getSickLeaveAmount());
    }

    static {
        CommonCommand.getInstance().add("checkSickLeaveAmount", new checkSickLeaveAmount());
    }
}