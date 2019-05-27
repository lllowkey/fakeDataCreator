package cn.percent;

import java.util.Random;

public class test {
    public static void main(String[] args) {
        /*int i = 8;
        double j = 0.3;
        int ij = (int)Math.ceil(i*j);
        System.out.println(ij);*/
        Random rand=new Random();
//        int columnNum=(int)(Math.random()*100);
        int randNum=rand.nextInt(20);
        System.out.println(randNum);
        StringBuffer buff = new StringBuffer("0123456789");
        System.out.println("buff="+buff);
        String buff1 = buff.toString();
        int a = 1;
        int b = a+++a;
        System.out.println(b);
    }
}
