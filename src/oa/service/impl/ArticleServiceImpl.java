package oa.service.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oa.common.DBTools;
import oa.domain.Article;
import oa.service.ArticleService;

//该类是ArticleService的实现类
public class ArticleServiceImpl implements ArticleService {

	private java.sql.Connection conn = null;
    // 我们故意将Insert语句中article表的id字段放在最后，是为了和update语句一致，这两个语句都是修改数据表，
    // 可以用同一个函数
    private static String InsertSQL = "INSERT INTO article(title,type,content,author,pubDate,note,id) "+
                    " values(?,?,?,?,?,?,?)";
    private static String DelSQL = "DELETE FROM article WHERE id=?";
    private static String UpdateSQL = "UPDATE article SET title=?,type=?,content=?author=?,puvDate=?,note=?"
                    +" WHERE id=?";
      
    @Override
    public Article findOne(Long id) {
        String sql = "SELECT FROM article WHERE id="+id;
        List<Article> aList = queryBySQL(sql);
        if(aList!=null&&aList.size()>0)return aList.get(0);
        return null;
    }
      
    @Override
    public long count() {
        return findAll().size();
    }
  
    @Override
    public int delete(Long id) {
        return excuteSQL(DelSQL,findOne(id));
    }
  
    @Override
    public int save(Article article) {
        String sql = null;
        if(article==null)return 0;
        if(findOne(article.getId())!=null){ //说明数据库中已经有这个记录，所以执行更新操作
            sql = UpdateSQL;
        }
        else sql = InsertSQL; //否则执行增加操作
        return excuteSQL(sql,article);
    }
  
    @Override
    public List<Article> findAll() {
        String sql = "SELECT FROM article";       
        return queryBySQL(sql);
    }
    //下面创建两个私有函数，分别是queryBySQL和excuteSQL
    //数据库增删改查的操作可以分为两类，一类是查询，一类是执行修改（含增、删、改），也就是这两个方法。
    private List<Article> queryBySQL(String sql){
        if(conn==null)conn=DBTools.connectToDB();
        Statement st = null;
        ResultSet rs = null;
        List<Article> aList = new ArrayList<Article>();
        try{
            st = conn.createStatement();//实例化Statement对象
            rs = st.executeQuery(sql);
            while(rs.next()){
                Article a = new Article();
                a.setId(rs.getLong("id"));
                a.setTitle(rs.getString("title"));
                a.setType(rs.getString("type"));
                a.setContent(rs.getString("content"));
                a.setAuthor(rs.getString("author"));
                a.setPubDate(rs.getDate("pubDate"));
                a.setNote(rs.getString("note"));
                aList.add(a);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                if(rs!=null)rs.close();
                if(st!=null)st.close();
                if(conn!=null)conn.close();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
        }
        return aList;
    }
    private int excuteSQL(String sql,Article a){
        int result = 0;
        if(a==null||sql==null) return 0;
        if(conn==null)conn=DBTools.connectToDB();
        PreparedStatement pst = null;
        try{
            pst = conn.prepareStatement(sql);//PreparedStatement实例包含已经编译的SQL语句
            if(sql.startsWith("DELETE")){//如果是删除操作
                pst.setLong(1, a.getId());
            }
            else{//否则，就是插入或更新操作
                //注意，下面的序数1，2，3...应与语句的问号序数一致，所以id是最后一个问号的位置
                pst.setString(1, a.getTitle());
                pst.setString(2, a.getType());
                pst.setString(3, a.getContent());
                pst.setString(4,a.getAuthor());
                pst.setDate(5, a.getPubDate());
                pst.setString(6, a.getNote());
                pst.setLong(7, a.getId());
            }
            result = pst.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(pst!=null)pst.close();
                if(conn!=null)conn.close();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
        }
        return result;
    }
	
}