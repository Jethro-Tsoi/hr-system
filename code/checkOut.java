public class checkOut implements Command{


    public void execute(Employee e){
        e.getAttendance().checkOut();
    }

    static {
        CommonCommand.getInstance().add("checkOut", new checkOut());
    }
}