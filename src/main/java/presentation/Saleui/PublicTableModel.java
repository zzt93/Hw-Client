package presentation.Saleui;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import po.ClientPO;
import vo.BankVO;

public class PublicTableModel extends DefaultTableModel {
	String[] name;
	Object[][] data;
	ModelType type;
	public PublicTableModel(){
		super(0,3);
	} 
	private PublicTableModel(String[] name){
		super(name,0);
		this.name=name;
	}
	public PublicTableModel(ModelType type){
		this.type=type;
		switch(type){
		case BANK:	
			name=new String[]{"银行账户","余额","备注"};
			setDataVector(data,name);
			break;
		case CLIENT:
			name=new String[]{"姓名","编号","分类",
					"级别","应收","应付","业务员"};
			setDataVector(data,name);
			break;		
		}
	}
	public boolean isCellEditable(int row,int column){
		return false;
	}
	public void update(Object[][] data){
		setDataVector(data,name);
	}
	public void update(List list){
		if(type==ModelType.CLIENT){
			Object[][] data=new Object[list.size()][7];
			ClientPO temp;
			for(int i=0;i<list.size();i++){
				temp=(ClientPO)list.get(i);
				data[i][0]=temp.getName();
				data[i][1]=temp.getId();
				data[i][2]=temp.getType();
				data[i][3]=temp.getLevel();
				data[i][4]=temp.getToPay();
				data[i][5]=temp.getToReceive();
				data[i][6]=temp.getDefaultSalesMan();
			}
			update(data);
		}
	}
	public void update(BankVO[] list){
		Object[][] data=new Object[list.length][3];
		BankVO temp;
		for(int i=0;i<list.length;i++){
			temp=list[i];
			data[i][0]=temp.name;
			data[i][1]=temp.balance;
			data[i][2]=temp.remark;
		}
		update(data);
	}
	
}
