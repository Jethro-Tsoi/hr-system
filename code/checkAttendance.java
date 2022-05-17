import java.time.*;
import java.util.Scanner;

public class checkAttendance implements Command{
    private static checkAttendance instance = new checkAttendance();
    private checkAttendance() {}
    public static checkAttendance getInstance() {return instance;}

    @Override
    public void execute(Employee e) {
        System.out.println("What do you want to check?");
        System.out.println("1 for on duty date.");
        System.out.println("2 for absent date.");
        System.out.println("3 for late come date.");
        System.out.println("4 for no pay leave date.");
        System.out.println("5 for sick leave date.");

        Scanner s = new Scanner(System.in);
        int choice = 1;
        
        do {
            System.out.println("Your choice: ");
            choice = s.nextInt();
        
            switch(choice) {
                case 1 :
                    System.out.println("On duty date:");
                    for (LocalDateTime date:e.getAttendance().getAttended()) {
                        System.out.println(date);
                    }
                    break;
                case 2 :
                    System.out.println("Absent date:");
                    for (LocalDateTime date:e.getAttendance().getAbsent()) {
                        System.out.println(date);
                    }
                    break;
                case 3 :
                    System.out.println("Late date:");
                    for (LocalDateTime date:e.getAttendance().getLate()) {
                        System.out.println(date);
                    }
                    break;
                case 4:
                    System.out.println("No pay leave date:");
                    for (LocalDateTime date:e.getAttendance().getNPL()) {
                        System.out.println(date);
                    }
                    break;
                case 5:
                    System.out.println("Sick leave date:");
                    for (LocalDateTime date:e.getAttendance().getSickLeave()) {
                        System.out.println(date);
                    }
                    break;
            }

            System.out.println("Unknown choice. Please input again.");

        } while (choice>5 || choice<1);
        
        s.close();
    }

    static {
        CommonCommand.getInstance().add("checkAttendance", new checkAttendance());
    }
}