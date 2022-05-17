public class checkOTHour implements Command{
    private static checkOTHour instance = new checkOTHour();
    private checkOTHour() {}
    public static checkOTHour getInstance() {return instance;}

    public void execute(Employee e) {
        System.out.println(e.getAttendance().getOT());
    }

    static {
        CommonCommand.getInstance().add("checkOTHour", new checkOTHour());
    }
}