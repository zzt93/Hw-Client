package dataservice.RepoReceiptdataservice;

import java.util.ArrayList;

import po.RepoFilterPO;
import po.RepoReceiptPO;

public interface RepoReceiptDataService {
	ArrayList<RepoReceiptPO> getRepoReceipts();
	boolean initialize(ArrayList<RepoReceiptPO> receipt);
	
	boolean insert(RepoReceiptPO receipt);
	boolean delete(RepoReceiptPO receipt);
	boolean update(RepoReceiptPO receipt);
	
	RepoReceiptPO efind(String info);
	ArrayList<RepoReceiptPO> ifind(RepoFilterPO filter);
	
}
