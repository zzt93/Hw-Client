package businesslogic.RunningTablebl;

import org.junit.Before;
import org.junit.Test;
import po.ReceiptPO;
import po.ReceiptType;
import vo.CashVO;
import vo.GoodsRecordVO;
import vo.ReceiptConditionVO;
import vo.SaleConditionVO;

import static org.junit.Assert.assertTrue;

public class RunTableControllerTest {
	RunTableController controller=new RunTableController();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetSaleTable() {
		try {
			GoodsRecordVO[] record=controller.getSaleTable(new SaleConditionVO());
			if(record[0].goods.equals("测试商品")){
				assertTrue(true);
			}else
				assertTrue(false);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void testGetReceipt() {
		try{
			ReceiptConditionVO condition=new ReceiptConditionVO(ReceiptType.CASH);
			ReceiptPO[] list=controller.getReceipt(condition);
			if(list[0].type==ReceiptType.CASH){
				assertTrue(true);
			}else {
				assertTrue(false);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}


	@Test
	public void testCreditNote() {
		CashVO cash=new CashVO();
		try {
			controller.CreditNote(cash);
			assertTrue(false);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}

}
