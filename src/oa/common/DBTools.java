package oa.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTools {

	static String driverName = "com.mysql.jdbc.Driver";//驱动程序名
    static String dbUrl = "jdbc:mysql://";//指向要访问的数据库名
    public static Connection connectToDB(String hostName,
            String dbName,String user,String pwd) throws Exception{//Connection代表与数据源 进行唯一的会话
        Connection conn = null;
        String connStr = dbUrl+hostName+"/"+dbName
                +"?user="+user+"&password="+pwd;
        loadDriver();
        try{
            conn = DriverManager.getConnection(connStr);//DriverManager类中的方法都是静态方法，所以无需实例化直接类名调用，在数据库的驱动程序之间建立链接。getConnection得到当前的Statement对象的Connection对象。
        }catch(SQLException e){
            System.out.println("连接数据库出错");
            e.printStackTrace();
        }catch(Exception e){
            System.out.println("出现了其他错误");
            e.printStackTrace();
        }
        return conn;
    }
    public static Connection connectToDB(){
        try {
            return connectToDB("localhost","oa","root","admin");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private static void loadDriver() {
        try {
            Class.forName(driverName).newInstance();//Class.forName运用反射的原理创建对象，newInstance()实例化这个对象 
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }      
    }
}
