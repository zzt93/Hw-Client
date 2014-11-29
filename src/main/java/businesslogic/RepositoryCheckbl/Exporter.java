package businesslogic.RepositoryCheckbl;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import po.RepoPO;
import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;


public class Exporter {

	private static String templateFileName = "repo_check.xls";
	private static String destFileName = "repo_check_output.xls";

	public void export_excel(RepoPO repo) throws ParsePropertyException,
			InvalidFormatException, IOException {
		HashMap<String, RepoPO> beans = new HashMap<String, RepoPO>();
		beans.put("repo", repo);
		XLSTransformer transformer = new XLSTransformer();
		transformer.transformXLS(templateFileName, beans, destFileName);
	}

}
