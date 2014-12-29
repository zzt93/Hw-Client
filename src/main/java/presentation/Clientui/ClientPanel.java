package presentation.Clientui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businesslogic.Clientbl.ClientUtilityImpl;
import po.ClientLevel;
import po.ClientPO;
import po.ClientType;

public class ClientPanel {
	final private JFrame frame;
	private JPanel panel;
	private JTextField textPhone;
	private JTextField textZip;
	private JTextField textAddress;
	private JTextField textUpBound;
	private JTextField textSalesman;
	private JTextField textEmail;
	private JComboBox typeBox;
	private ClientPO client;
	private JButton button1;
	private JButton button2;
	private ClientUtilityImpl clientController;
	
	public ClientPanel(ClientPO client){
		this.client=client;
		frame=new JFrame();
		frame.setBounds(0,0,450,500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			clientController = new ClientUtilityImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void show(){
		panel=new JPanel();
		panel.setLayout(null);

		
		JLabel label1=new JLabel("编号: "+client.getId());
		label1.setBounds(40,40,180,20);
		
		JLabel label2=new JLabel("类型: "+client.getType());
		label2.setBounds(240,40,180,20);
		
		JLabel label3=new JLabel("级别: "+client.getLevel().toString());
		label3.setBounds(40,80,180,20);

		JLabel label4=new JLabel("姓名: "+client.getName());
		label4.setBounds(240,80,180,20);
		
		JLabel label5=new JLabel("电话: "+client.getPhone());
		label5.setBounds(40,120,180,20);
		
		JLabel label6=new JLabel("邮编: "+client.getZip());
		label6.setBounds(240,120,180,20);
		
		JLabel label7=new JLabel("地址: "+client.getAddress());
		label7.setBounds(40,160,400,20);
		
		JLabel label8=new JLabel("电子邮箱: "+client.getEmail());
		label8.setBounds(40,200,400,20);
		
		JLabel label9=new JLabel("应收: "+client.getToReceive().toString());
		label9.setBounds(40,240,400,20);
		
		JLabel label10=new JLabel("应付: "+client.getToPay().toString());
		label10.setBounds(40,280,180,20);
		
		JLabel label11=new JLabel("应收额度: "+client.getUpperBound().toString());
		label11.setBounds(40,320,180,20);
		
		JLabel label12=new JLabel("默认业务员: "+client.getDefaultSalesMan());
		label12.setBounds(40,360,180,20);
		
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(label5);
		panel.add(label6);
		panel.add(label7);
		panel.add(label8);
		panel.add(label9);
		panel.add(label10);
		panel.add(label11);
		panel.add(label12);
		
		frame.add(panel);
		frame.setVisible(true);
	}
	public void modify(){
		
		panel=new JPanel();
		panel.setLayout(null);
		
		JLabel label1=new JLabel("编号: "+client.getId());
		label1.setBounds(40,40,180,20);
		
		JLabel label2=new JLabel("类型: "+client.getToPay());
		label2.setBounds(240,40,180,20);
		
		JLabel label3=new JLabel("级别: ");
		label3.setBounds(40,80,180,20);
		
		typeBox=new JComboBox(new String[]{"1","2","3","4","5"});
//		System.out.println(client.getLevel());
//		System.out.println(client.getLevel().ordinal());
		typeBox.setSelectedIndex(client.getLevel().ordinal());
		typeBox.setBounds(80,80,140,20);
		panel.add(typeBox);

		JLabel label4=new JLabel("姓名: "+client.getName());
		label4.setBounds(240,80,180,20);
		
		JLabel label5=new JLabel("电话: ");
		label5.setBounds(40,120,180,20);
		
		textPhone=new JTextField(client.getPhone());
		textPhone.setBounds(80,120,140,25);
		panel.add(textPhone);
		
		JLabel label6=new JLabel("邮编: ");
		label6.setBounds(240,120,180,20);
		
		textZip=new JTextField(client.getZip());
		textZip.setBounds(280,120,140,25);
		panel.add(textZip);
		
		JLabel label7=new JLabel("地址: ");
		label7.setBounds(40,160,400,20);
		
		textAddress=new JTextField(client.getAddress());
		textAddress.setBounds(80,160,300,25);
		panel.add(textAddress);
		
		JLabel label8=new JLabel("电子邮箱: ");
		label8.setBounds(40,200,400,20);
		
		textEmail=new JTextField(client.getEmail());
		textEmail.setBounds(120,200,300,25);
		panel.add(textEmail);
		
		JLabel label9=new JLabel("应收: "+client.getToReceive().toString());
		label9.setBounds(40,240,400,20);
		
		JLabel label10=new JLabel("应付: "+client.getToPay().toString());
		label10.setBounds(40,280,400,20);
		
		JLabel label11=new JLabel("应收额度: ");
		label11.setBounds(40,320,180,20);
		
		textUpBound=new JTextField(client.getUpperBound().toString());
		textUpBound.setBounds(120,320,180,25);
		panel.add(textUpBound);
		
		JLabel label12=new JLabel("默认业务员: ");
		label12.setBounds(40,360,180,20);
		
		textSalesman=new JTextField(client.getDefaultSalesMan());
		textSalesman.setBounds(140,360,180,25);
		panel.add(textSalesman);
		
		button1=new JButton("确定");
		button1.setBounds(120,420,60,30);
		panel.add(button1);
		button1.addActionListener(new Right());
		
		button2=new JButton("取消");
		button2.setBounds(240,420,60,30);
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		panel.add(button2);
		
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(label5);
		panel.add(label6);
		panel.add(label7);
		panel.add(label8);
		panel.add(label9);
		panel.add(label10);
		panel.add(label11);
		panel.add(label12);
		
		frame.add(panel);
		frame.setVisible(true);
	}
	public static void main(String[] args){
		ClientPO po=new ClientPO(ClientType.SELLER,ClientLevel.LEVEL1,"茶农","20050505050"
				,"大马士革","4420221","chanong@gmail.com","操作员");
		ClientPanel temp=new ClientPanel(po);
		temp.modify();
	}
	public class Right implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//FIXME,检查数据是否完整，检查生成PO
			client.setAddress(textAddress.getText());
			client.setDefaultSalesMan(textSalesman.getText());
			client.setEmail(textEmail.getText());
			client.setUpperBound(new BigDecimal(textUpBound.getText()));
			client.setZip(textZip.getText());
			client.setPhone(textPhone.getText());
			client.setLevel(ClientLevel.values()[typeBox.getSelectedIndex()]);
			
			try {
				clientController.modifyClient(client);
				JOptionPane.showMessageDialog(null, "修改成功");
				frame.dispose();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null,e1.getMessage());
			}
		}
	}
}
