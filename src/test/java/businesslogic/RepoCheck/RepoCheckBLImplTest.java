package businesslogic.RepoCheck;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businesslogic.GoodsListbl.GL_manager_repo_Impl;
import businesslogic.RepositoryCheckbl.RepoCheckBLImpl;
import businesslogicservice.GoodsListblservice.GL_repo_BLservice;

public class RepoCheckBLImplTest {

	RepoCheckBLImpl repoCheck;
	@Before
	public void setUp() throws Exception {
		GL_repo_BLservice repo = new GL_manager_repo_Impl();
		repoCheck = new RepoCheckBLImpl(repo);
	}

	@Test
	public void test() {
		assert(repoCheck.checkAndSum()==null);
	}

}
