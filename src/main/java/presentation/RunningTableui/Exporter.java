package presentation.RunningTableui;

import java.io.*;   

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import jxl.*;   
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Number;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Exporter {
	private JTable table;
	private JProgressBar progressBar;
	private File excel;
	public Exporter(JTable table,JProgressBar progressBar){
		this.table=table;
		this.progressBar=progressBar;
		select();
	}
	public Exporter(){
		
	}
	public String select(){
		JFileChooser exporter = new JFileChooser();
		//设置选择框
		exporter.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
		exporter.setApproveButtonText("Export");
		exporter.setApproveButtonToolTipText("Export it to this path");
		exporter.setDialogTitle("Export excel to ...");
		exporter.setFileFilter(new FileFilter() {

			public boolean accept(File f) {
				return f.getName().contains(".xls");
			}

			public String getDescription() {
				return "Excel";
			}
		});
		//处理选择
		int result = exporter.showSaveDialog(exporter);
		if (result == JFileChooser.APPROVE_OPTION) {
			//TODO,获得路径开始写入
			File tempFile=exporter.getSelectedFile();
			if(!tempFile.getName().endsWith(".xls")){
				excel=new File(tempFile.getParent(),tempFile.getName()+".xls");
			}else{
				excel=tempFile;
			}
			if(excel.exists()){
				JOptionPane.showMessageDialog(null, "已存在同名文件");
				return null;
			}else{
				//TODO,调用creatExcel
				new Thread(new Runnable(){
					public void run() {
						createExcel(excel);
					}
					
				}).start();;
				return excel.getPath();
			}
		} else if (result == JFileChooser.CANCEL_OPTION) {
			//取消
			return null;
		}
		return null;
	}
	private void createExcel(File file){
		try {
			WritableWorkbook book=Workbook.createWorkbook(file);
			WritableSheet sheet=book.createSheet("firse page",0);
			int rowNum=table.getRowCount();
			int columnNum=table.getColumnCount();
			progressBar.setMaximum(rowNum);
			
			sheet.getSettings().setDefaultColumnWidth(20);
			try {
				for(int j=0;j<columnNum;j++){
					Label label=new Label(j,0,table.getColumnName(j));
					sheet.addCell(label);
				}
				for(int i=1;i<rowNum+1;i++){
					for(int j=0;j<columnNum;j++){
						Label label=new Label(j,i,String.valueOf(table.getValueAt(i-1, j)));
						sheet.addCell(label);
					}
					progressBar.setValue(i);
				}
				
			} catch (RowsExceededException e) {
				JOptionPane.showMessageDialog(null, "行数溢出");
				e.printStackTrace();
			} catch (WriteException e) {
				JOptionPane.showMessageDialog(null, "写文件时发生错误");
				e.printStackTrace();
			}
			book.write();
			book.close();
			JOptionPane.showMessageDialog(null, "Excel导出完毕");
			progressBar.setValue(0);
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "导出EXCEL的过程中遇到了问题");
			e.printStackTrace();
		}
		
	}
	

}
