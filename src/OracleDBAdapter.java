import properties.PropertiesUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class OracleDBAdapter implements IDBAdapter {
    private static final String _DB_PROPERTIES = "properties/DBOracle";
    private static final String _DB_SERVICE_PROP = "service";
    private static final String _DB_HOST_PROP = "host";
    private static final String _DB_PASSWORD_PROP = "password";
    private static final String _DB_PORT_PROP = "port";
    private static final String _DB_USER_PROP = "user";

    @Override
    public Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String connectionString = createConnectionString();
            return DriverManager.getConnection(connectionString);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String createConnectionString() {
        Properties prop = PropertiesUtil.loadProperty(_DB_PROPERTIES);
        System.out.println("PROP: " + prop);
        String host = prop.getProperty(_DB_HOST_PROP);
        String port = prop.getProperty(_DB_PORT_PROP);
        String service = prop.getProperty(_DB_SERVICE_PROP);
        String user = prop.getProperty(_DB_USER_PROP);
        String password = prop.getProperty(_DB_PASSWORD_PROP);
        return "jdbc:oracle:thin:" + user + "/" + password + "@//" + host + ":" + port + "/" + service;
    }
}

