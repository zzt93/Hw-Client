package businesslogic.SetAccountbl;

import po.ClientPO;
import vo.BankVO;
import vo.GoodsVO;

public class SetAccount_driver {
	public void driver(SetAccount_stub account){
		try {
			account.inherit("账目","账目");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			account.setGoodsType();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			account.creatGoods(new GoodsVO[1],null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			account.creatClient(new ClientPO[1],null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			account.creatBank(new BankVO[1],"账目");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			account.setup("Exist");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			account.checkGoodsType(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			GoodsVO[] goods=account.checkGoods("账目");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			BankVO[] bank=account.checkBank("账目");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			ClientPO[] client=account.checkClient(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
