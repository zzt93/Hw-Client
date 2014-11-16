package businesslogic.FinancialReceiptbl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businesslogic.FinancialReceiptbl.FinReceiptController;
import po.BkTransPO;
import po.ItemPO;
import vo.CashVO;
import vo.PayVO;

public class FinReceiptControllerTest {

	@Before
	public void setUp() throws Exception {
	}
	FinReceiptController controller=new FinReceiptController();
	@Test
	public void testAddBank() {
		BkTransPO[] list=new BkTransPO[3];
		list[0]=new BkTransPO("test1",180.2);
		list[1]=new BkTransPO("test2",19);
		list[2]=new BkTransPO("test3",0.8);
		for(int i=0;i<2;i++){
			controller.addBank(list[i]);
		}
		double total=controller.addBank(list[2]);
		if(200==total){
			assertTrue(true);
		}else
			assertTrue(false);
	}

	@Test
	public void testAddItem() {
		ItemPO[] list=new ItemPO[3];
		list[0]=new ItemPO("test1",180.2);
		list[1]=new ItemPO("test2",19);
		list[2]=new ItemPO("test3",0.8);
		for(int i=0;i<2;i++){
			controller.addItem(list[i]);
		}
		double total=controller.addItem(list[2]);
		if(200==total){
			assertTrue(true);
		}else
			assertTrue(false);
	}

	@Test
	public void testDeleteBank() {
		BkTransPO[] list=new BkTransPO[3];
		list[0]=new BkTransPO("test1",180.2);
		list[1]=new BkTransPO("test2",19);
		list[2]=new BkTransPO("test3",0.8);
		for(int i=0;i<3;i++){
			controller.addBank(list[i]);
		}
		double total=controller.deleteBank(list[1]);
		if(181==total){
			assertTrue(true);
		}else
			assertTrue(false);
	}

	@Test
	public void testDeleteItem() {
		ItemPO[] list=new ItemPO[3];
		list[0]=new ItemPO("test1",180.2);
		list[1]=new ItemPO("test2",19);
		list[2]=new ItemPO("test3",0.8);
		for(int i=0;i<3;i++){
			controller.addItem(list[i]);
		}
		double total=controller.deleteItem(list[1]);
		if(181==total){
			assertTrue(true);
		}else
			assertTrue(false);
	}
	

	@Test
	public void testMakePayment() {
		try{
			controller.makePayment(new PayVO());
		}catch(Exception e){
			System.out.println(e.getMessage());
			assertTrue(false);
		}
	}

	@Test
	public void testMakeCash() {
		try{
			controller.makeCash(new CashVO());
			assertTrue(false);
		}catch(Exception e){
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}

	@Test
	public void testCreditCash() {
		try{
			controller.creditCash(new CashVO());
			assertTrue(false);
		}catch(Exception e){
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}

}
