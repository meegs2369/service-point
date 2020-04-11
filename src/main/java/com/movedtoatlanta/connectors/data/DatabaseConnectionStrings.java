package com.movedtoatlanta.connectors.data;

public class DatabaseConnectionStrings {
    private String msSqlPrefix = "jdbc:sqlserver://";
    private String postgreSqlPrefix = "jdbc:postgresql://";
    private String msSqlDbIndicator = ";databaseName=";

    public static String getMSString(String host, String db, String port) {
        return new DatabaseConnectionStrings().buildMssqlUrl(host, db, port);
    }

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
        return msSqlPrefix + host + msSqlDbIndicator + db;
    }

    private String buildConnectionString(String host, String db, String port, DB_TYPE type) {
        return (type == DB_TYPE.MSSQL) ? msSqlPrefix + host + ":" + port + msSqlDbIndicator + db : postgreSqlPrefix + host + ":" + port + "/" + db;
    }
}
