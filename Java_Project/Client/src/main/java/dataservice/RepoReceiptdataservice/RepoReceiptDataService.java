package dataservice.RepoReceiptdataservice;

import java.util.ArrayList;

import po.RepoFilterPO;
import po.RepoReceiptPO;

public interface RepoReceiptDataService {
	ArrayList<RepoReceiptPO> getRepoReceipts() throws Exception;
	boolean initialize(ArrayList<RepoReceiptPO> receipt) throws Exception;
	
	boolean insert(RepoReceiptPO receipt) throws Exception;
	boolean delete(RepoReceiptPO receipt) throws Exception;
	boolean update(RepoReceiptPO receipt) throws Exception;
	
	RepoReceiptPO efind(String info) throws Exception;
	ArrayList<RepoReceiptPO> ifind(RepoFilterPO filter) throws Exception;
	
}
