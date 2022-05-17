import java.util.Scanner;

public class HRMS {
    private static HRMS instance = new HRMS();

    public static HRMS getInstance() {return instance;}

    private HRMS() {}

    private final Login process = Login.getInstance();
    
    public void start() {
        Employee employee = process.start();
        while (employee == null) {
            employee = process.start();
        }

        // Organization companyOrganzation = Organization.getInstance();

        employee.printCommand();
        System.out.println("Please enter a command:");
        Scanner s = new Scanner(System.in);

        String command = s.nextLine();

        while (!command.equals("logout")){

            if (!employee.tryCommand(command)) {
                System.out.println("Unknown command.");
            }

            // switch(command){

            //     case "view Division":
            //         employee.viewDivision();
            //         break;

            //     case "view organization structure":
            //         employee.viewOrganizationStructure();
            //         break;  

            //     case "view depertment structure":
            //         employee.viewDepartmentStructure();
            //         break;    

            //     case "view score":
            //         employee.checkRating();
            //         break;

            //     case "check salary":
            //         employee.checkSalary();
            //         break;

            //     case "add salary":
            //         employee.addSalary();
            //         break;

            //     case "add bonus":
            //         employee.addBonus();
            //         break;

            //     default:
            //         System.out.println("Not sufficient command");
            //         break;

            System.out.println("Please enter a command:");
            command = s.nextLine();
        }
        s.close();

        System.out.println("Finish");

    }
}