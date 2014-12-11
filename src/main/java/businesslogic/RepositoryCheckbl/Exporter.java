package businesslogic.RepositoryCheckbl;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import po.RepoPO;

import java.io.IOException;
import java.util.HashMap;


public class Exporter {

	private static String templateFileName = "repo_check.xls";

	public void export_excel(RepoPO repo, String destFileName) throws ParsePropertyException,
			InvalidFormatException, IOException {
		HashMap<String, RepoPO> beans = new HashMap<String, RepoPO>();
		beans.put("repo", repo);
		XLSTransformer transformer = new XLSTransformer();
		transformer.transformXLS(templateFileName, beans, destFileName);
	}

}
