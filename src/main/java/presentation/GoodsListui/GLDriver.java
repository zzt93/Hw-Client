package presentation.GoodsListui;


import javax.swing.SwingUtilities;


public class GLDriver {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){

			public void run() {
				// TODO Auto-generated method stub
				new Gui();
			}
			
		});
	}
	
	
}
