package oa.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oa.service.EmployeeService;
import oa.service.impl.EmployeeServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private EmployeeService es = new EmployeeServiceImpl();
		private static final long serialVersionUID = 1L;
		
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public RegisterServlet() {
	        super();
	        
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                request.setCharacterEncoding("utf-8");
		        String mode = request.getParameter("mode");
		       /* String name=request.getParameter("exampleInputName");
		        System.out.println("name: "+name);*/
		        if("register".equals(mode)){//字符串写在前面
		            register(request,response);
		        }
		    }
		 
		    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    	String userhead="img/beijing/userHeader.jpg";
		    	String phoneNumber=request.getParameter("phoneNumber");
		        String loginName = request.getParameter("loginName");
		        String password = request.getParameter("password");
		        String fullName=request.getParameter("fullName");
		        String email=request.getParameter("email");
		        String qq=request.getParameter("qq");
		        String wx=request.getParameter("wx");
		        String repeatPwd=request.getParameter("confirmPassword");
		        String addren=request.getParameter("address");
		        String school=request.getParameter("school");
		        String nation=request.getParameter("nation");
		        String gender=request.getParameter("gender");
		        boolean result2=es.comparePassword(password, repeatPwd);
		       
		        RequestDispatcher rd = null;
//		         System.out.println("result2="+result2);
		        if (result2==true) {
					boolean resultQQ=es.isQQCorrect(qq);
					
			        if (resultQQ==true) {
			        	 
			        	 boolean result3=es.isChinaPhoneLegal(phoneNumber);
			        	 System.out.println("result3="+result3);
			        	 if (result3==true) {
			        		 
			        		 int result = es.register(phoneNumber,loginName,password,fullName,email,qq,wx,repeatPwd,addren,school,nation,gender,userhead);//函数的重载
	//		        		 System.out.println("result="+result);
			        		 if (result==-1) {
	//					    	   System.out.println("执行了");
						            rd = request.getRequestDispatcher("registerFail.html");//否则注册失败就跳到这儿来，重新注册
						        }else{
						            //session.setAttribute("employee", emp);
						            rd = request.getRequestDispatcher("WEB-INF/pages/register.jsp");//跳转注册成功页面  （请求分派）
						        }
						       
						        try {
						            rd.forward(request, response);
						        } catch (ServletException e) {
						            e.printStackTrace();
						        } catch (IOException e) {
						            e.printStackTrace();
						        }
						        
						}else {
							
							rd=request.getRequestDispatcher("phoneNumberError.html");
						}
			        	 rd.forward(request, response);
					}else {
						
			        	rd=request.getRequestDispatcher("QQError.html");
	//					System.out.println("passwordError.html跳转了");
					}
			        rd.forward(request, response);
		     }else {
				rd=request.getRequestDispatcher("passwordError.html");//提示两次输入的密码必须一致页面
			}
		        rd.forward(request, response);
		 }
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			doGet(request, response);
		}

	}