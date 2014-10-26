package businesslogicservice.SetAccountblservice;
import vo.*;
import po.*;
public interface SetAccountblservice {
	public void inherit(String name , String accountName)throws Exception;
	public void setGoodsType()throws Exception;
	public void addGoods(GoodsVO[] vo,String name)throws Exception;
	public void addClient(ClientPO[] vo,String name)throws Exception;
	public void addBank(BankVO[] vo,String name)throws Exception;
	public void setup(String name)throws Exception;
	public void checkGoodsType(String name)throws Exception;
	public GoodsVO[] checkGoods(String name)throws Exception;
	public ClientPO[] checkClient(String name)throws Exception;
	public BankVO[] checkBank(String name)throws Exception;
}
