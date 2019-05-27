package cn.percent;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

import bean.dbBean;
import biUtil.Md5;
import biUtil.TimeMarker;
import cn.percent.db.Mysql;
import cn.percent.db.Oracle;
import cn.percent.db.Postgre;
import cn.percent.db.Sqlserver;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConnDb {
    public static void main(String[] args) {
        /*读取json文件*/
        ObjectMapper dbjson = new ObjectMapper();
        try {
            dbBean db = dbjson.readValue(new File("src\\main\\resources\\DBJSON.json"), dbBean.class);
            String rdmsType = db.getRdmsConfig().getRdmsType();//获取数据库类型
            if(rdmsType.equals("MySQL")){
                Mysql mysql = new Mysql();
                mysql.Mysql(rdmsType);
            }
            if(rdmsType.equals("Sqlserver")){
                Sqlserver sqlserver = new Sqlserver();
                sqlserver.Sqlserver(rdmsType);
            }
            if(rdmsType.equals("Postgresql")){
                Postgre postgre = new Postgre();
                postgre.Postgre(rdmsType);
            }
            if(rdmsType.equals("Oracle")){
                Oracle oracle = new Oracle();
                oracle.Oracle(rdmsType);
            }else{
                System.out.println("请添加数据库类型");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
