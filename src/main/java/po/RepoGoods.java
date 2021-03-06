package po;

import businesslogic.RepositoryCheckbl.RepoCheckBLImpl;
import businesslogic.RepositoryCheckbl.RepoCheckDataImpl;
import dataservice.RepositoryCheckdataservice.RepoCheckDataService;
import util.RMIUtility;

import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RepoGoods implements Serializable {
	private static final long serialVersionUID = 1L;
	public RepoGoods(String id, GoodsModelPO goodsModelPO) throws RemoteException, NotBoundException {
		RepoCheckDataService repoCheckDataService = (RepoCheckDataService) RMIUtility.getImpl(RepoCheckBLImpl.check);
		this.id = id;
		amount = goodsModelPO.getAmount();
		aver_price = repoCheckDataService.getAver_in(id).getObj();
		
		name = goodsModelPO.getName();
		model = goodsModelPO.getModel();
	}
	String id;
	
	String name;
	String model;
	int amount;
	double aver_price;
	
	public String getName() {
		return name;
	}
	public String getModel() {
		return model;
	}
	public int getAmount() {
		return amount;
	}
	public double getAver_price() {
		return aver_price;
	}
	public String getId() {
		return id;
	}
}