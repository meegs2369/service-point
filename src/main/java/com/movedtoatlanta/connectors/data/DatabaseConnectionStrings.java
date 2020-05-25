package com.movedtoatlanta.connectors.data;

/**
 * Class returns common database connection urls as strings.
 */
public class DatabaseConnectionStrings {
    private static final String MS_SQL_PREFIX = "jdbc:sqlserver://";
    private static final String POSTGRESQL_PREFIX = "jdbc:postgresql://";
    private static final String DATABASE_NAME = ";databaseName=";

    private DatabaseConnectionStrings() {
    }

    /**
     * Method to return an MsSQL url.
     *
     * @param host String
     * @param db   String
     * @param port String
     * @return String
     */
    public static String getMSString(String host, String db, String port) {
        return new DatabaseConnectionStrings().buildMssqlUrl(host, db, port);
    }

    /**
     * Method to return an PostgresSQL url.
     *
     * @param host String
     * @param db   String
     * @param port String
     * @return String
     */
    public static String getPGString(String host, String db, String port) {
        return new DatabaseConnectionStrings().buildPostGresUrl(host, db, port);
    }

    private String buildMssqlUrl(String host, String db, String port) {
        return (port != null && !port.isEmpty()) ? portedMssql(host, db, port) : namedMssqlInstance(host, db);
    }

    private String buildPostGresUrl(String host, String db, String port) {
        return buildConnectionString(host, db, port, DB_TYPE.POSTGRESQL);
    }

    private String portedMssql(String host, String db, String port) {
        return buildConnectionString(host, db, port, DB_TYPE.MSSQL);
    }

    private String namedMssqlInstance(String host, String db) {
        return MS_SQL_PREFIX + host + DATABASE_NAME + db;
    }

    private String buildConnectionString(String host, String db, String port, DB_TYPE type) {
        return (type == DB_TYPE.MSSQL) ? MS_SQL_PREFIX + host + ":" + port + DATABASE_NAME + db : POSTGRESQL_PREFIX + host + ":" + port + "/" + db;
    }
}
