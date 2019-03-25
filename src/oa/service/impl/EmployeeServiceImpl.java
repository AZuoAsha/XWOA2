package oa.service.impl;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import oa.common.DBTools;
import oa.domain.Employee;
import oa.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	/**
	 * �洢У�鲻ͨ��ʱ���û�������ʾ��Ϣ
	 */
	private Map<String,String> errors=new HashMap<String,String>();
	
	public Map<String,String> getErrors(){
		return errors;
	}
	Connection conn = null;//��ʾ���ض����ݿ������
    static String InsertSQL = "INSERT INTO employee(phoneNumber,loginName,password,fullName,email,qq,wx,id,repeatPwd,address,school,nation,gender,userhead)"
                            +" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    static String UpdateSQL = "UPDATE employee SET loginName=?,password=?,fullName=?,phoneNumber=?,email=?,privileges=?,description=?,repeatPwd=?"
                            +"  WHERE id=?";
	private List<Employee> eList;
	
	
	private static SqlSessionFactory factory=null;
	
	static{
		try {
			Reader reader=Resources.getResourceAsReader("conf.xml");
			factory=new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public int add(Employee employee){
		System.out.println("addִ����");
		SqlSession sqlSession=factory.openSession(true);
		EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
		System.out.println(mapper.getClass());
		int insert=mapper.insertEmployee(employee);
		System.out.println(insert);
		return insert;
	}
	@Override
	public int delete(String email,String password){
		SqlSession sqlSession=factory.openSession(true);
		EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
		int deleteEmployee=mapper.deleteEmployee(email,password);
		System.out.println(deleteEmployee);
		System.out.println("deleteִ����");
		return deleteEmployee;
		
	}
	
	@Override
	public int update2(Employee employee){
		SqlSession sqlSession=factory.openSession(true);
		EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
		int updateUser=mapper.updateEmployee(employee);
//		System.out.println(updateUser);
		return updateUser;
		
	}
	

	@Override
	public int update3(Employee employee) {
		SqlSession sqlSession=factory.openSession(true);
		EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
		int updateUser=mapper.updateEmployee2(employee);
//		System.out.println(updateUser);
		return updateUser;
	}
	
	@Override
	public int update4(Employee employee) {
		SqlSession sqlSession=factory.openSession(true);
		EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
		int updateUser=mapper.updateEmployee3(employee);
//		System.out.println(updateUser);
		
		System.out.println("update4ִ����");
		return updateUser;
	}
	
	@Override
	public int update5(Employee employee) {
		SqlSession sqlSession=factory.openSession(true);
		EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
		int updateUser=mapper.updateUserHead(employee);
//		System.out.println(updateUser);
		
		System.out.println("update5ִ����");
		return updateUser;
	}
	@Override
	public int updateNickName(Employee employee) {
		SqlSession sqlSession=factory.openSession(true);
		EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
		int updateUser=mapper.updateNick(employee);
//		System.out.println(updateUser);
		return updateUser;
	}
	@Override
	public Employee findOne1(String email){
		Employee employee=null;
		SqlSession sqlSession=factory.openSession(true);
		EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
		employee=mapper.getEmployee(email);
		System.out.println("findOneִ����");
		return employee; 
	}
	
	@Override
	public Employee findOneTo(String phoneNumber, String email) {
		Employee employee=null;
		SqlSession sqlSession=factory.openSession(true);
		EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
		employee=mapper.getEmployee2(phoneNumber,email);
		System.out.println("findOneToִ����");
		return employee; 
	}
	
	@Override
	public Employee findOne3(String email,String password,int num) {
		Employee employee=null;
		SqlSession sqlSession=factory.openSession(true);
		EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
		employee=mapper.getEmployee3(email,password,num);
		System.out.println("findOne3ִ����");
		return employee; 
	}
	

	@Override
	public Employee findOne5(String email,int isdelete) {
		Employee employee=null;
		SqlSession sqlSession=factory.openSession(true);
		EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
		employee=mapper.getEmployee5(email,isdelete);
		System.out.println("findOne5ִ����");
		return employee; 
	}
	
	@Override
	public Employee findOne4(String email,String password) {
		Employee employee=null;
		SqlSession sqlSession=factory.openSession(true);
		EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
		employee=mapper.getEmployee4(email,password);
		System.out.println("findOne4ִ����");
		return employee; 
	}
	
	@Override
	public List<Employee> findAll(){
		List<Employee> list=new ArrayList<Employee>();
		SqlSession sqlSession=factory.openSession(true);
		EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
		list=mapper.getAllEmployee();
		return list;
	}
    
 
    public int insertSQL(String phoneNumber,String loginName, String password, String fullName, String email,String qq,String wx, String repeatPwd,String addr,String school,String nation,String gender,String userhead){
    	 if(conn==null)conn = DBTools.connectToDB();
    	 PreparedStatement psmt = null;
    	 int result=-1;
    	 try {
    		 psmt = conn.prepareStatement(InsertSQL);
    		 psmt.setString(1, phoneNumber); 
    		 psmt.setString(2, loginName);
    		 psmt.setString(3, password);
    		 psmt.setString(4, fullName);
    		 psmt.setString(5, email);
    		 psmt.setString(6, qq);
    		 psmt.setString(7, wx);
    		 psmt.setString(8, null);
    		 psmt.setString(9, repeatPwd);
    		 psmt.setString(10, addr);
    		 psmt.setString(11, school);
    		 psmt.setString(12, nation);
    		 psmt.setString(13, gender);
    		 psmt.setString(14, userhead);
    		 result=psmt.executeUpdate();
    		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
		return result;
    	
    }
 
    
    @Override
    public Employee login(String email, String password) {
        String sql = "SELECT * FROM employee WHERE email='"
                +email+"' AND password='"
                +password+"'";
        List<Employee> eList = queryBySQL(sql);
        if(eList!=null&&eList.size()>0)return eList.get(0);
        return null;
    }
 
    @Override
    public List<Employee> queryBySQL(String sql) {
        if(conn==null)conn = DBTools.connectToDB();
        List<Employee> eList = new ArrayList<Employee>();
        Statement stmt = null;//��SQL��䷢�������ݿ�  �� ͬһʱ��ÿ��Statement����ֻ�ܴ�һ�� ResultSet����  Statement�Ǹ��ӿ�
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();//createStatement()�˷�������һ��Statement����SQL��䷢�͵����ݿ�
            rs = stmt.executeQuery(sql);//executeQueryִ�и�����SQL��䣬���ص���ResultSet���󣬲���sql��Ҫ���͸����ݿ��SQL���
            while(rs.next()){//ResultSet��ʾ���ݿ�����¼�������ݱ�ͨ��ͨ��ִ�в�ѯ���ݿ��������ɡ�ResultSet�������ָ��ǰ�����е�ָ�롣
            	//���ָ�뱻���ڵ�һ��֮ǰ��next()������ָ���ƶ�����һ�С��÷�����ResultSet������û����һ��ʱ����false�����Կ�����whileѭ����ʹ���������������¼
                Employee emp = new Employee();
                emp.setId(rs.getLong("id"));
                emp.setLoginName(rs.getString("loginName"));
                emp.setPassword(rs.getString("password"));
                emp.setPhoneNumber(rs.getString("phoneNumber"));
                emp.setEmail(rs.getString("email"));
                emp.setPrivileges(rs.getString("privileges"));
                emp.setDescription(rs.getString("description"));
                emp.setFullName(rs.getString("fullName"));
                emp.setQq(rs.getString("qq"));
                emp.setWx(rs.getString("wx"));
                emp.setRepeatPwd(rs.getString("repeatPwd"));
                emp.setAddress(rs.getString("address"));
                emp.setSchool(rs.getString("school"));
                emp.setNation(rs.getString("nation"));
                emp.setGender(rs.getString("gender"));
                emp.setYear(rs.getInt("year"));
                emp.setMonth(rs.getInt("month"));
                emp.setDay(rs.getInt("day"));
                emp.setDescription(rs.getString("description"));
                emp.setLanqiu(rs.getString("lanqiu"));
                emp.setZuqiu(rs.getString("zuqiu"));
                emp.setPpqiu(rs.getString("ppqiu"));
                emp.setKandsh(rs.getString("kandsh"));
                emp.setLvy(rs.getString("lvy"));
                emp.setJiaoy(rs.getString("jiaoy"));
                emp.setStudy(rs.getString("study"));
                emp.setQita(rs.getString("qita"));
                emp.setRole(rs.getString("role"));
                emp.setIsmarry(rs.getString("ismarry"));  
                emp.setUserhead(rs.getString("userhead"));
                emp.setLeaveWordsTime(rs.getString("leaveWordsTime"));
                emp.setLeaveWords(rs.getString("leaveWords"));
                eList.add(emp);
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        finally {
            try{
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();//�����ͷŵ�ǰStatement��������ݿ��JDBC��Դ
            }catch (SQLException sqlEx) { } // ignore
        }
        return eList;
    }
     
    private int excuteSQL(String sql,Employee e){
        int result = 0;
        if(sql==null||e==null)return 0;
        if(conn==null)conn = DBTools.connectToDB();
        PreparedStatement psmt = null;//PreparedStatement�ӿ���չ��Statement�ӿڣ����ڱ�ʾԤ����SQL���Ķ���SQL��䱻Ԥ���벢�Ҵ洢��PreparedStatement�����У�
        								//Ȼ�����ʹ�ô˶����Ч�Ķ��ִ�и����
        try{
            psmt = conn.prepareStatement(sql);
            if(sql.startsWith("DELETE")){
                psmt.setLong(1, e.getId());
            }
            else{
            	 psmt.setString(1, e.getPhoneNumber());
                psmt.setString(2, e.getLoginName());
                psmt.setString(3, e.getPassword());
                psmt.setString(4, e.getFullName());               
                psmt.setString(5, e.getEmail());
                psmt.setString(6, e.getPrivileges());
                psmt.setString(7, e.getDescription());
                psmt.setLong(8, e.getId());
                psmt.setString(9,e.getRepeatPwd());
               
            }
            result = psmt.executeUpdate(sql);//executeUpdate()ִ�и���SQL��䣬����������INSERT  UPDATE  DELETE�����߲������κ����ݵ�SQL��䡣
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                if(psmt!=null)psmt.close();
                if(conn!=null)conn.close();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
        }
        return result;
    }

	@Override
	public int register(String phoneNumber,String loginName, String password, String fullName, String email,String qq,String wx, String repeatPwd,String addr,String school,String nation,String gender,String userhead) {
		int isdelete=1;
		  
//	        �˴�Ӧ���ж����û��Ƿ��Ѵ���
	        EmployeeService employeeService=new EmployeeServiceImpl();
	        Employee rEmployees=employeeService.findOne1(email);
	        Employee employee=employeeService.findOne5(email, isdelete);
	        if ((rEmployees==null)||(rEmployees!=null&&employee!=null)) {
				int result=insertSQL(phoneNumber,loginName, password, fullName, email,qq,wx, repeatPwd,addr,school,nation,gender,userhead);
		        return result;
			}else {
				return -1;
			}
			
	}

	@Override
	public int forUpdatePersonal(String phoneNumber,String password,String email, String repeatPwd) {
		
	    EmployeeService employeeService=new EmployeeServiceImpl();
	    int result= employeeService.update2(new Employee(phoneNumber,password,email,repeatPwd));
//		System.out.println("result="+result);
//		System.out.println("updateִ����");
		return result;
		
	}
	@Override
	public int logOutEmployee(String password,String email) {
		// TODO Auto-generated method stub
		int isdelete=1;
		EmployeeService employeeService=new EmployeeServiceImpl();
		Employee result5=employeeService.findOne5(email, isdelete);
		Employee employee=employeeService.findOne1(email);
		if (employee==null||result5!=null) {
			return -2;
		}else {
			Employee employee2=employeeService.findOne4(password, email);
			System.out.println("employee2="+employee2);
			if (employee2==null) {
				return -1;
			}else {
				
				int results=employeeService.update3(new Employee(email, isdelete));
				System.out.println("logOutEmployeeִ����");
				System.out.println("results="+results);
				return results;
			}
				
			}
			
		}
		
		
	
	@Override
	public boolean comparePassword(String password, String repeatPwd) {
		boolean resultsPassword=password.equals(repeatPwd);
		
		if (resultsPassword==true) {
			return true;
		}else {
			return false;
		}
		
	}
	@Override
	public boolean isChinaPhoneLegal(String phoneNumber) {
		String regExp="^((13[0-9])|(15[^4])|(18[^1])|(17[0-8])|(147))\\d{8}$";
		Pattern pattern=Pattern.compile(regExp);
		Matcher matcher=pattern.matcher(phoneNumber);
		return matcher.matches();
	}
	@Override
	public Employee isDeleteEmployee(String email,String password,int num) {
		
		EmployeeService eService=new EmployeeServiceImpl();
		Employee result=eService.findOne3(email,password,num);
		return result;
	}
	@Override
	public boolean isQQCorrect(String qq) {
		// TODO Auto-generated method stub
		String regex="[1-9][0-9]{4,14}";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(qq);
		
		return matcher.matches();
	}
	@Override
	public int modifyNickName(String loginName, String email,String password) {
		EmployeeService eService=new EmployeeServiceImpl();
		int rEmployee=eService.updateNickName(new Employee(loginName,email,password));
		return rEmployee;
	}
	@Override
	public int inproveInfo(String description, int year,int month,int day, String email, String lanqiu,String zuqiu,String ppqiu,String kandsh,String lvy,String jiaoy,String study,String qita,String role,String ismarry) {
		EmployeeService employeeService=new EmployeeServiceImpl();
	    int result= employeeService.update4(new Employee(description,year,month,day,email,lanqiu,zuqiu,ppqiu,kandsh,lvy,jiaoy,study,qita,role,ismarry));
	    System.out.println("inproveInfoִ����");
		return result;
	}
	@Override
	public int updataUserHead(String email, String userhead) {
		EmployeeService eService=new EmployeeServiceImpl();
		int result=eService.update5(new Employee(email,userhead));
		return result;
	}
	@Override
	public int employeeLeaveWords(String email, String leaveWords, String leaveWordsTime,String loginName,String qq) {
		EmployeeService employeeService=new EmployeeServiceImpl();
		int result=employeeService.leaveWords(new Employee(email, leaveWords,leaveWordsTime,loginName,qq));
		return result;
	}
	@Override
	public int leaveWords(Employee employee) {
		SqlSession sqlSession=factory.openSession(true);
		EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
		int leaveMess=mapper.leaveMessage(employee);
		System.out.println(leaveMess);
		System.out.println("leaveWordsִ����");
		return leaveMess;
	}
	
	

}
