package businesslogic.Strategybl;
import static org.junit.Assert.*;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Test;


import businesslogic.Strategybl.StrategyController;

public class Strategy_test {

	StrategyController sl;
	@Before
	public void setUp() throws Exception {
		sl = new StrategyController();
	}

	@Test
	public <T> void test() {
		assertThat("test ", 0, new BaseMatcher<Integer>() {

			public boolean matches(Object arg0) {
				// TODO Auto-generated method stub
				return false;
			}

			public void describeTo(Description arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
