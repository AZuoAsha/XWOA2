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

//������ArticleService��ʵ����
public class ArticleServiceImpl implements ArticleService {

	private java.sql.Connection conn = null;
    // ���ǹ��⽫Insert�����article���id�ֶη��������Ϊ�˺�update���һ�£���������䶼���޸����ݱ�
    // ������ͬһ������
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
        if(findOne(article.getId())!=null){ //˵�����ݿ����Ѿ��������¼������ִ�и��²���
            sql = UpdateSQL;
        }
        else sql = InsertSQL; //����ִ�����Ӳ���
        return excuteSQL(sql,article);
    }
  
    @Override
    public List<Article> findAll() {
        String sql = "SELECT FROM article";       
        return queryBySQL(sql);
    }
    //���洴������˽�к������ֱ���queryBySQL��excuteSQL
    //���ݿ���ɾ�Ĳ�Ĳ������Է�Ϊ���࣬һ���ǲ�ѯ��һ����ִ���޸ģ�������ɾ���ģ���Ҳ����������������
    private List<Article> queryBySQL(String sql){
        if(conn==null)conn=DBTools.connectToDB();
        Statement st = null;
        ResultSet rs = null;
        List<Article> aList = new ArrayList<Article>();
        try{
            st = conn.createStatement();//ʵ����Statement����
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
            pst = conn.prepareStatement(sql);//PreparedStatementʵ�������Ѿ������SQL���
            if(sql.startsWith("DELETE")){//�����ɾ������
                pst.setLong(1, a.getId());
            }
            else{//���򣬾��ǲ������²���
                //ע�⣬���������1��2��3...Ӧ�������ʺ�����һ�£�����id�����һ���ʺŵ�λ��
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