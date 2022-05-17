public class checkNPLamount implements Command {
    private static checkNPLamount instance = new checkNPLamount();
    private checkNPLamount() {}
    public static checkNPLamount getInstance() {return instance;}

    public void execute(Employee e) {
        System.out.println(e.getAttendance().getNPLamount());
    }

    static {
        CommonCommand.getInstance().add("checkNPLamount", new checkNPLamount());
    }
}