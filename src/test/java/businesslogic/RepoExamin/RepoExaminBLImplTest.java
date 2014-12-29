package businesslogic.RepoExamin;

import businesslogic.RepositoryExaminbl.RepoExaminBLImpl;
import org.junit.Before;
import org.junit.Test;

public class RepoExaminBLImplTest {

	RepoExaminBLImpl repoExamin;
	@Before
	public void setUp() throws Exception {
		repoExamin = new RepoExaminBLImpl();
	}

	@Test
	public void test() {
		try {
			/* end time is early */
			assert(repoExamin.countInOut("2014-12-2", "2014-12-16")==null);
			// normal condition
			assert (repoExamin.countInOut("2014-12-16", "2015-1-1") == null);
			// start later than end
			assert (repoExamin.countInOut("2015-12-16", "2015-1-1") == null);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
