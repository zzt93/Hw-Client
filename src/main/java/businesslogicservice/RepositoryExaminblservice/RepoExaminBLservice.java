package businesslogicservice.RepositoryExaminblservice;

import java.rmi.RemoteException;

import vo.InOutRepoVO;

public interface RepoExaminBLservice {
	InOutRepoVO countInOut(String start, String end) throws Exception;
}
