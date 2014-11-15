package vo;
/**
 * this class save the information of every check 
 */
import java.util.ArrayList;
import java.util.HashMap;

public class RepoVO {
	long batch;
	String batchNum;
	HashMap<String, ArrayList<GoodsVO>> goodsListMap;
}
