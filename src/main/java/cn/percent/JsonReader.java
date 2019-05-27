package cn.percent;

import bean.dbBean;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

/**
 * Hello world!
 *
 */
public class JsonReader {
    public JsonReader() {
        ObjectMapper dbjson = new ObjectMapper();
        try {
            dbBean db = dbjson.readValue(new File("src\\main\\resources\\DBJSON.json"), dbBean.class);
            int dbNumber = db.getRdmsConfig().getDbConfig().getDbnumber();//获取数据库数量
            double dbRatio = db.getRdmsConfig().getDbConfig().getAppointConfig().getRatio();//获取建表的库的比例
            int calNumber = (int) Math.ceil(dbNumber * dbRatio);
//            System.out.println("dbNumber" + dbNumber);
//            System.out.println("dbRatio" + dbRatio);
//            System.out.println("calNumer" + calNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Hello World!");
    }
}
