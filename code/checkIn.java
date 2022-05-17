public class checkIn implements Command{


    public void execute(Employee e){
        e.getAttendance().checkIn();
    }

    static {
        CommonCommand.getInstance().add("checkIn",new checkIn());
    }
}