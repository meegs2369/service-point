package com.movedtoatlanta.connectors.data;

public class ConnectionStrings {
    private String msSqlPrefix = "jdbc:sqlserver://";
    private String postgreSqlPrefix = "jdbc:postgresql://";

    public static String buildMssqlUrl(String host, String db, String port) {
        return (port != null) ? portedMssql(host, db, port) : namedMssqlInstance(host, db);
    }

    public static String buildMssqlUrl(String host, String db) {
        return buildMssqlUrl(host, db, null);
    }

    public static String buildPostGresUrl(String host, String db, String port) {
        return "jdbc:postgresql://" + host + ":" + port + "/" + db;
    }

    private static String portedMssql(String host, String db, String port) {

        return "jdbc:sqlserver://" + host + ":" + port + ";databaseName=" + db;
    }

    private static String namedMssqlInstance(String host, String db) {
        return "jdbc:sqlserver://" + host + ";databaseName=" + db;
    }

    private String buildConnectionString(String host, String db, String port, DB_TYPE type) {
        return (type == DB_TYPE.MSSQL) ? msSqlPrefix + host + ":" + port + ";databaseName=" + db : postgreSqlPrefix + host + ":" + port + "/" + db;
    }
}
