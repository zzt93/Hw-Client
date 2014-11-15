package businesslogicservice.SetAccountblservice;
import vo.*;
import po.*;
public interface SetAccountblservice {
	public void inherit(String name , String accountName)throws Exception;
	public void setGoodsType()throws Exception;
	public void creatGoods(String name)throws Exception;
	public void creatClient(String name)throws Exception;
	public void creatBank(String name)throws Exception;
	public void setup(String name)throws Exception;
	public void checkGoodsType(String name)throws Exception;
	public GoodsVO[] checkGoods(String name)throws Exception;
	public ClientPO[] checkClient(String name)throws Exception;
	public BankVO[] checkBank(String name)throws Exception;
	public GoodsVO addGoods(GoodsVO vo)throws Exception;
	public void delGoods(GoodsVO vo);
	public BankVO addBank(BankVO vo)throws Exception;
	public void delBank(BankVO vo);
	public ClientPO addClient(ClientPO po)throws Exception;
	public void delClient(ClientPO po);
}
