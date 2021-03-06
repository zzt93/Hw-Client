package businesslogic.GoodsTypebl;

import businesslogic.GoodsListbl.GL_controller;
import businesslogicservice.GoodsTypeblservice.GTBLservice;
import businesslogicservice.GoodsTypeblservice.GT_GL_BLservice;
import dataservice.GoodsTypedataservice.GoodsTypeDateService;
import po.GoodsListPO;
import po.ResultMessage;
import po.TreeNodePO;
import presentation.RepoUI.MainFrame;
import util.RMIUtility;
import vo.TreeNodeVO;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class GT_controller implements GT_GL_BLservice, GTBLservice {

    GoodsTypeDateService goodsTypeDateService;

    GTBLservice gtbLservice;
    GT_GL_BLservice gt_gl_BLservice;

    /*
     * for cross modules invoke
     */


    ArrayList<TreeNodePO> treeNodePOs = new ArrayList<TreeNodePO>();
    static String gt_service = "goods type data service";

    public ArrayList<TreeNodePO> getTreeNodePOs() {
        return treeNodePOs;
    }

    public GT_controller() throws Exception {
        goodsTypeDateService = (GoodsTypeDateService) RMIUtility.getImpl(gt_service);

        if (MainFrame.DEBUG) {
            treeNodePOs = new ArrayList<TreeNodePO>();
        } else {
            ResultMessage<ArrayList<TreeNodePO>> message = goodsTypeDateService.getGoodsTypde();
            message.throwIfFailed();
            treeNodePOs = message.getObj();
        }

        if (treeNodePOs.size() == 0) {
            TreeNodePO root = new TreeNodePO("Light/灯");
            treeNodePOs.add(root);
            goodsTypeDateService.insert(root);
        }
        initial_list();
        gtbLservice = new GTBLImpl(treeNodePOs);
        gt_gl_BLservice = new GT_GL_BLImpl(treeNodePOs);


    }

    private void initial_list() {
        for (int i = 0; i < treeNodePOs.size(); i++) {
            TreeNodePO temp = treeNodePOs.get(i);
            for (int j = 0; j < treeNodePOs.size(); j++) {//skip the first root node
                TreeNodePO son = treeNodePOs.get(j);
                if (son.getFa() == null){
                    continue;
                }
                if (son.getFa().equals(temp)) {
                    temp.getSons().add(son);
                }
            }
        }
    }

    public boolean add(TreeNodePO node) throws Exception {

        boolean res = goodsTypeDateService.insert(node).getObj();
        if (res) {
            gtbLservice.add(node);
        }
        return res;
    }

    public boolean check_ever_has(String type) {
        for (TreeNodePO treeNodePO : treeNodePOs) {
            if (type.equals(treeNodePO.getType_so_far())) {
                return treeNodePO.getGoodsModels().size() > 0;
            }
        }
        return false;
    }

    public boolean update(TreeNodePO tNode) throws Exception {
        boolean res = gtbLservice.update(tNode);
        if (res) {
            goodsTypeDateService.update(tNode);
        }
        return res;
    }

    public boolean delete(TreeNodePO tNode) throws Exception {
        boolean res = gtbLservice.delete(tNode);
        if (res) {
            goodsTypeDateService.delete(tNode);
        }
        return res;
    }

    public TreeNodePO eSearch(String id) throws Exception {
        return gtbLservice.eSearch(id);
    }

    public ArrayList<TreeNodePO> show() throws Exception {
        return gtbLservice.show();
    }


    public ArrayList<String> addable_type() throws RemoteException {
        return gt_gl_BLservice.addable_type();
    }

    public void update_nodelist(ArrayList<TreeNodeVO> treeNodes,
                                GoodsListPO goodsListPO) throws Exception {
        gt_gl_BLservice.update_nodelist(treeNodes, goodsListPO);
        goodsTypeDateService.update(null);
    }

    public int height() {
        int height = 0;
        TreeNodePO fa = treeNodePOs.get(0);
        return travel(fa, 0);
    }

    private int travel(TreeNodePO po, int i) {
        if (po == null) {
            return i;
        } else {
            if (po.getSons().size() == 0) {
                return i + 1;
            }
            int max = 0;
            for (TreeNodePO treeNodePO : po.getSons()) {
                int temp = travel(treeNodePO, i + 1);
                if (max < temp) {
                    max = temp;
                }
            }
            return max;
        }
    }
}
