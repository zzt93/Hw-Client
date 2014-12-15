package presentation.SetAccountui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import po.ClientPO;
import po.ClientType;
import presentation.mainui.ModelType;
import presentation.mainui.PublicTableModel;
import vo.BankVO;

public class ClientPanel {
	private JPanel panel;
	private JTable table;
	private PublicTableModel tableModel;
	public ArrayList<ClientPO> clientList;
	public void initialize(){
		panel = new JPanel();
		panel.setBounds(0, 0, 800, 500);
		panel.setLayout(null);
		
		JLabel label = new JLabel("客户信息");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(338, 24, 100, 15);
		panel.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 48, 639, 303);
		panel.add(scrollPane);
		
		tableModel = new PublicTableModel(ModelType.ACCOUNTCLIENT);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("添加");
		btnAdd.setBounds(464, 387, 80, 30);
		panel.add(btnAdd);
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				AddClientPanel add=new AddClientPanel();
			}
			
		});
		
		JButton btnDel = new JButton("删除");
		btnDel.setBounds(581, 387, 80, 30);
		panel.add(btnDel);
		btnDel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//TODO
			}
			
		});
	}
	public class AddClientPanel{

		private JFrame frame;
		private JTextField textName;
		private JTextField textPhone;
		private JComboBox comboBox;
		
		
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 300, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel panel = new JPanel();
			frame.add(panel);
			panel.setLayout(null);
			
			JLabel label = new JLabel("客户分类:");
			label.setBounds(24, 26, 54, 15);
			panel.add(label);
			
			JLabel label_1 = new JLabel("客户名称:");
			label_1.setBounds(24, 68, 54, 15);
			panel.add(label_1);
			
			JLabel label_2 = new JLabel("联系方式:");
			label_2.setBounds(24, 108, 54, 15);
			panel.add(label_2);
			
			comboBox = new JComboBox(new String[]{"销售商","供应商"});
			comboBox.setBounds(88, 23, 60, 21);
			panel.add(comboBox);
			
			textName = new JTextField();
			textName.setBounds(88, 65, 100, 21);
			panel.add(textName);
			textName.setColumns(10);
			
			textPhone = new JTextField();
			textPhone.setBounds(88, 105, 150, 21);
			panel.add(textPhone);
			textPhone.setColumns(10);
			
			JButton button = new JButton("确定");
			button.setBounds(51, 171, 60, 23);
			panel.add(button);
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					int temp=comboBox.getSelectedIndex();
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
					ClientPO client=new ClientPO();
					client.setName(textName.getText());
					client.setPhone(textPhone.getText());
					client.setType(type);
					//TODO,获得客户应收应付;
					tableModel.addRow(client);
					clientList.add(client);
					
				}
				
			});
			JButton button_1 = new JButton("取消");
			button_1.setBounds(167, 171, 60, 23);
			panel.add(button_1);
			button_1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
				
			});
		}
	}
}
