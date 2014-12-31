package businesslogic.RepoCheck;

import businesslogic.RepositoryCheckbl.Exporter;
import net.sf.jxls.exception.ParsePropertyException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Before;
import org.junit.Test;
import po.GoodsListPO;
import po.GoodsModelPO;
import po.GoodsPO;
import po.RepoPO;
import vo.GoodsVO;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public class Exporter_test {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		GoodsListPO tem = new GoodsListPO();
		
		HashMap<String, GoodsModelPO> goodsModel = new HashMap<String, GoodsModelPO>();
		GoodsModelPO a1m = new GoodsModelPO("a1", "a1", "a1");
		a1m.setAmount(30);
		GoodsModelPO a2m = new GoodsModelPO("a1", "a1", "a1");
		a2m.setAmount(30);
		goodsModel.put("a1", a1m);
		goodsModel.put("a2", a2m);
		goodsModel.put("a3", new GoodsModelPO("a3", "a1", "a1"));
		tem.setGoodsModels(goodsModel);
		
		HashMap<String, ArrayList<GoodsPO>> goods = new HashMap<String, ArrayList<GoodsPO>>();
		ArrayList<GoodsPO> a1_list = new ArrayList<GoodsPO>();
		a1_list.add(new GoodsPO(new GoodsVO("Light", "light", 10)));
		a1_list.add(new GoodsPO(new GoodsVO("a1", "light", 10)));
		ArrayList<GoodsPO> a2_list = new ArrayList<GoodsPO>();
		a2_list.add(new GoodsPO(new GoodsVO("a1", "light", 10)));
		a2_list.add(new GoodsPO(new GoodsVO("a1", "light", 10)));
		goods.put("a1", a1_list);
		goods.put("a2", a2_list);
		
		tem.setGoods(goods);

		RepoPO test = null;
		try {
			test = new RepoPO(tem);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		try {
			new Exporter().export_excel(test, "test.xls");
		} catch (ParsePropertyException | InvalidFormatException | IOException e) {
			
			e.printStackTrace();
		}
	}

}
