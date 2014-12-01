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
			assert(repoExamin.countInOut("", "")==null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
