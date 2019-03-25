package oa.service.impl;

import java.util.List;

import org.junit.Test;
import oa.service.impl.EmployeeServiceImpl;
import oa.domain.Employee;
import oa.service.EmployeeService;

public class EmployeeDaoTest2 {
	EmployeeService eService=new EmployeeServiceImpl();

	@Test
	public void testAdd(){
		System.out.println("testadd÷¥––");
		Employee employee=new Employee((long) 5,"dgd","65465","fjdhs","5794444@qq.com","874");
		eService.add(employee);
	}
	@Test
	public int testDelete(){
		int results=eService.delete("168846@cc.com","65465");
		System.out.println("delete÷¥––¡À");
		return results;
		
	}
	@Test
	public void testUpdate(){
		Employee employee=new Employee("164654564","879486","1374018377@qq.com","879486");
		
		eService.update2(employee);
	}
	
	@Test
	public void testFindOne(){
		
		Employee employee=eService.findOne1("9799@qq.com");
		System.out.println(employee);
	}
	
	@Test
	public void testFindAll(){
		
		List<Employee> list=eService.findAll();
		System.out.println(list);
	}
}
