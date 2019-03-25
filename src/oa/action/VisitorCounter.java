package oa.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
public class VisitorCounter {
	//使用Properties
    private static Properties p=new Properties();
    
    public static void writeCount(String path,String count){  
        p.setProperty("count", count);
        try {
            p.store(new FileOutputStream(path), "");  //写入文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
    
    public static String readCount(String path) {
        String count="1";
        File f = new File(path);
        if (!f.exists()) {
            writeCount(path, "1");
        }
        try {
            p.load(new FileInputStream(path));
            count = p.getProperty("count");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
   }
}
