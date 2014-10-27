package data.Clientdata;

import dataservice.Clientdataservice.ClientDataServiceImpl;
import po.ClientPO;
import po.ResultMessage;
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

    private static final String TABLE_NAME = "Client";
    private static final String NO_SUCH_ID = "No such id";
    private static final long serialVersionUID = 1L;

    public ClientUtility() throws RemoteException {
        super();
    }

    @Override
    public ResultMessage addClient(ClientPO clientPO) throws RemoteException {
        //id
        StringBuilder buffer = new StringBuilder("null");
        //ClientType
        buffer.append(',').append(clientPO.getType().ordinal());
        //ClientLevel
        buffer.append(',').append(clientPO.getLevel().ordinal());
        //name
        buffer.append(',').append('\'').append(clientPO.getName()).append('\'');
        //phone
        buffer.append(',').append('\'').append(clientPO.getPhone()).append('\'');
        //address
        buffer.append(',').append('\'').append(clientPO.getAddress()).append('\'');
        //zip
        buffer.append(',').append('\'').append(clientPO.getZip()).append('\'');
        //email
        buffer.append(',').append('\'').append(clientPO.getEmail()).append('\'');
        //upperBound
        buffer.append(',').append(clientPO.getUpperBound().doubleValue());
        //toReceive
        buffer.append(',').append(clientPO.getToReceive().doubleValue());
        //toPay
        buffer.append(',').append(clientPO.getToPay().doubleValue());
        //defaultSalesMan
        buffer.append(',').append('\'').append(clientPO.getDefaultSalesMan()).append('\'');
        try {
            int i = insert(TABLE_NAME, buffer.toString());
            if (i != 1)
                throw new SQLException(String.valueOf(i) + " rows affected");
        } catch (SQLException e) {
            return new ResultMessage<Object>(e.getMessage(), null);
        }
        return ResultMessage.noErr;
    }

    @Override
    public ResultMessage deleteClient(int id) throws RemoteException {
        try {
            int i = delete(TABLE_NAME, "id=" + id);
            if (i != 1)
                if (i == 0) {
                    throw new SQLException(NO_SUCH_ID);
                } else {
                    throw new SQLException(String.valueOf(i) + " rows affected");
                }
        } catch (SQLException e) {
            return new ResultMessage<Object>(e.getMessage(), null);
        }
        return ResultMessage.noErr;
    }

    @Override
    public ResultMessage modifyClient(ClientPO newClientPO) throws RemoteException {
        StringBuilder buffer = new StringBuilder();
        buffer.append("type=").append(newClientPO.getType().ordinal()).append(',');
        buffer.append("level=").append(newClientPO.getLevel().ordinal()).append(',');
        buffer.append("name='").append(newClientPO.getName()).append("',");
        buffer.append("phone='").append(newClientPO.getPhone()).append("',");
        buffer.append("address='").append(newClientPO.getAddress()).append("',");
        buffer.append("zip='").append(newClientPO.getZip()).append("',");
        buffer.append("email='").append(newClientPO.getEmail()).append("',");
        buffer.append("upperBound=").append(newClientPO.getUpperBound().doubleValue()).append(',');
        buffer.append("defaultSalesMan='").append(newClientPO.getDefaultSalesMan());
        try {
            int i = MySQLUtility.update(TABLE_NAME, buffer.toString(), "id=" + newClientPO.getId());
            if (i != 1)
                if (i == 0) {
                    throw new SQLException(NO_SUCH_ID);
                } else {
                    throw new SQLException(String.valueOf(i) + " rows affected");
                }
        } catch (SQLException e) {
            return new ResultMessage<Object>(e.getMessage(), null);
        }
        return ResultMessage.noErr;
    }

    @Override
    public ResultMessage<ClientPO> queryClientById(int id) throws RemoteException {
        try {
            ResultSet result = query("select * from " + TABLE_NAME + " where id=" + id + ";");
            if (!result.next())
                throw new SQLException(NO_SUCH_ID);
            ClientPO clientPO = new ClientPO(result);
            return new ResultMessage<>(null, clientPO);
        } catch (SQLException e) {
            return new ResultMessage<>(e.getMessage(), null);
        }
    }

    @Override
    public ResultMessage<Vector<ClientPO>> queryClient(Vector<String> filters) throws RemoteException {
        StringBuilder buffer = new StringBuilder("select * from ").append(TABLE_NAME);
        if (filters != null && !filters.isEmpty()) {
            buffer.append(" where ");
            for (String str : filters) {
                buffer.append('(').append(str).append(')').append(" and ");
            }
            int length = buffer.length();
            buffer.delete(length - 5, length);
        }
        buffer.append(';');
        try {
            ResultSet result = query(buffer.toString());
            Vector<ClientPO> clientPOVector = new Vector<>();
            while (result.next()) {
                clientPOVector.add(new ClientPO(result));
            }
            return new ResultMessage<>(null, clientPOVector);
        } catch (SQLException e) {
            return new ResultMessage<>(e.getMessage(), null);
        }
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
