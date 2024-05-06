import properties.PropertiesUtil;

import java.util.Properties;

public class DBFactory {
    private static final String _DB_FACTORY_PROPERTY_URL = "properties/DBFactory";
    private static final String _DEFAULT_DB_CLASS_PROP = "defaultDBClass";

    public IDBAdapter getDBAdapter(DBType dbType) {
        if (dbType == DBType.MySql) {
            return new MySqlDBAdapter();
        } else if (dbType == DBType.Oracle) {
            return new OracleDBAdapter();
        } else {
            throw new IllegalArgumentException("No soportado");
        }
    }

    public IDBAdapter getDefaultDBAdapter() {
        try {
            Properties property = PropertiesUtil.loadProperty(_DB_FACTORY_PROPERTY_URL);
            String defaultDBClass = property.getProperty(_DEFAULT_DB_CLASS_PROP);
            return (IDBAdapter) Class.forName(defaultDBClass).getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}


