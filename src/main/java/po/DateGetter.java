package po;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateGetter {
	Date date;
	Calendar cal;
	
	public String toString(){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		date = cal.getTime();
		return df.format(date);
	}
}
