import java.util.*;

public class Personnel {

    private static Personnel instance = new Personnel();

    private Personnel() {}

    public static Personnel getInstance() {return instance;}

    public void admit() {
        Scanner s = new Scanner(System.in);
        System.out.println("Admitting new employee:");
        System.out.print("name: ");
        String name = s.nextLine();
        System.out.println("Existing departments:");
        Organization.getInstance().printDepartment();
        System.out.print("department: ");
        String departmentString = s.nextLine();
        System.out.print("role: ");
        String roleString = s.nextLine();
        System.out.print("salary: ");
        int salary = s.nextInt();
        System.out.print("annual leave: ");
        int annual = s.nextInt();
        System.out.print("Is the new employee from foreign country? (yes/no): ");
        String foreign = s.nextLine();
        while (!foreign.equals("yes") && !foreign.equals("no")) {
            System.out.print("Is the new employee from foreign country? (yes/no): ");
            foreign = s.nextLine();
        }
        s.close();
        Department department = Organization.getInstance().getDepartment(departmentString);
        Role role = Organization.getInstance().getRole(roleString);
        if (role == null) {
            System.out.println("Failed to admit new employee.");
            System.out.println("Role not found.");
        } else if (salary < 0 || annual < 0) {
            System.out.println("Failed to admit new employee.");
            System.out.println("Invalid numeric input.");
        } else {
            boolean isForeign = foreign.equals("yes");
            Employee employee = new Employee(name, role, department, salary, isForeign, annual);
            if (Login.getInstance().newEntry(employee.getID())) {
                System.out.println("Admitted new employee successfully.");
                Organization.getInstance().addEmployee(employee);
            }
        }
    }

    public void resign() {
        Scanner s = new Scanner(System.in);
        System.out.println("Resigning employee");
        System.out.print("id: ");
        int id = s.nextInt();
        System.out.print("Type 'yes' to confirm the resignation: ");
        String confirm = s.nextLine();
        s.close();
        if (!confirm.equals("yes")) {
            System.out.println("Cancelled the resignation.");
        } else if (!Login.getInstance().removeEntry(id)) {
            System.out.println("Failed to resign employee.");
            System.out.println("Employee not found.");
        } else {
            Organization.getInstance().removeEmployee(id);
            System.out.println("Resigned new employee successfully.");
        }
    }

    public void promote() {
        Scanner s = new Scanner(System.in);
        System.out.println("Promoting employee");
        System.out.print("id: ");
        int id = s.nextInt();
        System.out.print("His/Her new role: ");
        String newRoleString = s.nextLine();
        s.close();
        Organization organization = Organization.getInstance();
        Employee employee = organization.getEmployee(id);
        Role newRole = organization.getRole(newRoleString);
        if (employee == null) {
            System.out.println("Employee not found.");
        } else if (newRole == null) {
            System.out.println("Role not found.");
        } else if (employee.getRole() == newRole) {
            System.out.println("Original role is the same as new role.");
        } else if (employee.getRole().getWealthfare() > newRole.getWealthfare()) {
            System.out.println("New role is a lower rank role.");
        } else {
            System.out.println("Promoted employee successfully.");
            employee.promote(newRole);
        }
    }

}