package oa.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oa.domain.Employee;
import oa.service.EmployeeService;
import oa.service.impl.EmployeeServiceImpl;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/ModifyServlet")
public class ModifyServlet extends HttpServlet {
	EmployeeService eService=new EmployeeServiceImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("utf-8");
		forUpdatePersonal(request,response);
	}

	private void forUpdatePersonal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String phoneNumber=request.getParameter("phoneNumber");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String repeatPwd=request.getParameter("confirmPassword");
		RequestDispatcher rd = null;
	   Employee employee=eService.findOneTo(phoneNumber, email);
	   System.out.println("employee="+employee);
	   int isdelete=1;
	   Employee employee2=eService.findOne5(email, isdelete);
	   System.out.println("employee2="+employee2);
	   if (employee!=null&&employee2==null) {
		
		 boolean result2=eService.comparePassword(password, repeatPwd);
		 System.out.println("result2="+result2);
		if (result2==true) {
				
			int emp = eService.forUpdatePersonal(phoneNumber,password,email,repeatPwd);
			System.out.println("emp="+emp);
		        if(emp!=0){
		            
		            rd = request.getRequestDispatcher("WEB-INF/success.jsp");
		        }
		        else{
		            rd = request.getRequestDispatcher("login_bg.html");
		        }
		        try {
		            rd.forward(request, response);
		        } catch (ServletException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		  
		}else {
			rd=request.getRequestDispatcher("passwordError.html");
			
		}
		rd.forward(request, response);
	   }else {
		rd=request.getRequestDispatcher("noExistEmployee.html");
	}
	   rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
