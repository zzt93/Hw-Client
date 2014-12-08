package businesslogic.RepoReceiptbl;

import dataservice.RepoReceiptdataservice.RepoReceiptDataService;
import po.GoodsReceiptPO;
import po.RepoFilterPO;
import po.RepoReceiptPO;
import po.ResultMessage;
import vo.ReceiptConditionVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class RepoReceiptDataImpl implements RepoReceiptDataService {

	@Override
	public ResultMessage<ArrayList<RepoReceiptPO>> getRepoReceipts(ReceiptConditionVO receiptConditionVO)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage<ArrayList<GoodsReceiptPO>> getGoodsReceipts(ReceiptConditionVO receiptConditionVO)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage<Boolean> insert(RepoReceiptPO receipt)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage<Boolean> insert(GoodsReceiptPO receipt)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage<Boolean> update(RepoReceiptPO receipt)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage<RepoReceiptPO> efind(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage<GoodsReceiptPO> efindGoods(String id)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	}
