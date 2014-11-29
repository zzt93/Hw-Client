package businesslogic.RepoExamin;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businesslogic.RepositoryExaminbl.RepoExaminBLImpl;

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
