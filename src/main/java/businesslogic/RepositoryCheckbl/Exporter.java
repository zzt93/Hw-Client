package businesslogic.RepositoryCheckbl;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;
import po.GoodsListPO;
import po.RepoPO;
import po.RepoPO.RepoGoods;

public class Exporter {
	

	private static String templateFileName = "adjacentlists.xls";
    private static String destFileName = "adjacentlists_output.xls";
    
    
	public void export_excel(RepoPO repo_check) throws ParsePropertyException, InvalidFormatException, IOException{
        HashMap<String, RepoGoods> beans = repo_check.getRepoGoods();
        
        XLSTransformer transformer = new XLSTransformer();
        transformer.transformXLS(templateFileName, beans, destFileName);
	}
	
	public static void main(String[] args) {
		try {
			new Exporter().export_excel(null);
		} catch (ParsePropertyException | InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
