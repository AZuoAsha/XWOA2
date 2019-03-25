package oa.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
 * Servlet implementation class LeaveWordsServlet
 */
@WebServlet("/LeaveWordsServlet")
public class LeaveWordsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    EmployeeService employeeService=new EmployeeServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveWordsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   request.setCharacterEncoding("utf-8");
		Date currDate = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String leaveWordsTime = sdf.format(currDate);
		String leaveWords=request.getParameter("leaveWords");
		HttpSession httpSession=request.getSession();
		Employee employee=(Employee) httpSession.getAttribute("employee");
		String loginName=employee.getLoginName();
		String qq=employee.getQq();
		String email=employee.getEmail();
		RequestDispatcher rDispatcher=null;
		System.out.println("loginName="+loginName+",qq="+qq+",leaveWordsTime="+leaveWordsTime+",leaveWords="+leaveWords+",email="+email);
		int leaveresult=employeeService.employeeLeaveWords(email, leaveWords, leaveWordsTime,loginName,qq);
		System.out.println("leaveresult="+leaveresult);
		if (leaveresult!=0) {
			rDispatcher=request.getRequestDispatcher("leavemessSucc.html");
		}else {
			rDispatcher=request.getRequestDispatcher("leavamessFail.html");
		}
		rDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
