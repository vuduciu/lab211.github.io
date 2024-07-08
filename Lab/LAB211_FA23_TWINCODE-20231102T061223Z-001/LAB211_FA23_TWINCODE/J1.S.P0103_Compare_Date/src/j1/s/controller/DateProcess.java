package j1.s.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateProcess {
    public String getDayOfWeek(Date givenDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
        return dateFormat.format(givenDate);
    }
    
    public int compareDate(Date firstDate,Date secondDate){
        if(firstDate.after(secondDate)){
            return 1;
        }else if(firstDate.before(secondDate)){
            return -1;
        }
        return 0;
    }
    
}