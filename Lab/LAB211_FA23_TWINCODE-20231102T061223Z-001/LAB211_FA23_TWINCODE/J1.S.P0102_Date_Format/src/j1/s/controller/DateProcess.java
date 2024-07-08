package j1.s.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateProcess {
    public String getDayOfWeek(Date givenDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
        return dateFormat.format(givenDate);
    }
    
}