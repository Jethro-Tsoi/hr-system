public class checkTotalWorkingHour implements Command {
    private static checkTotalWorkingHour instance = new checkTotalWorkingHour(); 
    private checkTotalWorkingHour() {}
    public static checkTotalWorkingHour getInstance(){return instance;}
	
	public void execute(Employee e) {
		e.getAttendance().getWorkHour();
	}

    static {
        CommonCommand.getInstance().add("checkTotalWorkingHour", new checkTotalWorkingHour());
    }
}