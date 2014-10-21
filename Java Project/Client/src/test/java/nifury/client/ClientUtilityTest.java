package nifury.client;

import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.*;

public class ClientUtilityTest {

    static ClientUtilityImpl f = new ClientUtility();

    @Test
    public void testAddClient() throws Exception {
        Client client = new Client(null, null, "test", "123456", "addr", "210046", "a@a.com", "a");
        String id = client.getId();
        f.addClient(client);
        ClientFilter filter[] = new ClientFilter[1];
        filter[0] = new ClientFilter("name", "test");
        Vector<Client> result = f.queryClient(filter);
        assertNotNull(result);
        client = result.get(0);
        assertEquals(client.getName(), "test");
        assertEquals(client.getAddress(), "addr");

        client = f.queryClientById(id);
        assertEquals(client.getName(), "test");
        assertEquals(client.getAddress(), "addr");
    }

    @Test
    public void testDeleteClient() throws Exception {
        Client client = new Client(null, null, "test", "123456", "addr", "210046", "a@a.com", "a");
        f.addClient(client);
        String id = client.getId();
        f.deleteClient(id);
        assertNull(f.queryClientById(id));
    }

    @Test
    public void testModifyClient() throws Exception {
        Client client = new Client(null, null, "test", "123456", "addr", "210046", "a@a.com", "a");
        f.addClient(client);
        String id = client.getId();
        Client result = f.queryClientById(id);
        client.setName("shit");
        //也测试了clone
        assertEquals(result.getName(), "test");
        f.modifyClient(client);
        assertEquals(result.getName(), "test");
        result = f.queryClientById(id);
        assertEquals(result.getName(), "shit");
    }
}