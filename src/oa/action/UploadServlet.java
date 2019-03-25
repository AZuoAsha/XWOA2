package oa.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import oa.domain.Employee;
import oa.service.EmployeeService;
import oa.service.impl.EmployeeServiceImpl;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    EmployeeService employeeService=new EmployeeServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
     
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String basePath =request.getContextPath()+"/";
	   System.out.println("basePath="+basePath);
	   String finalPath=basePath+"WebContent/img/beijing";
	   String finalPath2="";
	   File finalSavePath=new File(finalPath);
	   if (!finalSavePath.exists()) {
		   finalSavePath.mkdir();
		System.out.println("Ŀ¼������");
	   }
	  
	   String message="";
	   try{
		   DiskFileItemFactory factory=new DiskFileItemFactory();
		   
		   factory.setSizeThreshold(1024*100);
		   factory.setRepository(finalSavePath);
		   ServletFileUpload upload=new ServletFileUpload(factory);
		   upload.setProgressListener(new ProgressListener() {
			
			
			public void update(long pBytesRead, long pContentLength, int arg2) {
				// TODO Auto-generated method stub
				System.out.println("�ļ���СΪ�� "+pContentLength+",��ǰ�Ѵ���:"+pBytesRead);
			}
		});
		   
		   upload.setHeaderEncoding("UTF-8");
		   if (!ServletFileUpload.isMultipartContent(request)) {
			return;
		}
		   
		   upload.setFileSizeMax(1024*1024);
		   upload.setSizeMax(1024*1024*10);
		   List<FileItem> list=upload.parseRequest(request);
		   for (FileItem fileItem : list) {
			if (fileItem.isFormField()) {
				String name=fileItem.getFieldName();
				String value=fileItem.getString("UTF-8");
				System.out.println(name+"="+value);
			}else {
				String filename=fileItem.getName();
				System.out.println("filename="+filename);
				if (filename==null||filename.trim().equals("")) {
					continue;
				}
				
				filename=filename.substring(filename.lastIndexOf("\\")+1);
				String fileExtName=filename.substring(filename.lastIndexOf(".")+1);
				System.out.println("�ϴ����ļ�����չ���ǣ�"+fileExtName);
				
				InputStream inputStream=fileItem.getInputStream();
				String saveFilename=makeFileName(filename);
				System.out.println("saveFilename="+saveFilename);
				
				String realSavePath=makePath(saveFilename,finalPath);
				System.out.println("realSavePath="+realSavePath);
				
				String realSavePath2=makePath2(saveFilename);
				System.out.println("realSavePath2="+realSavePath2);
				
				FileOutputStream outputStream=new FileOutputStream(realSavePath+"/"+saveFilename);
				finalPath=realSavePath+"/"+saveFilename;
				System.out.println("finalPath:   "+finalPath);
				
				finalPath2="img/beijing"+realSavePath2+"/"+saveFilename;
			
				byte buffer[]=new byte[2048];
				int len=0;
				while ((len=inputStream.read(buffer))>0) {
					outputStream.write(buffer, 0, len);
				}
				inputStream.close();
				outputStream.close();
				message="�ļ��ϴ��ɹ�";
			}
		}
	   }catch (FileUploadBase.FileSizeLimitExceededException e) {
		// TODO: handle exception
		   e.printStackTrace();
		   request.setAttribute("message", "�����ļ��������ֵ");
		   request.getRequestDispatcher("/message.jsp").forward(request, response);
		   return;
	}catch (FileUploadBase.SizeLimitExceededException e) {
		// TODO: handle exception
		e.printStackTrace();
		request.setAttribute("message", "�ϴ����ļ����ܵĴ�С���������Ƶ����ֵ");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		return;
	}catch (Exception e) {
		// TODO: handle exception
		message="�ļ��ϴ�ʧ��";
		e.printStackTrace();
	}

	   request.setAttribute("message", message);
	   HttpSession session = request.getSession();
	   Employee employee=(Employee)session.getAttribute("employee");
	   System.out.println("emailFinal="+employee.getEmail()+",userhead="+finalPath2);
	   int result=employeeService.updataUserHead(employee.getEmail(),finalPath2);
	   employee.setUserhead(finalPath2);
	   session.setAttribute("employee", employee);
	   System.out.println("result="+result);
	   System.out.println("��ǰ�û��ǣ�   "+employee.getEmail());
	   request.getRequestDispatcher("/upload.jsp").forward(request, response);
	
	    }
	
	private String makePath2(String filename) {
		int hashcode=filename.hashCode();
		int dir1=hashcode&0xf;
		int dir2=(hashcode&0xf0)>>4;
		String dir="/"+dir1+"/"+dir2;
		System.out.println("hashcode&0xf"+dir1);
		System.out.println("dir:"+dir);
		return dir;
	}

	private String makePath(String filename, String savePath) {
		// TODO Auto-generated method stub
		int hashcode=filename.hashCode();
		int dir1=hashcode&0xf;
		int dir2=(hashcode&0xf0)>>4;
		String dir=savePath+"/"+dir1+"/"+dir2;
		File file=new File(dir);
		if (!file.exists()) {
			file.mkdirs();
		}
		System.out.println("hashcode&0xf"+dir1);
		System.out.println("dir:"+dir);
		return dir;
	}

	
	private String makeFileName(String filename) {
		System.out.println("UUIDִ����filename="+filename);
		return UUID.randomUUID().toString()+"_"+filename;
		
	}
	
	    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
