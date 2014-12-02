package po;

import java.io.Serializable;

/**
 * 
 * @author Mebleyev.G.Longinus
 *
 */


public class StrategyPO implements Serializable {
	public StrategyPO(Condition condition, Treatment treatment,
			TimePeriod timePeriod) {
		super();
		this.condition = condition;
		this.treatment = treatment;
		this.timePeriod = timePeriod;
	}
	Condition condition;
	Treatment treatment;
	TimePeriod timePeriod;
	
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	public Treatment getTreatment() {
		return treatment;
	}
	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}
	public TimePeriod getTimePeriod() {
		return timePeriod;
	}
	public void setTimePeriod(TimePeriod timePeriod) {
		this.timePeriod = timePeriod;
	}

}
