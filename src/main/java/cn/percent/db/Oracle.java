package cn.percent.db;

import bean.dbBean;
import biUtil.Md5;
import biUtil.TimeMarker;
import cn.percent.ParamSelector;
import cn.percent.RandomColumn;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

public class Oracle {
    public void Oracle(String rdmsType){
        /*读取json文件*/
        ObjectMapper dbjson = new ObjectMapper();

        try {
            dbBean db = dbjson.readValue(new File("src\\main\\resources\\DBJSON.json"), dbBean.class);
//            String rdmsType = db.getRdmsConfig().getRdmsType();//获取数据库类型
            int dbNumber = db.getRdmsConfig().getDbConfig().getDbnumber();//获取数据库数量
            int scNumber = db.getRdmsConfig().getDbConfig().getSchemaConfig().getScNumber();//schema数量
            double dbRatio = db.getRdmsConfig().getDbConfig().getAppointConfig().getRatio();//获取建表的schema的比例
            int calNumber = (int) Math.ceil(scNumber * dbRatio);//需要建表的schema的数量

            String url = db.getRdmsConfig().getConnectionInfo();//数据库连接URL
            String user = db.getRdmsConfig().getUsername();//用户名
            String password = db.getRdmsConfig().getPassword();//密码

            ParamSelector ps = new ParamSelector();//选择driver接口
            String driver = ps.selectDriver(rdmsType);
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement dbStmt = conn.createStatement();
            Md5 md5 = new Md5();
//          UIDCreator uidCreator = new UIDCreator();
            String uid;
            TimeMarker tm = new TimeMarker();
            HashSet<String> scName = new HashSet<>();//存放需要建表的库/schema的名称
            /*String testsql = "CREATE TABLESPACE TSBTEST datafile /'//opt//u01//app//oracle//oradata//orcl//tsptest/' size 10M;";
            dbStmt.execute(testsql);
            testsql = "CREATE USER \"BI_TEST\" IDENTIFIED BY \"123\" DEFAULT TABLESPACE \"BI_TSB\" TEMPORARY TABLESPACE \"TEMP\"";
            dbStmt.execute(testsql);
            testsql = "grant connect,resource to bi_user";
            dbStmt.execute(testsql);*/
            String testsql = "CREATE TABLE T2(id int)";
            dbStmt.execute(testsql);

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
