package oa.action;

import java.io.IOException;

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
 * Servlet implementation class ModefyNickNameServlet
 */
@WebServlet("/ModefyNickNameServlet")
public class ModefyNickNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    EmployeeService eService=new EmployeeServiceImpl();
    int isdelete=1;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModefyNickNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String modefyNickName=request.getParameter("loginName");
		HttpSession session=request.getSession();
		Employee employee=(Employee) session.getAttribute("employee");
		String email=employee.getEmail();
		String password=employee.getPassword();
		System.out.println("modefy÷¥––¡Àemail="+email);
		System.out.println("modefyNickName="+modefyNickName);
		Employee employee1=eService.findOne5(email, isdelete);
		System.out.println("employee1="+employee1);
		RequestDispatcher dispatcher=null;
		if (employee1==null) {
			int emp=eService.modifyNickName(modefyNickName,email,password);
			System.out.println("emp="+emp);
			if (emp!=0) {
				employee.setLoginName(modefyNickName);
				session.setAttribute("employee", employee);
				dispatcher=request.getRequestDispatcher("upload.jsp");
				dispatcher.forward(request, response);
				return;
			}else {
				dispatcher=request.getRequestDispatcher("modifyFail.html");
			}
			dispatcher.forward(request, response);
			return;
		}else {
			dispatcher=request.getRequestDispatcher("modifyFail.html");
		}
		dispatcher.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
