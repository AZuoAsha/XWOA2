package oa.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTools {

	static String driverName = "com.mysql.jdbc.Driver";//����������
    static String dbUrl = "jdbc:mysql://";//ָ��Ҫ���ʵ����ݿ���
    public static Connection connectToDB(String hostName,
            String dbName,String user,String pwd) throws Exception{//Connection����������Դ ����Ψһ�ĻỰ
        Connection conn = null;
        String connStr = dbUrl+hostName+"/"+dbName
                +"?user="+user+"&password="+pwd;
        loadDriver();
        try{
            conn = DriverManager.getConnection(connStr);//DriverManager���еķ������Ǿ�̬��������������ʵ����ֱ���������ã������ݿ����������֮�佨�����ӡ�getConnection�õ���ǰ��Statement�����Connection����
        }catch(SQLException e){
            System.out.println("�������ݿ����");
            e.printStackTrace();
        }catch(Exception e){
            System.out.println("��������������");
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
            Class.forName(driverName).newInstance();//Class.forName���÷����ԭ��������newInstance()ʵ����������� 
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }      
    }
}
