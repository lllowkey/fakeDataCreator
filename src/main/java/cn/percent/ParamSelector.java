package cn.percent;

public class ParamSelector {
    public String selectDriver(String rdmsType){
        String driver = null;
        switch(rdmsType) {
            case ("MySQL"):
                driver = "com.mysql.jdbc.Driver";
                break;
            case ("Postgresql"):
                driver = "org.postgresql.Driver";
                break;
            case ("Sqlserver"):
                driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                break;
            case ("Oracle"):
                driver = "oracle.jdbc.driver.OracleDriver";
                break;
        }
        return driver;
    }
}
