package presentation.SetAccountui;

import po.ClientPO;
import po.ResultMessage;
import vo.BankVO;
import vo.GoodsVO;
import businesslogic.SetAccountbl.SetAccount_stub;

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
			account.addGoods(new GoodsVO[2],null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			account.addClient(new ClientPO[2],null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			account.addBank(new BankVO[2],"账目");
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
