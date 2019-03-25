package oa.domain;

import java.util.Date;

public class Employee {

	Long id;
    String loginName;
    String password;
    String gender;
    String phoneNumber;
    String email;
    String title;
    String techTitle;
    String techTitleCode;
    String privileges;
    String description;
    String registerName;
    String fullName;
    String repeatPwd;
    int isdelete;
    String qq;
    String wx;
    String address;
    String school;
    String nation;
    int year;
    int month;
    int day;
    String ismarry;
    String lanqiu;
    String zuqiu;
    String ppqiu;
    String study;
    String qita;
    String kandsh;
    String jiaoy;
    String lvy;
    String role;
    String userhead;
    String leaveWords;
    String leaveWordsTime;
    /**
	 * @param id
	 * @param loginName
	 * @param password
	 * @param gender
	 * @param phoneNumber
	 * @param email
	 * @param title
	 * @param techTitle
	 * @param techTitleCode
	 * @param privileges
	 * @param description
	 * @param registerName
	 * @param fullName
	 * @param repeatPwd
	 */
	public Employee(String phoneNumber,String password,String email, String repeatPwd) {
		super();
	
		this.phoneNumber=phoneNumber;
		this.password = password;
		this.email = email;
		this.repeatPwd = repeatPwd;
	}
	public Employee(Long id,String loginName, String password,String fullName,String email, String repeatPwd) {
		super();
		this.id=id;
		this.loginName = loginName;
		this.password = password;
		this.email = email;
		this.fullName = fullName;
		this.repeatPwd = repeatPwd;
	}
	
	/**
	 * 
	 */
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String email, int isdelete) {
		// TODO Auto-generated constructor stub
		this.email=email;
		this.isdelete=isdelete;
	}
	
	public Employee(String email, String userhead) {
		this.email=email;
		this.userhead=userhead;
	}
	
	
	public Employee(String description, int year, int month, int day, String email, String lanqiu,String zuqiu,String ppqiu,String kandsh,String lvy,String jiaoy,String study,String qita,String role,
			String ismarry) {
		this.day=day;
		this.email=email;
		this.lanqiu=lanqiu;
		this.ismarry=ismarry;
		this.description=description;
		this.jiaoy=jiaoy;
		this.lanqiu=lanqiu;
		this.lvy=lvy;
		this.ppqiu=ppqiu;
		this.zuqiu=zuqiu;
		this.qita=qita;
		this.study=study;
		this.month=month;
		this.year=year;
		this.kandsh=kandsh;
		this.role=role;
	}
	public Employee(String loginName, String email, String password) {
		this.loginName=loginName;
		this.email=email;
		this.password=password;
	}
	
	public Employee(String email, String leaveWords, String leaveWordsTime,String loginName,String qq) {
		super();
		this.email = email;
		this.leaveWords = leaveWords;
		this.leaveWordsTime = leaveWordsTime;
		this.loginName=loginName;
		this.qq=qq;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getLeaveWordsTime() {
		return leaveWordsTime;
	}
	public void setLeaveWordsTime(String leaveWordsTime) {
		this.leaveWordsTime = leaveWordsTime;
	}
	public String getLeaveWords() {
		return leaveWords;
	}
	public void setLeaveWords(String leaveWords) {
		this.leaveWords = leaveWords;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegisterName() {
		return registerName;
	}
	public void setRegisterName(String registerName) {
		this.registerName = registerName;
	}
	public String getRepeatPwd() {
		return repeatPwd;
	}
	public void setRepeatPwd(String repeatPwd) {
		this.repeatPwd = repeatPwd;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTechTitle() {
		return techTitle;
	}
	public void setTechTitle(String techTitle) {
		this.techTitle = techTitle;
	}
	public String getTechTitleCode() {
		return techTitleCode;
	}
	public void setTechTitleCode(String techTitleCode) {
		this.techTitleCode = techTitleCode;
	}
	public String getPrivileges() {
		return privileges;
	}
	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWx() {
		return wx;
	}
	public void setWx(String wx) {
		this.wx = wx;
	}
	
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getIsmarry() {
		return ismarry;
	}
	public void setIsmarry(String ismarry) {
		this.ismarry = ismarry;
	}
	public String getLanqiu() {
		return lanqiu;
	}
	public void setLanqiu(String lanqiu) {
		this.lanqiu = lanqiu;
	}
	public String getZuqiu() {
		return zuqiu;
	}
	public void setZuqiu(String zuqiu) {
		this.zuqiu = zuqiu;
	}
	public String getPpqiu() {
		return ppqiu;
	}
	public void setPpqiu(String ppqiu) {
		this.ppqiu = ppqiu;
	}
	public String getStudy() {
		return study;
	}
	public void setStudy(String study) {
		this.study = study;
	}
	public String getQita() {
		return qita;
	}
	public void setQita(String qita) {
		this.qita = qita;
	}
	public String getKandsh() {
		return kandsh;
	}
	public void setKandsh(String kandsh) {
		this.kandsh = kandsh;
	}
	public String getJiaoy() {
		return jiaoy;
	}
	public void setJiaoy(String jiaoy) {
		this.jiaoy = jiaoy;
	}
	public String getLvy() {
		return lvy;
	}
	public void setLvy(String lvy) {
		this.lvy = lvy;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserhead() {
		return userhead;
	}
	public void setUserhead(String userhead) {
		this.userhead = userhead;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", leaveWordsTime=" + leaveWordsTime + ", leaveWords=" + leaveWords + ", loginName=" + loginName + ", password=" + password + ", gender=" + gender
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", description=" + description + ", fullName="
				+ fullName + ", repeatPwd=" + repeatPwd + ", isdelete=" + isdelete + ", qq=" + qq + ", wx=" + wx
				+ ", address=" + address + ", school=" + school + ", nation=" + nation + ", year=" + year + ", month="
				+ month + ", day=" + day + ", ismarry=" + ismarry + ", lanqiu=" + lanqiu + ", zuqiu=" + zuqiu
				+ ", ppqiu=" + ppqiu + ", study=" + study + ", qita=" + qita + ", kandsh=" + kandsh + ", jiaoy=" + jiaoy
				+ ", lvy=" + lvy + ", role=" + role + ", userhead=" + userhead + "]";
	}
	
}
