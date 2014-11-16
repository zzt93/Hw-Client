package presentation.Clientui;

import businesslogicservice.Clientblservice.ClientUtility;
import po.ClientPO;

/**
 * Created by Nifury on 2014/10/25.
 */
public class ClientBLService_Driver {

    private static ClientPO clientPO = new ClientPO(null, null, "name",
            "phone", "addr", "zip", "email", null);

    public void drive(ClientUtility impl) {
        try {
            impl.addClient(clientPO);
            System.out.println("add client");
            impl.deleteClient(clientPO.getId());
            System.out.println("delete client");
            clientPO.setName("shit");
            impl.modifyClient(clientPO);
            System.out.println("modify client");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ClientUtility impl = new ClientBLService_Stub();
        ClientBLService_Driver driver = new ClientBLService_Driver();
        driver.drive(impl);
    }
}
