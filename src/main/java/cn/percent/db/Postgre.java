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
/*bug:
* 无法指定数据库*/
public class Postgre {
    public void Postgre(String rdmsType){
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
                for (int i = 0; i < scNumber; i++) {
                    uid = UUID.randomUUID().toString().replace("-", "").toLowerCase();//java自带方法生成uuid
                    String uid1 = md5.md5(uid);
                    String createScName = rdmsType+"_SCHEMA_"+uid1+"_"+tm.timer();
                    if( scName.size() != calNumber) {
                        scName.add(createScName);
                    }
                    String createSC = "CREATE SCHEMA "+createScName;
                System.out.println(createSC);
                    dbStmt.executeUpdate(createSC);
                }
            /*while(it.hasNext()){
                String showDbName = it.next();
                System.out.println("---"+showDbName);
            }*/
            /*dbStmt.close();
            conn.close();*/
                /*建schema，获取操作schema名完成*/
                /*建表*/
                int tNumber = db.getRdmsConfig().getDbConfig().getTableConfig().getTableNumber();//总表数量
                double tRatio = db.getRdmsConfig().getDbConfig().getTableConfig().getTableRatio();
                int specialTableNum = (int)Math.ceil(tNumber*tRatio);//特殊表数量
                int normalTableNum = tNumber - specialTableNum;//普通表数量
                int columnNumber = db.getRdmsConfig().getDbConfig().getTableConfig()
                        .getColumnConfig().getMinNumber();//字段数量
                Iterator<String> it = scName.iterator();//迭代器
                while(it.hasNext()){//每次建表从此循环
                    //stmt.execute("use"+it.next());
//                url = db.getRdmsConfig().getConnectionInfo()+it.next();//重新建立conn，用来选择数据库
                    System.out.println(url);
                    conn = DriverManager.getConnection(url, user, password);
                    Statement tbStmt = conn.createStatement();
                    RandomColumn randColumn = new RandomColumn();
                    String schema = it.next();
                    for (int i = 0; i < normalTableNum; i++) {
                        uid = UUID.randomUUID().toString().replace("-", "").toLowerCase();//java自带方法生成uuid
                        String uid1 = md5.md5(uid);
                        String tableName = rdmsType+"_tb_"+uid1+"_"+tm.timer();//表名
                        System.out.println("table:"+tableName);
                        String randColumnStr = randColumn.randomColumn(columnNumber);//要创建的字段
//                    System.out.println(randColumnStr);
                        String tbsql = "CREATE TABLE "+schema+"."+tableName+" ("+randColumnStr+")";
                        System.out.println("tbsql:"+tbsql);
                        tbStmt.execute(tbsql);
                    }
                    tbStmt.close();
                    conn.close();
                }
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }catch(SQLException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
