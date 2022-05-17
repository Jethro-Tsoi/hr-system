import java.util.*;


public class Organization{

    private static Organization instance = new Organization();

    public static Organization getInstance() {return instance;}

    private HashMap<Integer, Employee> allEmployee;
    private HashMap<String, Department> allDepartments;
    private HashMap<String, Role> allRole;
    // private HashMap<String, Position> allPosition;

    private Organization(){
        allEmployee = new HashMap<Integer, Employee>();
        allDepartments = new HashMap<String, Department>();
        allRole = new HashMap<String, Role>();
    }

    public void printDepartment() {
        for (String name : allDepartments.keySet()) {
            System.out.println(name);
        }
    }

    public Department getDepartment(String name) {
        Department department = allDepartments.get(name);
        if (department == null) {
            department = new Department(name);
            allDepartments.put(department.getName(), department);
        }
        return department;
    }

    public Role getRole(String name) {
        return allRole.get(name);
    }

    public void addRole(String name, Role role) {
        allRole.put(name, role);
    }

    // public void addPosition(String name, Position position) {
    //     allPosition.put(name, position);
    // }

    protected void viewDivision(){

        System.out.println("Please enter the Employee ID search for:");
        Scanner s = new Scanner(System.in);
        Integer id = s.nextInt();
        s.close();
      
        Employee e = allEmployee.get(id);

        if( e == null ) System.out.println("Employee not exist");
        else {
            System.out.println("             ");// fixed space "name          department          role "
            e.showPosition();
        }

    }

    protected void viewOrganizationStructure(){
        
        System.out.println("There are total " + allDepartments.size() + " in the Company");
        for (Department department : allDepartments.values()) {
            System.out.println(department);
        }

    }

    protected void viewDepartmentStructure(){
        
        System.out.println("Which department would you like to look for :");
        Scanner s = new Scanner(System.in);
        String name = s.next();
        s.close();

        boolean NoResult = true;
        Department department = allDepartments.get(name); 
            if (department != null) {
                department.showAllDepartmentMember();                
                NoResult = false;
            }
        
        if(NoResult)System.out.println("No department result");

        }
    
    public Employee getEmployee(int employeeID){
        return allEmployee.get(employeeID);
    }
    
    public void addEmployee(Employee e){
        allEmployee.put(e.getID(), e);
        e.getDepartment().addMember(e);
    }

    public void removeEmployee(int id) {
        Employee e = allEmployee.get(id);
        allEmployee.remove(id);
        e.getDepartment().removeMember(e);
    }

    

}