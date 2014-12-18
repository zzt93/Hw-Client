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
			assert(repoExamin.countInOut("2014-12-2", "2014-12-16")==null);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
