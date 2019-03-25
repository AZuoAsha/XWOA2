package oa.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import oa.domain.Employee;

public interface EmployeeMapper {
	@Insert("insert into employee(loginName,password,fullName,email,qq,wx,repeatPwd) values(#{loginName},#{password},#{fullName},#{email},#{qq},#{wx},#{repeatPwd})")
	public int insertEmployee(Employee employee);

	@Delete("delete from employee where email=#{0} and password=#{1}")
	public int deleteEmployee(String email,String password);
	
	@Update("update employee set password=#{password},repeatPwd=#{repeatPwd} where email=#{email}")
	public int updateEmployee(Employee employee);

	@Update("update employee set loginName=#{loginName} where email=#{email} and password=#{password}")
	public int updateNick(Employee employee);
	
	@Select("select * from employee where email=#{email}")//当只传一个参数时，直接写参数名，传多个参数时，用0，1....表示 SELECT * FROM `user` WHERE LoginID=#{0} and LoginPwd=#{1}
	public Employee getEmployee(String email);

	@Select("select * from employee")
	public List<Employee> getAllEmployee();
	
	@Select("select * from employee where phoneNumber=#{0} and email=#{1}")
	public Employee getEmployee2(String phoneNumber, String email);

	@Select("select * from employee where email=#{0} and password=#{1} and isdelete=#{2}")
	public Employee getEmployee3(String email,String password,int isdelete);

	@Update("update employee set isdelete=#{isdelete} where email=#{email}")
	public int updateEmployee2(Employee employee);

	@Select("select * from employee where password=#{0} and email=#{1}")
	public Employee getEmployee4(String password, String email);

	@Select("select * from employee where email=#{0} and isdelete=#{1}")
	public Employee getEmployee5(String email, int isdelete);

	@Update("update employee set description=#{description},year=#{year},month=#{month},day=#{day},lanqiu=#{lanqiu},zuqiu=#{zuqiu},ppqiu=#{ppqiu},kandsh=#{kandsh},lvy=#{lvy},jiaoy=#{jiaoy},study=#{study},qita=#{qita},role=#{role},ismarry=#{ismarry} where email=#{email}")
	public int updateEmployee3(Employee employee);

	@Update("update employee set userhead=#{userhead} where email=#{email}")
	public int updateUserHead(Employee employee);

	@Update("update employee set leaveWords=#{leaveWords},leaveWordsTime=#{leaveWordsTime} where email=#{email}")
	public int leaveMessage(Employee employee);
}
