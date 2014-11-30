package businesslogic.RepoCheck;

import businesslogic.GoodsListbl.GL_manager_repo_Impl;
import businesslogic.RepositoryCheckbl.RepoCheckBLImpl;
import businesslogicservice.GoodsListblservice.GL_repo_BLservice;
import org.junit.Before;
import org.junit.Test;

public class RepoCheckBLImplTest {

	RepoCheckBLImpl repoCheck;
	@Before
	public void setUp() throws Exception {
		GL_repo_BLservice repo = new GL_manager_repo_Impl();
		repoCheck = new RepoCheckBLImpl();
	}

	@Test
	public void test() throws Exception {
		assert(repoCheck.checkAndSum()==null);
	}

}
