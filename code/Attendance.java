import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Attendance {
    private LocalTime onDuty = LocalTime.of(9, 00);
    private LocalTime OT = LocalTime.of(18, 00);
    private LocalTime todayOnDutyTime;

    private ArrayList<LocalDateTime> Absent;
    private ArrayList<LocalDateTime> Attended;
    private ArrayList<LocalDateTime> Late;
    private ArrayList<LocalDateTime> NoPayLeave;
    private ArrayList<LocalDateTime> SickLeave;
    private ArrayList<LocalDateTime> OTrecord;
    
    private int NoPayLeaveAmount;
    private int SickLeaveAmount;
    private int totalWorkingHour;
    private int OTHour;

    public Attendance() {
        this.Absent = new ArrayList<LocalDateTime>();
        this.Attended = new ArrayList<LocalDateTime>();
        this.Late = new ArrayList<LocalDateTime>();
        this.NoPayLeave = new ArrayList<LocalDateTime>();
        this.SickLeave = new ArrayList<LocalDateTime>();
        this.OTrecord = new ArrayList<LocalDateTime>();
        this.NoPayLeaveAmount = 0;
        this.SickLeaveAmount = 0;
        this.totalWorkingHour = 0;
        this.OTHour = 0;
    }

    public Attendance(int NPL, int SL) {
        this.NoPayLeaveAmount = NPL;
        this.SickLeaveAmount = SL;
    }
    
    public void checkIn() {
        todayOnDutyTime = LocalTime.now();
        LocalDateTime now = LocalDateTime.now();

        if (todayOnDutyTime.isAfter(onDuty)) {
            Late.add(now);
        } else {
            Attended.add(now);
        }
    }

    public void checkOut() {
        LocalTime nowTime = LocalTime.now();
        if (nowTime.isAfter(OT)) {
            LocalDateTime now = LocalDateTime.now();
            OTrecord.add(now);
            totalWorkingHour+=ChronoUnit.HOURS.between(todayOnDutyTime,nowTime);
            OTHour+=ChronoUnit.HOURS.between(OT,nowTime);
        } else {
            totalWorkingHour+=ChronoUnit.HOURS.between(todayOnDutyTime,OT);
        }
    }

    public void sickLeave() {
        SickLeaveAmount-=1;
        LocalDateTime now = LocalDateTime.now();
        SickLeave.add(now);
        checkOut();
    }

    public void absentDate (LocalDateTime date) {
        Absent.add(date);
    }

    public void NoPayLeaveDate(LocalDateTime date) {
        NoPayLeave.add(date);
    }

    public void Sick(LocalDateTime date) {
        SickLeave.add(date);
    }

    public void addWorkHour(int hour) {
        this.totalWorkingHour += hour;
    }

    public void OT(int ot) {
        this.OTHour += ot;
    }

    public ArrayList<LocalDateTime> getAbsent() {
        return Absent;
    }
    
    public ArrayList<LocalDateTime> getAttended() {
        return Attended;
    }

    public ArrayList<LocalDateTime> getLate() {
        return Late;
    }

    public ArrayList<LocalDateTime> getNPL() {
        return NoPayLeave;
    }

    public ArrayList<LocalDateTime> getSickLeave() {
        return SickLeave;
    }

    public int getNPLamount() {
        return NoPayLeaveAmount;
    }

    public int getSickLeaveAmount() {
        return SickLeaveAmount;
    }
    
    public int getWorkHour() {
        return totalWorkingHour;
    }

    public int getOT() {
        return OTHour;
    }
}
