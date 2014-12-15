/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.mainui;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import presentation.Clientui.ClientUI;
import presentation.Saleui.SaleUI;
import presentation.Stockui.StockUI;


/**
 *
 * @author zzt
 */
public class SalesmanUI extends JFrame {

    /**
     * Creates new form main
     */
    public SalesmanUI() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new JTabbedPane();
        saleUI = new SaleUI();
        stockUI = new StockUI();
        jScrollPane1 = new JScrollPane();
        clientUI = new ClientUI();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(750, 500));
        jTabbedPane1.addTab("销售管理", saleUI);
        jTabbedPane1.addTab("进货管理", stockUI);

//        jScrollPane1.setPreferredSize(new java.awt.Dimension(750, 500));

        clientUI.setPreferredSize(new java.awt.Dimension(800, 600));
        jScrollPane1.setViewportView(clientUI);

        jTabbedPane1.addTab("客户管理", jScrollPane1);
        jTabbedPane1.addChangeListener(new Change());

//        query.setPreferredSize(new java.awt.Dimension(750, 500));
//
//        query1.setPreferredSize(new java.awt.Dimension(800, 600));
//
//        GroupLayout query1Layout = new GroupLayout(query1);
//        query1.setLayout(query1Layout);
//        query1Layout.setHorizontalGroup(
//            query1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addGap(0, 800, Short.MAX_VALUE)
//        );
//        query1Layout.setVerticalGroup(
//            query1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addGap(0, 600, Short.MAX_VALUE)
//        );
//
//        query.setViewportView(query1);
//
//        jTabbedPane1.addTab("tab4", query);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    public class Change implements ChangeListener{
		public void stateChanged(ChangeEvent e) {
			JTabbedPane tabbedPane = (JTabbedPane) e.getSource();
		    int index = tabbedPane.getSelectedIndex();
		    switch(index){
		    case 0:
		    {	
		    	saleUI=new SaleUI();
		    	tabbedPane.setComponentAt(0, saleUI);
		    	break;
		    }
		    case 1:{
		    	stockUI=new StockUI();
		    	tabbedPane.setComponentAt(1, stockUI);
		    	break;
		    }
		    }
		}
    	
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SalesmanUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesmanUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesmanUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesmanUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	SalesmanUI a=new SalesmanUI();
                a.setLocationRelativeTo(null);
                a.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ClientUI clientUI;
    private JScrollPane jScrollPane1;
    private JTabbedPane jTabbedPane1;
    private SaleUI saleUI;
    private StockUI stockUI;
    // End of variables declaration//GEN-END:variables
}
