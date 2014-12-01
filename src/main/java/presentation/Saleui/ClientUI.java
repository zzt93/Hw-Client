/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Saleui;

/**
 *
 * @author zzt
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import po.ClientLevel;
import po.ClientPO;
import po.ClientType;
import businesslogic.Clientbl.ClientUtilityImpl;

public class ClientUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textFieldName;
	private JTextField textFieldPhone;
	private JTextField textFieldAddress;
	private JTextField textFieldZip;
	private JTextField textFieldEmail;
	private JTextField textFieldUpperBound;
	private ClientUtilityImpl clientController;
	private ClientPO client;
	private List<ClientPO> list=new ArrayList<ClientPO>();
	PublicTableModel tableModel;
	JTable listTable;
	JComboBox typeBox;
	/**
	 * Create the panel.
	 */
	public ClientUI() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(32, 47, 755, 499);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("客户查询", null, panel, null);
		panel.setLayout(null);
				
		textField = new JTextField();
		textField.setBounds(40, 41, 557, 30);
		panel.add(textField);
		textField.setColumns(10);
		textField.addKeyListener(new Search());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 107, 570, 271);
		panel.add(scrollPane);
		tableModel=new PublicTableModel(ModelType.CLIENT);
		listTable = new JTable(tableModel);
		listTable.addMouseListener(new MouseClick());
		scrollPane.setViewportView(listTable);
		
		JButton buttonModify = new JButton("修改客户");
		buttonModify.setBounds(132, 426, 93, 23);
		panel.add(buttonModify);
		buttonModify.addActionListener(new Modify());
		
		JButton buttonDelete = new JButton("删除客户");
		buttonDelete.setBounds(302, 426, 93, 23);
		panel.add(buttonDelete);
		buttonDelete.addActionListener(new Delete());
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("增加客户", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel labelName = new JLabel("姓名");
		labelName.setBounds(87, 57, 54, 15);
		panel_1.add(labelName);
		
		JLabel labelPhone = new JLabel("电话");
		labelPhone.setBounds(87, 100, 54, 15);
		panel_1.add(labelPhone);
		
		JLabel labelAddress = new JLabel("地址");
		labelAddress.setBounds(87, 146, 54, 15);
		panel_1.add(labelAddress);
		
		JLabel labelZip = new JLabel("邮编");
		labelZip.setBounds(87, 187, 54, 15);
		panel_1.add(labelZip);
		
		JLabel labelEmail = new JLabel("伊妹儿");
		labelEmail.setBounds(87, 236, 54, 15);
		panel_1.add(labelEmail);
		
//		JLabel labelUpperBound = new JLabel("上限");
//		labelUpperBound.setBounds(87, 292, 54, 15);
//		panel_1.add(labelUpperBound);
		
		JLabel labelType=new JLabel("用户类型");
		labelType.setBounds(87, 350, 54, 15);
		panel_1.add(labelType);
		
		typeBox=new JComboBox(new String[]{"供应商","销售商"});
		typeBox.setBounds(209,350,108,21);
		panel_1.add(typeBox);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(209, 54, 143, 21);
		panel_1.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(209, 97, 143, 21);
		panel_1.add(textFieldPhone);
		textFieldPhone.setColumns(10);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(209, 143, 143, 21);
		panel_1.add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		textFieldZip = new JTextField();
		textFieldZip.setBounds(209, 184, 143, 21);
		panel_1.add(textFieldZip);
		textFieldZip.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(209, 233, 143, 21);
		panel_1.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
//		textFieldUpperBound = new JTextField();
//		textFieldUpperBound.setBounds(209, 289, 143, 21);
//		panel_1.add(textFieldUpperBound);
//		textFieldUpperBound.setColumns(10);
		
		JButton buttonConfirm = new JButton("确定");
		buttonConfirm.setBounds(126, 396, 93, 23);
		buttonConfirm.addActionListener(new Add());
		panel_1.add(buttonConfirm);
		
		JButton buttonCancel = new JButton("取消");
		buttonCancel.setBounds(329, 396, 93, 23);
		panel_1.add(buttonCancel);
		
		JLabel label = new JLabel("客户管理");
		label.setBounds(32, 22, 54, 15);
		add(label);
		
		JLabel label_1 = new JLabel("我是卖萌的状态栏");
		label_1.setBounds(32, 570, 224, 15);
		add(label_1);
		
		JButton button_4 = new JButton("返回");
		button_4.setBounds(548, 566, 93, 23);
		add(button_4);
		

	}
	public class Add implements ActionListener{
		public void actionPerformed(ActionEvent e){	
			int temp=typeBox.getSelectedIndex();
			ClientType type=null;
			if(temp==0){
				type=ClientType.SELLER;
			}
			else if(temp==1){
				type=ClientType.STOCKER;
			}
			else{
				JOptionPane.showMessageDialog(null, "请选择用户类型");
			}
			client=new ClientPO(type,ClientLevel.LEVEL1,textFieldName.getText(),textFieldPhone.getText()
					,textFieldAddress.getText(),textFieldZip.getText(),textFieldEmail.getText(),"操作员");
			try {
				clientController.addClient(client);
				JOptionPane.showMessageDialog(null,"添加成功");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	}
	public class Delete implements ActionListener{
			public void actionPerformed(ActionEvent e){	
				int row=listTable.getSelectedRow();
				if(row==-1){
					JOptionPane.showMessageDialog(null, "未选中客户");
				}else{
					client=list.get(row);
					try {
						clientController.deleteClient(client.getId());
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
		}
	}
	public class Modify implements ActionListener{
			public void actionPerformed(ActionEvent e){	
				int row=listTable.getSelectedRow();
				if(row==-1){
					JOptionPane.showMessageDialog(null, "未选中客户");
				}else{
					//修改操作
					ClientPanel pane=new ClientPanel(list.get(row));
					pane.modify();
				}
		}
	}
	public class Search extends KeyAdapter{
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode()==10){
					HashMap<String,Object> map=new HashMap<String,Object>();
					map.put("name", textField.getText());
//FIXME,测试注销掉					
//					try {
//						list=clientController.queryClient(map);
//					} catch (Exception e1) {
//						JOptionPane.showMessageDialog(null, e1.getMessage());
//					}
					
					//测试代码
					{
						list.add(new ClientPO());
						tableModel.update(list);
					}
				}
			}
	}
	public class MouseClick extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			int row=listTable.getSelectedRow();
			if(row==-1){
				JOptionPane.showMessageDialog(null, "未选中客户");
			}else{
				if(e.getClickCount()>=2){
					ClientPanel pane=new ClientPanel(list.get(row));
				}
				ClientPanel pane=new ClientPanel(list.get(row));
				pane.show();
			}
		}
	}
}
