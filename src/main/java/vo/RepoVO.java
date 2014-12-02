package vo;
/**
 * this class save the information of every check 
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class RepoVO implements Serializable {
	long batch;
	String batchNum;
	HashMap<String, ArrayList<GoodsVO>> goodsListMap;
	private static final long serialVersionUID = 1L;
}
