package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ObjectPoolTester {
}

abstract class ObjectPool<T> {

    public final int MAX_COUNT = 5;

    List<T> availableObjects = new ArrayList<>();
    List<T> usedObjects = new ArrayList<>();

    abstract void createObject();

    abstract T getObject();

    abstract void releaseObject(T t);

    public List<T> getAvailableObjects() {
        return availableObjects;
    }

    public void setAvailableObjects(List<T> availableObjects) {
        this.availableObjects = availableObjects;
    }

    public List<T> getUsedObjects() {
        return usedObjects;
    }

    public void setUsedObjects(List<T> usedObjects) {
        this.usedObjects = usedObjects;
    }
}

class JdbcConnectionPool extends ObjectPool<Connection> {

    private String url;
    private String username;
    private String password;

    public JdbcConnectionPool(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

     void createObject() {
        try {
            for (int i = availableObjects.size(); i < MAX_COUNT; i++) {
                Connection conn = DriverManager.getConnection(url, username, password);
                availableObjects.add(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    Connection getObject() {

        if (availableObjects.size() != 0) {
            return availableObjects.remove(0);
        }
        return null;
    }

    @Override
    void releaseObject(Connection connection) {
        if (connection != null) {
            availableObjects.add(connection);
        }
    }
}

class ConnectionFactory<T> {

    public void provisionObjects() {
        ObjectPool<Connection> objectPool = new JdbcConnectionPool("", "", "");
        objectPool.createObject();
    }

}