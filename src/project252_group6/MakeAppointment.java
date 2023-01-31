
package project252_group6;
import java.util.ArrayList;

public class MakeAppointment {
    private AppointmentInterface s;
    private AppointmentInterface r;
    private AppointmentInterface c;
    
    public MakeAppointment() {
        s = new Schedule();
        r = new Reschedule();
        c = new Cancel();
        
    }
    
    public void scheduleAppointment(){
        s.service();
    }

    public void rescheduleAppointment(){
        r.service();
    
    }
    
    
    public void cancelAppointment(){
        c.service();
    }
}
