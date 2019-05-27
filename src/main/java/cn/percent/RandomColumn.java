package cn.percent;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class RandomColumn {
    public String randomColumn(int columnNum){
        String[] column = {
                "id int","username varchar(255)","studentId int",
                "gender bit","age int","height int","weight int",
                "lateAccount int", "leaveAccount int","position varchar(255)",
                "grade varchar(255)","identification varchar(255)"};
        StringBuffer buf = new StringBuffer();
        HashSet<String> strSet = new HashSet<String>();
        Random rand=new Random();
//        int columnNum=(int)(Math.random()*100);
        while(strSet.size() < columnNum) {
            int randNum=rand.nextInt(column.length);
            String columnStr = column[randNum];
            strSet.add(columnStr);
        }
        Iterator<String> it = strSet.iterator();
        String str = "";
        while(it.hasNext()){
            str = str+it.next()+",";
        }
        str = str.substring(0,str.length()-1);
        return str;
    }
}
