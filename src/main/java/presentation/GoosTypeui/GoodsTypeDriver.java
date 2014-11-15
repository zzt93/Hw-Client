package presentation.GoosTypeui;

import javax.swing.SwingUtilities;

public class GoodsTypeDriver {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				new Gui();
			}

		});
	}

}
