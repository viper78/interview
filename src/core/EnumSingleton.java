package core;

public class EnumSingleton {


    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton.name());
        System.out.println(singleton1.name());
        System.out.println(singleton2);
    }
}

enum Singleton
{
    INSTANCE;
    // instance vars, constructor

    private final Connection connection;

    Singleton()
    {
        // Initialize the connection
        connection = getConnection();
    }

    // Static getter
    public static Singleton getInstance()
    {
        return INSTANCE;
    }

    public Connection getConnection()
    {
        return connection;
    }
}

class Connection {

}
