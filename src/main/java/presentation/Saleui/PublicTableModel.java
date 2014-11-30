package presentation.Saleui;

import javax.swing.table.DefaultTableModel;

public class PublicTableModel extends DefaultTableModel {
	String[] name;
	public PublicTableModel(){
		super(10,3);
		
	} 
	public PublicTableModel(String[] name){
		super(name,10);
	}
	public boolean isCellEditable(int row,int column){
		return false;
	}
	public void update(Object[][] data){
		for(int i=0;i<columnIdentifiers.size();i++){
			name[i]=(String)columnIdentifiers.get(i);
		}
		super.setDataVector(data,name);
	}
	
}
