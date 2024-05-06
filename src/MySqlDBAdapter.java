import properties.PropertiesUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MySqlDBAdapter implements IDBAdapter {
    private static final String _DB_PROPERTIES = "properties/DBMySQL";
    private static final String _DB_NAME_PROP = "dbname";
    private static final String _DB_HOST_PROP = "host";
    private static final String _DB_PORT_PROP = "port";
    private static final String _DB_PASSWORD_PROP = "password";
    private static final String _DB_USER_PROP = "user";

    @Override
    public Connection getConnection() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");

            String connectionString = createConnectionString();

            return DriverManager.getConnection(connectionString);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String createConnectionString() {
        Properties property = PropertiesUtil.loadProperty(_DB_PROPERTIES);
        assert property != null;
        String host = property.getProperty(_DB_HOST_PROP);
        String port = property.getProperty(_DB_PORT_PROP);
        String db = property.getProperty(_DB_NAME_PROP);
        String user = property.getProperty(_DB_USER_PROP);
        String password = property.getProperty(_DB_PASSWORD_PROP);

        return "jdbc:mariadb://" + host + ":" + port + "/" + db + "?user=" + user + "&password=" + password;
    }
}

