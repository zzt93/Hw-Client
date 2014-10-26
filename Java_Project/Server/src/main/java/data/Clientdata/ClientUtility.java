package data.Clientdata;

import dataservice.Clientdataservice.ClientDataServiceImpl;
import po.*;
import util.MySQLUtility;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import static util.MySQLUtility.*;

/**
 * Created by Nifury on 2014/10/25.
 */
public class ClientUtility extends UnicastRemoteObject implements ClientDataServiceImpl, Observer {

    private static final String tableName = "Client";

    public ClientUtility() throws RemoteException {
        super();
    }

    @Override
    public ResultMessage addClient(Client client) throws RemoteException {
        //id
        StringBuffer buffer = new StringBuffer("null");
        //ClientType
        buffer.append(',').append(client.getType().ordinal());
        //ClientLevel
        buffer.append(',').append(client.getLevel().ordinal());
        //name
        buffer.append(',').append('\'').append(client.getName()).append('\'');
        //phone
        buffer.append(',').append('\'').append(client.getPhone()).append('\'');
        //address
        buffer.append(',').append('\'').append(client.getAddress()).append('\'');
        //zip
        buffer.append(',').append('\'').append(client.getZip()).append('\'');
        //email
        buffer.append(',').append('\'').append(client.getEmail()).append('\'');
        //upperBound
        buffer.append(',').append(client.getUpperBound().doubleValue());
        //toReceive
        buffer.append(',').append(client.getToReceive().doubleValue());
        //toPay
        buffer.append(',').append(client.getToPay().doubleValue());
        //defaultSalesMan
        buffer.append(',').append('\'').append(client.getDefaultSalesMan()).append('\'');
        try {
            int i = insert(tableName, buffer.toString());
            if (i != 1)
                throw new SQLException(String.valueOf(i) + " rows affected");
        } catch (SQLException e) {
            return new ResultMessage<Object>(e.getMessage(), null);
        }
        return ResultMessage.noErr;
    }

    @Override
    public ResultMessage deleteClient(String id) throws RemoteException {
        try {
            int i = delete(tableName, "id=" + id);
            if (i != 1)
                if (i == 0) {
                    throw new SQLException("id not found");
                } else {
                    throw new SQLException(String.valueOf(i) + " rows affected");
                }
        } catch (SQLException e) {
            return new ResultMessage<Object>(e.getMessage(), null);
        }
        return ResultMessage.noErr;
    }

    @Override
    public ResultMessage modifyClient(Client newClient) throws RemoteException {
        StringBuffer buffer = new StringBuffer();
        buffer.append("type=").append(newClient.getType().ordinal()).append(',');
        buffer.append("level=").append(newClient.getLevel().ordinal()).append(',');
        buffer.append("name='").append(newClient.getName()).append("',");
        buffer.append("phone='").append(newClient.getPhone()).append("',");
        buffer.append("address='").append(newClient.getAddress()).append("',");
        buffer.append("zip='").append(newClient.getZip()).append("',");
        buffer.append("email='").append(newClient.getEmail()).append("',");
        buffer.append("upperBound=").append(newClient.getUpperBound().doubleValue()).append(',');
        buffer.append("toReceive=").append(newClient.getToReceive().doubleValue()).append(',');
        buffer.append("toPay=").append(newClient.getToPay().doubleValue()).append(',');
        buffer.append("defaultSalesMan='").append(newClient.getDefaultSalesMan());
        try {
            int i = MySQLUtility.update(tableName, buffer.toString(), "id=" + newClient.getId());
            if (i != 1)
                if (i == 0) {
                    throw new SQLException("id not found");
                } else {
                    throw new SQLException(String.valueOf(i) + " rows affected");
                }
        } catch (SQLException e) {
            return new ResultMessage<Object>(e.getMessage(), null);
        }
        return ResultMessage.noErr;
    }

    @Override
    public ResultMessage<Client> queryClientById(String id) throws RemoteException {
        try {
            ResultSet result = query("select * from " + tableName + " where id=" + id);
            Client client = new Client(result.getString(1), ClientType.values()[result.getInt(2)],
                    ClientLevel.values()[result.getInt(3)],
                    result.getString(4), result.getString(5), result.getString(6),
                    result.getString(7), result.getString(8), result.getBigDecimal(9),
                    result.getBigDecimal(10), result.getBigDecimal(11), result.getString(12));
            return new ResultMessage<>(null, client);
        } catch (SQLException e) {
            return new ResultMessage<>(e.getMessage(), null);
        }
    }

    @Override
    public ResultMessage<Vector<Client>> queryClient(Vector<ClientFilter> filters) throws RemoteException {
        return null;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
