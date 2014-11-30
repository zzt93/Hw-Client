package presentation.RepoUI;

import java.awt.CardLayout;
import java.awt.Cursor;
import java.io.File;
import java.rmi.RemoteException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import vo.InOutRepoVO;
import businesslogic.RepositoryCheckbl.RepoCheckBLImpl;
import businesslogic.RepositoryExaminbl.RepoExaminBLImpl;
import businesslogicservice.RepositoryCheckblservice.RepoCheckBLservice;
import businesslogicservice.RepositoryExaminblservice.RepoExaminBLservice;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zzt
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
	RepoCheckBLservice repoCheckBLservice ;
	RepoExaminBLservice repoExaminBLservice = new RepoExaminBLImpl();
    public MainFrame() {
    	try {
			repoCheckBLservice = new RepoCheckBLImpl();
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(frame, "Repo Check fail to get data");
		}
    	
        initComponents();
    }

    String[] year = new String[]{"2013", "2014", "2015", "2016"};
    String[] month = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",};
    String[][] day = new String[][]{
        {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"},
        {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"},
        {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28"},
        {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29"},};

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        log_in1 = new Log_in();
        first = new javax.swing.JPanel();
        tab_pane = new javax.swing.JTabbedPane();
        goods_panel = new javax.swing.JPanel();
        goodsList = new javax.swing.JButton();
        goodsType = new javax.swing.JButton();
        rece_panel = new javax.swing.JPanel();
        repo_rece = new javax.swing.JButton();
        goods_rece = new javax.swing.JButton();
        repo_panel = new javax.swing.JPanel();
        export = new javax.swing.JButton();
        repo_check = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        repo_examin = new javax.swing.JButton();
        s_year1 = new javax.swing.JComboBox();
        s_mon1 = new javax.swing.JComboBox();
        s_mon = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        s_year = new javax.swing.JComboBox();
        s_day1 = new javax.swing.JComboBox();
        s_day = new javax.swing.JComboBox();
        others = new javax.swing.JLayeredPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        update_bar = new javax.swing.JProgressBar();
        tool = new javax.swing.JToolBar();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        log_out = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        refresh = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        
        goodsListPanel1 = new GoodsListPanel();
        goodsTypePanel1 = new GoodsTypePanel();
        repo_receipt1 = new Repo_Receipt_management();
        goods_receipt1 = new Goods_receipt_management();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());
        getContentPane().add(log_in1, "log_card");

        first.setPreferredSize(new java.awt.Dimension(800, 600));

        tab_pane.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        goodsList.setText("商品目录");
        goodsList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goodsListActionPerformed(evt);
            }
        });

        goodsType.setText("商品分类");
        goodsType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goodsTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout goods_panelLayout = new javax.swing.GroupLayout(goods_panel);
        goods_panel.setLayout(goods_panelLayout);
        goods_panelLayout.setHorizontalGroup(
            goods_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(goods_panelLayout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(goodsList)
                .addGap(115, 115, 115)
                .addComponent(goodsType)
                .addContainerGap(264, Short.MAX_VALUE))
        );
        goods_panelLayout.setVerticalGroup(
            goods_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(goods_panelLayout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addGroup(goods_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(goodsList)
                    .addComponent(goodsType))
                .addContainerGap(238, Short.MAX_VALUE))
        );

        tab_pane.addTab("商品管理", goods_panel);

        repo_rece.setText("报溢/报损单");
        repo_rece.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repo_receActionPerformed(evt);
            }
        });

        goods_rece.setText("赠送单");
        goods_rece.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goods_receActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rece_panelLayout = new javax.swing.GroupLayout(rece_panel);
        rece_panel.setLayout(rece_panelLayout);
        rece_panelLayout.setHorizontalGroup(
            rece_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rece_panelLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(repo_rece)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 372, Short.MAX_VALUE)
                .addComponent(goods_rece)
                .addGap(131, 131, 131))
        );
        rece_panelLayout.setVerticalGroup(
            rece_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rece_panelLayout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addGroup(rece_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(repo_rece)
                    .addComponent(goods_rece))
                .addContainerGap(236, Short.MAX_VALUE))
        );

        tab_pane.addTab("单据管理", rece_panel);

        export.setText("导出Excel");
        export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportActionPerformed(evt);
            }
        });

        repo_check.setText("库存统计");
        repo_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repo_checkActionPerformed(evt);
            }
        });

        repo_examin.setText("库存盘点");
        repo_examin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repo_examinActionPerformed(evt);
            }
        });

        s_year1.setModel(new javax.swing.DefaultComboBoxModel(year));
        s_year1.setSelectedItem(year[1]);
        s_year1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_year1ActionPerformed(evt);
            }
        });

        s_mon1.setModel(new javax.swing.DefaultComboBoxModel(month));
        s_mon1.setSelectedItem(month[11]);
        s_mon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_mon1ActionPerformed(evt);
            }
        });

        s_mon.setModel(new javax.swing.DefaultComboBoxModel(month));
        s_mon.setSelectedItem(month[11]);
        s_mon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_monActionPerformed(evt);
            }
        });
        s_mon.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                s_monPropertyChange(evt);
            }
        });

        jLabel1.setText("开始日期：");

        jLabel2.setText("结束日期：");

        s_year.setModel(new javax.swing.DefaultComboBoxModel(year));
        s_year.setSelectedItem(year[1]);
        s_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_yearActionPerformed(evt);
            }
        });

        s_day1.setModel(new javax.swing.DefaultComboBoxModel(day[0]));
        s_day1.setSelectedItem(day[1]);

        s_day.setModel(new javax.swing.DefaultComboBoxModel(day[1]));
        s_day.setSelectedItem(day[1]);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(s_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(s_mon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(s_day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(repo_examin)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(s_year1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s_mon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s_day1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(s_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s_day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s_mon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(s_mon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(s_year1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(s_day1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addComponent(repo_examin)
                .addContainerGap())
        );

        javax.swing.GroupLayout repo_panelLayout = new javax.swing.GroupLayout(repo_panel);
        repo_panel.setLayout(repo_panelLayout);
        repo_panelLayout.setHorizontalGroup(
            repo_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, repo_panelLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(repo_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(repo_check, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(export, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        repo_panelLayout.setVerticalGroup(
            repo_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(repo_panelLayout.createSequentialGroup()
                .addContainerGap(164, Short.MAX_VALUE)
                .addGroup(repo_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, repo_panelLayout.createSequentialGroup()
                        .addComponent(repo_check)
                        .addGap(26, 26, 26)
                        .addComponent(export)
                        .addGap(194, 194, 194))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, repo_panelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149))))
        );

        tab_pane.addTab("库存管理", repo_panel);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout othersLayout = new javax.swing.GroupLayout(others);
        others.setLayout(othersLayout);
        othersLayout.setHorizontalGroup(
            othersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(othersLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(405, Short.MAX_VALUE))
        );
        othersLayout.setVerticalGroup(
            othersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(othersLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(othersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(336, Short.MAX_VALUE))
        );
        others.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        others.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tab_pane.addTab("其他", others);

        update_bar.setForeground(new java.awt.Color(254, 34, 34));

        tool.setFloatable(false);
        tool.setRollover(true);
        tool.add(filler4);

        log_out.setText("退出");
        log_out.setFocusable(false);
        log_out.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        log_out.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        log_out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_outActionPerformed(evt);
            }
        });
        tool.add(log_out);
        tool.add(filler2);

        refresh.setText("刷新");
        refresh.setFocusable(false);
        refresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        refresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        tool.add(refresh);
        tool.add(filler3);

        

        javax.swing.GroupLayout firstLayout = new javax.swing.GroupLayout(first);
        first.setLayout(firstLayout);
        firstLayout.setHorizontalGroup(
            firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstLayout.createSequentialGroup()
                .addGroup(firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, firstLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(update_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(firstLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tab_pane)
                            .addGroup(firstLayout.createSequentialGroup()
                                .addComponent(tool, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18))
        );
        firstLayout.setVerticalGroup(
            firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(tool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(tab_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(update_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(first, "main_card");
        getContentPane().add(goodsListPanel1, "goodsList_card");
        getContentPane().add(goodsTypePanel1, "goodsType_card");
        getContentPane().add(repo_receipt1, "repo_receipt_card");
        getContentPane().add(goods_receipt1, "goods_receipt_card");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goodsListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goodsListActionPerformed
        
        CardLayout card = (CardLayout) this.getContentPane().getLayout();
        card.show(this.getContentPane(), "goodsList_card");
    }//GEN-LAST:event_goodsListActionPerformed

    private void goods_receActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goods_receActionPerformed
        
        CardLayout card = (CardLayout) this.getContentPane().getLayout();
        card.show(this.getContentPane(), "goods_receipt_card");
    }//GEN-LAST:event_goods_receActionPerformed

    private void goodsTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goodsTypeActionPerformed
        
        CardLayout card = (CardLayout) this.getContentPane().getLayout();
        card.show(this.getContentPane(), "goodsType_card");
    }//GEN-LAST:event_goodsTypeActionPerformed
    
    
    
    private void repo_examinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repo_examinActionPerformed

        String[] data = new String[4];

        data[0] = (String) s_year.getSelectedItem() + "-" + s_mon.getSelectedItem() + "-" + s_day.getSelectedItem();
        data[1] = (String) s_year1.getSelectedItem() + "-" + s_mon1.getSelectedItem() + "-" + s_day1.getSelectedItem();
        
        InOutRepoVO inout = null;
        try {
			inout = repoExaminBLservice.countInOut(data[0], data[1]);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(frame, "Can't connect to get data");
			e1.printStackTrace();
		}
        data[2] = inout.getSumOfIn().toString();
        data[3] = inout.getSumOfOut().toString();
        //show a dialog
        final Repo_examin_dialog dialog = new Repo_examin_dialog(frame, true, data);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                dialog.dispose();
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_repo_examinActionPerformed

    private void repo_receActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repo_receActionPerformed
        
        CardLayout card = (CardLayout) this.getContentPane().getLayout();
        card.show(this.getContentPane(), "repo_receipt_card");
    }//GEN-LAST:event_repo_receActionPerformed

    
    private void exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportActionPerformed
        
        JFileChooser exporter = new JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        exporter.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        exporter.setApproveButtonText("Export");
        exporter.setApproveButtonToolTipText("Export it to this path");
        exporter.setDialogTitle("Export excel to ...");
        exporter.setFileFilter(new FileFilter() {

            @Override
            public boolean accept(File f) {
                return f.getName().contains(".xls");
            }

            @Override
            public String getDescription() {
                return "Excel";
            }
        });
        
        int result = exporter.showSaveDialog(MainFrame.frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
				repoCheckBLservice.export();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame, "Repo Check fail to run export");
			}
        } else if (result == JFileChooser.CANCEL_OPTION) {
            export = null;
        }

    }//GEN-LAST:event_exportActionPerformed


    private void repo_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repo_checkActionPerformed
        try {
			repoCheckBLservice.checkAndSum();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "Repo Check fail to get data to CheckAndSum");
		}
    }//GEN-LAST:event_repo_checkActionPerformed

    private void log_outActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_outActionPerformed
        CardLayout card = (CardLayout) this.getContentPane().getLayout();
        card.show(this.getContentPane(), "log_card");
    }//GEN-LAST:event_log_outActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        update_bar.setIndeterminate(true);
        // TODO add logic
        
        // change back
        frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        update_bar.setIndeterminate(false);
    }//GEN-LAST:event_refreshActionPerformed

    private void s_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_yearActionPerformed
        s_monActionPerformed(evt);
    }//GEN-LAST:event_s_yearActionPerformed

    private void s_year1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_year1ActionPerformed
       s_mon1ActionPerformed(evt);
    }//GEN-LAST:event_s_year1ActionPerformed

    private void s_monPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_s_monPropertyChange
        
    }//GEN-LAST:event_s_monPropertyChange

    private void s_monActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_monActionPerformed
        
        int index = s_mon.getSelectedIndex() + 1;
        if (index == 1 || index == 3 || index == 5
                || index == 7 || index == 8 || index == 10
                || index == 12) {
            index = 1;
        } else if (index == 4 || index == 6 || index == 9
                || index == 11) {
            index = 0;
        } else {
            int temp = s_year.getSelectedIndex() + 2013;
            if (temp % 400 == 0 || (temp % 4 == 0 && temp % 100 != 0)) {
                index = 3;
            } else {
                index = 2;
            }
        }
        s_day.setModel(new javax.swing.DefaultComboBoxModel(day[index]));
    }//GEN-LAST:event_s_monActionPerformed

    private void s_mon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_mon1ActionPerformed
        int index = s_mon1.getSelectedIndex() + 1;
        if (index == 1 || index == 3 || index == 5
                || index == 7 || index == 8 || index == 10
                || index == 12) {
            index = 1;
        } else if (index == 4 || index == 6 || index == 9
                || index == 11) {
            index = 0;
        } else {
            int temp = s_year1.getSelectedIndex() + 2013;
            if (temp % 400 == 0 || (temp % 4 == 0 && temp % 100 != 0)) {
                index = 3;
            } else {
                index = 2;
            }
        }
        s_day1.setModel(new javax.swing.DefaultComboBoxModel(day[index]));
    }//GEN-LAST:event_s_mon1ActionPerformed

    
    /**
     * @param args the command line arguments
     */
    static JFrame frame;

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frame = new MainFrame();
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton export;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JPanel first;
    private javax.swing.JButton goodsList;
    private GoodsListPanel goodsListPanel1;
    private javax.swing.JButton goodsType;
    private GoodsTypePanel goodsTypePanel1;
    private javax.swing.JPanel goods_panel;
    private javax.swing.JButton goods_rece;
    private Goods_receipt_management goods_receipt1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private Log_in log_in1;
    private javax.swing.JButton log_out;
    private javax.swing.JLayeredPane others;
    private javax.swing.JPanel rece_panel;
    private javax.swing.JButton refresh;
    private javax.swing.JButton repo_check;
    private javax.swing.JButton repo_examin;
    private javax.swing.JPanel repo_panel;
    private javax.swing.JButton repo_rece;
    private Repo_Receipt_management repo_receipt1;
    private javax.swing.JComboBox s_day;
    private javax.swing.JComboBox s_day1;
    private javax.swing.JComboBox s_mon;
    private javax.swing.JComboBox s_mon1;
    private javax.swing.JComboBox s_year;
    private javax.swing.JComboBox s_year1;
    public static javax.swing.JTabbedPane tab_pane;
    private javax.swing.JToolBar tool;
    private javax.swing.JProgressBar update_bar;
    // End of variables declaration//GEN-END:variables
}
