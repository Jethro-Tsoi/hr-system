import java.util.*;

public class Employee {

    private String name;
    private Integer id;

    private Payment payment;
    private Attendance attendance;
    private Wealthfare wealthfare;
    private Department department;
    private Role role;
    private Position position;
    private Rating rating;
    private HashMap<String, Command> CommandMap;
    private boolean isForeign;

    private static Integer nextID = 1;

    public Employee(String name, Role role, Department department, int salary, boolean isForeign, int annual/*, Hashmap<String, Command> CommandMap*/){
        this.name = name;
        this.role = role;
        this.department = department;
        this.department.addMember(this);
        position = this.department.getPosition();
        rating = new Rating();
        attendance = new Attendance();
        CommandMap = new HashMap<>();
        CommandMap.putAll(this.role.getCommand());
        CommandMap.putAll(this.position.getCommand());
        id = nextID++;
        payment = new Payment(salary);
        int education = this.role.getWealthfare() / 2;
        int medical = this.role.getWealthfare() / 2;
        int housing = isForeign ? this.role.getWealthfare() / 2 : 0 ;
        wealthfare = new Wealthfare(education, medical, housing, annual);
        this.isForeign = isForeign;
        
        //  Salary ;
        //  Attendence ;
        //  Department ;
        // this.CommandMap = CommandMap;

        //add common functions
        CommandMap.putAll(CommonCommand.getInstance().getCommand());
    }

    public void updateCommandMap() {
        CommandMap.clear();
        CommandMap.putAll(this.role.getCommand());
        CommandMap.putAll(this.position.getCommand());
        CommandMap.putAll(CommonCommand.getInstance().getCommand());
    }

    public boolean tryCommand(String command){
        Command c = CommandMap.get(command);
        if (c != null) {
            c.execute(this);
            return true;
        }
        return false;
    }

    protected Integer getID() {
        return id;
    }

    protected void showPosition() {
        System.out.println("                 "); // fixed space "name          department          role "
    }

    // protected boolean departmentIsHR() {
    //     if( department.getName().equals("HR") )
    //         return true;
    //     return false;
    // }

    protected String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public Role getRole() {
        return role;
    }


    public Payment returnPayment(){
        return payment;
    }

    
    public void checkRating(){
        rating.getScore();
    }

    public void addEducation(int amount){
        wealthfare.AddEducation(amount);
    }

    public void addMedical(int amount){
        wealthfare.AddMedical(amount);
    }
  
    public void addHousing(int amount){
        wealthfare.AddHousing(amount);
    }

    public void addAnnualLeave(int amount){
        wealthfare.AddAnnualLeave(amount);
    }

    public void useEducation(int amount){
        wealthfare.getEducation().use(amount);
    }

    public void useMedical(int amount){
        wealthfare.getMedical().use(amount);
    }

    public void useHousing(int amount){
        wealthfare.getHousing().use(amount);
    }

    public void useAnnualLeave(int amount){
        wealthfare.getAnnualLeave().use(amount);
    }

    public void addScore(int score) {
        rating.addScore(score);
    }

    public void minusScore(int score) {
        rating.minusScore(score);
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void promote(Role newRole) {
        int difference = role.getWealthfare() - newRole.getWealthfare();
        addEducation(difference / 2);
        addMedical(difference / 2);
        if (isForeign) {
            addHousing(difference / 2);
        }
        role = newRole;
        updateCommandMap();
        payment.addSalary(payment.getSalary() / 2);
    }

    public void checkWealthfare() {
        wealthfare.check();
    }

    public Wealthfare getWealthfare() {
        return wealthfare;
    }

    public void printCommand() {
        System.out.println("Commnad list:");
        for (String c:CommandMap.keySet()) {
            System.out.println(c);
        }
    }
}