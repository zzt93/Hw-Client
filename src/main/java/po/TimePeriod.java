package po;

import java.io.Serializable;
import java.util.Date;

public class TimePeriod implements Serializable {
	private Date start;
	private Date end;
	private static final long serialVersionUID = 1L;
	public TimePeriod(Date start, Date end) {
		super();
		this.start = start;
		this.end = end;
	}
	public TimePeriod(){
		this(new Date(),new Date());
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	
}
