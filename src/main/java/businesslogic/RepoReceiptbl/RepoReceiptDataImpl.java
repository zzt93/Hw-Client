package businesslogic.RepoReceiptbl;

import dataservice.RepoReceiptdataservice.RepoReceiptDataService;
import po.GoodsReceiptPO;
import po.RepoFilterPO;
import po.RepoReceiptPO;
import po.ResultMessage;
import vo.GoodsReceiptVO;
import vo.GoodsVO;
import vo.ReceiptConditionVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

public class RepoReceiptDataImpl implements RepoReceiptDataService {

	@Override
	public ResultMessage<ArrayList<RepoReceiptPO>> getRepoReceipts(ReceiptConditionVO receiptConditionVO)
			throws RemoteException {
		System.out.println("in getRepoReceipt of repo receipt data stub");
		return new ResultMessage<ArrayList<RepoReceiptPO>>(null, new ArrayList<RepoReceiptPO>());
	}

	@Override
	public ResultMessage<ArrayList<GoodsReceiptPO>> getGoodsReceipts(ReceiptConditionVO receiptConditionVO)
			throws RemoteException {
		System.out.println("in getGoodsReceipt of repo receipt data stub");
		return new ResultMessage<ArrayList<GoodsReceiptPO>>(null, new ArrayList<GoodsReceiptPO>());
	}

	@Override
	public ResultMessage<Boolean> insert(RepoReceiptPO receipt)
			throws RemoteException {
		System.out.println("in insert of repo receipt data stub");
		return new ResultMessage<Boolean>(null, true);
	}

	@Override
	public ResultMessage<Boolean> insert(GoodsReceiptPO receipt)
			throws RemoteException {
		System.out.println("in insert of repo receipt data stub");
		return new ResultMessage<Boolean>(null, true);
	}

	@Override
	public ResultMessage<Boolean> update(RepoReceiptPO receipt)
			throws RemoteException {
		System.out.println("in update of repo receipt data stub");
		return new ResultMessage<Boolean>(null, true);
	}

	@Override
	public ResultMessage<RepoReceiptPO> efind(String id) throws RemoteException {
		System.out.println("in efind of repo receipt data stub");
		return new ResultMessage<RepoReceiptPO>(null, new RepoReceiptPO("id", 12, 13, "user"));
	}

	@Override
	public ResultMessage<GoodsReceiptPO> efindGoods(String id)
			throws RemoteException {
		System.out.println("in insert of repo receipt data stub");
		return new ResultMessage<GoodsReceiptPO>(null, new GoodsReceiptPO(new GoodsReceiptVO(new Vector<GoodsVO>(), "")));
	}

	}
