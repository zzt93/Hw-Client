package presentation.RepoUI;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import vo.GoodsVO;
import vo.RepoReceiptVO;
import businesslogic.RepoReceiptbl.RepoReceiptBLImpl;
import java.awt.Dimension;
import javax.swing.JScrollPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zzt
 */
public class Repo_Receipt_management extends javax.swing.JPanel {

    /**
     * Creates new form Receipt
     */
    RepoReceiptBLImpl repoReceiptBLImpl = null;
    private JPanel show_buttons_panel;
    private Repo_rece repo_rece1;
    private JScrollPane jScrollPane1;

    public Repo_Receipt_management() {
        try {
            repoReceiptBLImpl = new RepoReceiptBLImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NullPointerException nullPointerException) {
            if (MainFrame.DEBUG) {
                JOptionPane.showMessageDialog(MainFrame.frame,
                        nullPointerException
                        + ": Fail to fecth repo receipt data");
            } else {
                nullPointerException.printStackTrace();
            }
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
	// <editor-fold defaultstate="collapsed"
    // desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Repo_navigator = new javax.swing.JToolBar();
        goods_navi = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0),
                new java.awt.Dimension(20, 0),
                new java.awt.Dimension(20, 32767));
        repo_navi = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0),
                new java.awt.Dimension(20, 0),
                new java.awt.Dimension(20, 32767));
        log_out = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0),
                new java.awt.Dimension(20, 0),
                new java.awt.Dimension(20, 32767));
        show_rece = new javax.swing.JButton();
        change = new javax.swing.JPanel();
        make_repo_rece = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        comp = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        choose_id = new javax.swing.JComboBox<String>();
        amount = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        s_amount = new javax.swing.JLabel();
        c_amount = new javax.swing.JLabel();
        repo_rece_list = new javax.swing.JPanel();
        rece_name = new javax.swing.JComboBox<String>();
        back = new javax.swing.JButton();
        rece_panel = new javax.swing.JPanel();
        show_buttons_panel = new javax.swing.JPanel();
        RepoReceiptVO template = new RepoReceiptVO();

        template.actualNum = 10;
        template.statisticNum = 20;
        template.goods_id = "a1";
        template.number = "repo1";
        template.time = "2014-12-3";

        repo_rece1 = new Repo_rece(template);

        setPreferredSize(new java.awt.Dimension(800, 600));

        Repo_navigator.setFloatable(false);
        Repo_navigator.setRollover(true);

        goods_navi.setText("商品管理");
        goods_navi.setFocusable(false);
        goods_navi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        goods_navi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        goods_navi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goods_naviActionPerformed(evt);
            }
        });
        Repo_navigator.add(goods_navi);
        Repo_navigator.add(filler1);

        repo_navi.setText("库存管理");
        repo_navi.setFocusable(false);
        repo_navi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        repo_navi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        repo_navi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repo_naviActionPerformed(evt);
            }
        });
        Repo_navigator.add(repo_navi);
        Repo_navigator.add(filler2);

        log_out.setText("退出登录");
        log_out.setFocusable(false);
        log_out.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        log_out.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        log_out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_outActionPerformed(evt);
            }
        });
        Repo_navigator.add(log_out);
        Repo_navigator.add(filler3);

        show_rece.setText("查看库存单据");
        show_rece.setFocusable(false);
        show_rece.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        show_rece.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        show_rece.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_receActionPerformed(evt);
            }
        });
        Repo_navigator.add(show_rece);

        change.setLayout(new java.awt.CardLayout());

        jLabel2.setText("数量：");

        jLabel1.setText("商品id：");

        comp.setText("数量对比");
        comp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compActionPerformed(evt);
            }
        });

        if (MainFrame.DEBUG) {
            choose_id.setModel(new DefaultComboBoxModel<String>(new String[]{
                "Light1 a1", "Light2 a2", "Light3 a3"}));
        } else {
            try {
                choose_id.setModel(new javax.swing.DefaultComboBoxModel<String>(
                        repoReceiptBLImpl.check_type()));
            } catch (RemoteException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
                jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout
                .setHorizontalGroup(jPanel2Layout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                jPanel2Layout
                                .createSequentialGroup()
                                .addGroup(
                                        jPanel2Layout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(
                                                jPanel2Layout
                                                .createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(
                                                        jPanel2Layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(
                                                                jLabel1)
                                                        .addComponent(
                                                                jLabel2))
                                                .addGap(18,
                                                        18,
                                                        18)
                                                .addGroup(
                                                        jPanel2Layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(
                                                                amount,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                71,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                choose_id,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(
                                                jPanel2Layout
                                                .createSequentialGroup()
                                                .addGap(45,
                                                        45,
                                                        45)
                                                .addComponent(
                                                        comp)))
                                .addContainerGap()));
        jPanel2Layout
                .setVerticalGroup(jPanel2Layout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                jPanel2Layout
                                .createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(
                                        jPanel2Layout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(
                                                choose_id,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(
                                        jPanel2Layout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(
                                                amount,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(69, 69, 69).addComponent(comp)
                                .addContainerGap(93, Short.MAX_VALUE)));

        title.setText("报损单");

        jLabel4.setText("商品id：");

        jLabel5.setText("实际数量：");

        jLabel6.setText("统计数量：");

        id.setText("xxx");

        s_amount.setText("xxx");

        c_amount.setText("xxx");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
                jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout
                .setHorizontalGroup(jPanel3Layout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                jPanel3Layout
                                .createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(
                                        jPanel3Layout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(
                                                jPanel3Layout
                                                .createSequentialGroup()
                                                .addGap(57,
                                                        57,
                                                        57)
                                                .addComponent(
                                                        title))
                                        .addGroup(
                                                jPanel3Layout
                                                .createSequentialGroup()
                                                .addGroup(
                                                        jPanel3Layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(
                                                                jLabel4)
                                                        .addComponent(
                                                                jLabel5)
                                                        .addComponent(
                                                                jLabel6))
                                                .addGap(46,
                                                        46,
                                                        46)
                                                .addGroup(
                                                        jPanel3Layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(c_amount)
                                                        .addComponent(
                                                                s_amount)
                                                        .addComponent(
                                                                id))))
                                .addContainerGap(130, Short.MAX_VALUE)));
        jPanel3Layout
                .setVerticalGroup(jPanel3Layout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                jPanel3Layout
                                .createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(title)
                                .addGap(33, 33, 33)
                                .addGroup(
                                        jPanel3Layout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(id))
                                .addGap(18, 18, 18)
                                .addGroup(
                                        jPanel3Layout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(s_amount))
                                .addGap(18, 18, 18)
                                .addGroup(
                                        jPanel3Layout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(c_amount))
                                .addContainerGap(134, Short.MAX_VALUE)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);
        jScrollPane1.setPreferredSize(new Dimension(750, 450));
        javax.swing.GroupLayout make_repo_receLayout = new javax.swing.GroupLayout(make_repo_rece);
        make_repo_rece.setLayout(make_repo_receLayout);
        make_repo_receLayout.setHorizontalGroup(
            make_repo_receLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(make_repo_receLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        make_repo_receLayout.setVerticalGroup(
            make_repo_receLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, make_repo_receLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        change.add(make_repo_rece, "make");

        repo_rece_list.setPreferredSize(new java.awt.Dimension(524, 367));

        rece_panel.setLayout(new javax.swing.BoxLayout(rece_panel,
                javax.swing.BoxLayout.LINE_AXIS));
        rece_panel.add(repo_rece1);

        if (MainFrame.DEBUG) {
            rece_name.setModel(new javax.swing.DefaultComboBoxModel<String>(
                    new String[]{"repo1", "repo2", "repo3"}));
        } else {
            try {
                rece_name.setModel(new DefaultComboBoxModel<String>(
                        repoReceiptBLImpl.receipt_ids()));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        rece_name.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int index = rece_name.getSelectedIndex();
                RepoReceiptVO template = null;
                if (MainFrame.DEBUG) {
                    template = new RepoReceiptVO();
                    template.actualNum = 100;
                    template.statisticNum = 20;
                    template.number = "a1";
                    template.number = "repo3";
                    template.time = "2014-12-3";
                } else {
                    try {
                        template = repoReceiptBLImpl.show_a_RepoReceiptVO(index);
                    } catch (RemoteException e1) {
                        e1.printStackTrace();
                    }
                }
                rece_panel.removeAll();
                rece_panel.add(new Repo_rece(template));
                rece_panel.repaint();
                rece_panel.revalidate();
            }
        });

        back.setText("返回");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
                show_buttons_panel);
        show_buttons_panel.setLayout(jPanel5Layout);
        jPanel5Layout
                .setHorizontalGroup(jPanel5Layout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                jPanel5Layout
                                .createSequentialGroup()
                                .addContainerGap()
                                .addGroup(
                                        jPanel5Layout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(
                                                rece_name,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(back))
                                .addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                        jPanel5Layout
                        .createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back)
                        .addGap(38, 38, 38)
                        .addComponent(rece_name,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()));

        javax.swing.GroupLayout repo_rece_listLayout = new javax.swing.GroupLayout(
                repo_rece_list);
        repo_rece_list.setLayout(repo_rece_listLayout);
        repo_rece_listLayout.setHorizontalGroup(repo_rece_listLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        repo_rece_listLayout
                        .createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rece_panel,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(show_buttons_panel,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(137, Short.MAX_VALUE)));
        repo_rece_listLayout.setVerticalGroup(repo_rece_listLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        repo_rece_listLayout
                        .createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rece_panel,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE).addContainerGap())
                .addGroup(
                        repo_rece_listLayout
                        .createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(show_buttons_panel,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)));

        change.add(repo_rece_list, "show");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        layout.createSequentialGroup()
                        .addGroup(
                                layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(
                                        layout.createSequentialGroup()
                                        .addGap(42, 42,
                                                42)
                                        .addComponent(
                                                Repo_navigator,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                423,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(
                                        layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(
                                                change,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                        javax.swing.GroupLayout.Alignment.TRAILING,
                        layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(Repo_navigator,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 25,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(change,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE).addGap(31, 31, 31)));
    }// </editor-fold>//GEN-END:initComponents

    private void goods_naviActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_goods_naviActionPerformed

        CardLayout card = (CardLayout) MainFrame.frame.getContentPane()
                .getLayout();
        card.show(MainFrame.frame.getContentPane(), "main_card");
        MainFrame.tab_pane.setSelectedIndex(0);
    }// GEN-LAST:event_goods_naviActionPerformed

    private void repo_naviActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_repo_naviActionPerformed

        CardLayout card = (CardLayout) MainFrame.frame.getContentPane()
                .getLayout();
        card.show(MainFrame.frame.getContentPane(), "main_card");
        MainFrame.tab_pane.setSelectedIndex(2);
    }// GEN-LAST:event_repo_naviActionPerformed

    private void log_outActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_log_outActionPerformed

        CardLayout card = (CardLayout) MainFrame.frame.getContentPane()
                .getLayout();
        card.show(MainFrame.frame.getContentPane(), "log_card");
        MainFrame.tab_pane.setSelectedIndex(3);
    }// GEN-LAST:event_log_outActionPerformed

    private void show_receActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_show_receActionPerformed
        if (MainFrame.DEBUG) {
            rece_name.setModel(new javax.swing.DefaultComboBoxModel<String>(
                    new String[]{"repo1", "repo2", "repo3", "test"}));
        } else {
            try {
                rece_name.setModel(new DefaultComboBoxModel<String>(
                        repoReceiptBLImpl.receipt_ids()));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        CardLayout card = (CardLayout) change.getLayout();
        card.show(change, "show");

    }// GEN-LAST:event_show_receActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_backActionPerformed
        CardLayout card = (CardLayout) change.getLayout();
        card.show(change, "make");
    }// GEN-LAST:event_backActionPerformed

    private void compActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_compActionPerformed
        String res = " ";
        boolean vaild = true;
        try {
            GoodsVO temp = new GoodsVO(((String) choose_id.getSelectedItem()).split(RepoReceiptBLImpl.check_type_id_name)[0],
                    Integer.parseInt(amount.getText()));
            res = repoReceiptBLImpl.produceRepoReceipt(temp);
        } catch (NumberFormatException numberFormatException) {
            numberFormatException.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    "Fail to parse the number for your input is : "
                    + amount.getText());
            vaild = false;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(MainFrame.frame, e
                    + ": fail to produce repo receipt");
            if (MainFrame.DEBUG) {

            } else {
                vaild = false;
            }
        }
        // not vaild input
        if (!vaild) {
            title.setText(" ");
            s_amount.setText(" ");
            id.setText(" ");
            c_amount.setText(" ");
            return;
        }
        if (res.equals(" ")) {
            title.setText("Amount is right");
            c_amount.setText(amount.getText());
        } else {
            String[] infos = res.split(" ");
            title.setText(infos[0]);
            c_amount.setText(infos[1]);
        }
        id.setText((String) choose_id.getSelectedItem());
        s_amount.setText(amount.getText());
    }// GEN-LAST:event_compActionPerformed

    public void update_ui() {
        try {
            choose_id.setModel(new javax.swing.DefaultComboBoxModel<String>(
                    repoReceiptBLImpl.check_type()));
        } catch (RemoteException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar Repo_navigator;
    private javax.swing.JTextField amount;
    private javax.swing.JButton back;
    private javax.swing.JLabel s_amount;
    private javax.swing.JPanel change;
    private javax.swing.JComboBox<String> choose_id;
    private javax.swing.JButton comp;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JButton goods_navi;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel title;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel rece_panel;
    private javax.swing.JButton log_out;
    private javax.swing.JPanel make_repo_rece;
    private javax.swing.JComboBox<String> rece_name;
    private javax.swing.JButton repo_navi;
    private javax.swing.JPanel repo_rece_list;
    private javax.swing.JLabel c_amount;
    private javax.swing.JButton show_rece;
	// End of variables declaration//GEN-END:variables
}
