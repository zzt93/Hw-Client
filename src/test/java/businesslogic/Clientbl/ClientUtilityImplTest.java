package businesslogic.Clientbl;

import businesslogicservice.Clientblservice.ClientUtility;
import org.junit.BeforeClass;
import org.junit.Test;
import po.ClientLevel;
import po.ClientPO;
import po.ClientType;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClientUtilityImplTest {

    private ClientUtility impl;
    private int id;
    private ClientPO client;

    @BeforeClass
    public void testBeforeClass() {
        try {
            impl = new ClientUtilityImpl();
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddClient() throws Exception {
        client = new ClientPO(ClientType.SELLER, ClientLevel.LEVEL1, "name", "123456789", "addr", "210046", "email",
                "default");
        id = impl.addClient(client);
        ClientPO tmp = impl.queryClientById(id);
        assertEquals(tmp.getName(), "name");
    }

    @Test
    public void testModifyClient() throws Exception {
        ClientPO tmp = impl.queryClientById(id);
        tmp.setName("test");
        impl.modifyClient(tmp);
        tmp = impl.queryClientById(id);
        assertEquals(tmp.getName(), "test");
    }

    @Test
    public void testDeleteClient() throws Exception {
        impl.deleteClient(id);
        try {
            impl.queryClientById(id);
            assertTrue(false);
        } catch (Exception e) {
        }
    }
}