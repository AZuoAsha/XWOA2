package oa.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oa.domain.Employee;
import oa.service.EmployeeService;
import oa.service.impl.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeAction
 */
@WebServlet("/login.action")//ӳ��  ��form����actionһ��  -->�����ע��  ��ע��Ͳ���web.xml,��Ϊ���ȼ���web.xml��<servlet></servlet>  <servlet-mapping></servlet-mapping>
public class EmployeeAction extends HttpServlet {

	 private static final long serialVersionUID = 1L;//���л�
	    private EmployeeService es = new EmployeeServiceImpl();
	        
	    public EmployeeAction() {
	        super();
	    }
	 
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	request.setCharacterEncoding("utf-8");
	    	String mode = request.getParameter("mode");
	        if("login".equals(mode)){//�ַ���д��ǰ��
	            login(request,response);
	        }
	    }
	 
	    private void login(HttpServletRequest request, HttpServletResponse response) {
	        String email = request.getParameter("email");
	        String password =request.getParameter("password");
	        Employee employee=es.findOne3(email,password,1);
	        RequestDispatcher rd = null;
	        List<Employee> EmployeeAll = es.findAll();
	        System.out.println("employee="+employee);
	        if (employee==null) {
				
		        Employee emp = es.login(email,password);
		       
		        HttpSession session = request.getSession();
		        System.out.println("emp="+emp);
//		        System.out.println("session="+session);
		        if(emp!=null){
		            session.setAttribute("employee", emp);
		            session.setAttribute("EmployeeAll", EmployeeAll);
		            rd = request.getRequestDispatcher("upload.jsp");//��ת��½�ɹ�ҳ��  ��������ɣ�
		        }
		        else{
		            rd = request.getRequestDispatcher("loginFail.html");//�����½ʧ�ܾ���������������µ�½
		        }
		        try {
		            rd.forward(request, response);
		        } catch (ServletException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    } else {
				rd=request.getRequestDispatcher("loginFailto.html");
			}  
	        try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	 
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }
}
