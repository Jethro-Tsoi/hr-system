import java.util.*;

public class Department {

    private Position position;
    private String name;
    private ArrayList<Employee> employeeOfDepartment;

    public Department(String name){
        if(name.equals("HR")) 
            position = HR.getInstance();
        else 
            position = nonHR.getInstance();
        this.name = name;
        employeeOfDepartment = new ArrayList<>();
    }

    public Position getPosition() {
        return position;
    }

    protected void addMember(Employee e){
        employeeOfDepartment.add(e);
    }

    protected void removeMember(Employee e){
        employeeOfDepartment.remove(e);
    }

    public String getName() {
        return name;
    }

    protected void showAllDepartmentMember() {
        System.out.println("             ");// fixed space "name          department          role "
        for (Employee e : employeeOfDepartment) {
            e.showPosition();
        }
    }

    // protected void viewDivision() {
    //     position.viewDivision();
    // }

    // protected void viewOrganizationStructure() {
    //     position.viewOrganizationStructure();
    // }

    // protected void viewDepartmentStructure() {
    //     position.viewDepartmentStructure();
    // }

}
