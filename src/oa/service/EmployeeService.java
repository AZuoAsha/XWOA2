package oa.service;

import java.util.Date;
import java.util.List;

import oa.domain.Employee;

public interface EmployeeService {

	Employee findOne1(String email);
	Employee findOne5(String email,int isdelete);
	Employee findOneTo(String phoneNumber,String email);
	Employee findOne3(String email, String password, int num);
    int add(Employee employee);
    List<Employee> findAll();
    List<Employee> queryBySQL(String sql);
    Employee login(String email, String password);
	int register( String phoneNumber,String loginName, String password, String fullName, String email,String qq,String wx,String repeatPwd,String addr,String school,String nation,String gender,String userhead);
	int forUpdatePersonal( String phoneNumber,String password, String email, String repeatPwd);
	int update2(Employee employee);
	int delete(String email,String password);
	int update3(Employee employee);
	int logOutEmployee(String email, String password);
	boolean comparePassword(String password,String repeatPwd);
	boolean isChinaPhoneLegal(String phoneNumber);
	Employee isDeleteEmployee(String email,String password,int num);
	Employee findOne4(String password, String email);
	boolean isQQCorrect(String qq);
	int modifyNickName(String loginName, String email,String password);
	int updateNickName(Employee employee);
	int inproveInfo(String description, int year,int month,int day, String email, String lanqiu,String zuqiu,String ppqiu,String kandsh,String lvy,String jiaoy,String study,String qita,String roel,String ismarry);
	int update4(Employee employee);
	int updataUserHead(String email, String userhead);
	int update5(Employee employee);
	int employeeLeaveWords(String email,String leaveWords,String leaveWordsTime, String loginName, String qq);
	int leaveWords(Employee employee);
}
