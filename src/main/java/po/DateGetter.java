package po;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateGetter implements Serializable {
	Date date;
	Calendar cal;
	
	public String toString(){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		cal = Calendar.getInstance();
		date = cal.getTime();
		return df.format(date);
	}
}
