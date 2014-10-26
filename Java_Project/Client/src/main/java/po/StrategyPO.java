package po;

import businesslogic.Strategybl.Condition;
import businesslogic.Strategybl.TimePeriod;
import businesslogic.Strategybl.Treatment;


public class StrategyPO {
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
