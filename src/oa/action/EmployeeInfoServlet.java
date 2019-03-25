package oa.action;

import java.io.IOException;
import java.time.Year;

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
 * Servlet implementation class EmployeeInfoServlet
 */
@WebServlet("/EmployeeInfoServlet")
public class EmployeeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    EmployeeService employeeService=new EmployeeServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 HttpSession session=request.getSession();
		 Employee employee=(Employee) session.getAttribute("employee");
		String lanqiu=request.getParameter("lanqiu");
		String zuqiu=request.getParameter("zuqiu");
		String ppqiu=request.getParameter("ppqiu");
		String kandsh=request.getParameter("kandsh");
		String lvy=request.getParameter("lvy");
		String jiaoy=request.getParameter("jiaoy");
		String study=request.getParameter("study");
		String qita=request.getParameter("qita");
		String description=request.getParameter("description");		
		String ismarry=request.getParameter("ismarry");
		String role=request.getParameter("role");
		String ye=request.getParameter("year");
		int year=Integer.parseInt(ye);
		String mon=request.getParameter("month");
		int month=Integer.parseInt(mon);
		String da=request.getParameter("day");
		int day=Integer.parseInt(da);
		System.out.println("year="+year+",month="+month+",day="+day+",lanqiu="+lanqiu+",zuqiu="+zuqiu+",ppqiu="+ppqiu+",kandsh="+kandsh+",lvy="+lvy+",jaioy="+jiaoy+",study="+study+",qita="+qita+",description="+description+",ismarry="+ismarry+",email="+employee.getEmail()+",role"+role);
		 RequestDispatcher rd = null;
		 employee.setLanqiu(lanqiu);
		 employee.setZuqiu(zuqiu);
		 employee.setPpqiu(ppqiu);
		 employee.setDescription(description);
		 employee.setJiaoy(jiaoy);
		 employee.setLvy(lvy);
		 employee.setKandsh(kandsh);
		 employee.setStudy(study);
		 employee.setIsmarry(ismarry);
		 employee.setMonth(month);
		 employee.setYear(year);
		 employee.setDay(day);
		 employee.setQita(qita);
		 employee.setRole(role);
		 session.setAttribute("employee", employee);
		int result=employeeService.inproveInfo(description, year,month,day, employee.getEmail(), lanqiu,zuqiu,ppqiu,kandsh,lvy,jiaoy,study,qita,role,ismarry);
		if (result!=0) {
			rd=request.getRequestDispatcher("userInfo.jsp");
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
