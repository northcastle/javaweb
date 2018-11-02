package aaa;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destory...");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		System.out.println("servletconfig...");
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		System.out.println("servletinfo...");
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init...");
		//ֱ��ͨ����ʼ�����ֻ�ȡֵ
		String username = arg0.getInitParameter("user");
		System.out.println("user : "+username);
		//�Ȼ�ȡ���������ֵļ��ϣ�Ȼ��Ҳ���Ի�ȡ����ֵ
	    Enumeration<String> names =  arg0.getInitParameterNames();
	    while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			System.out.println("name : "+name);
		}
	    
	    //ServletContext����Ľ��ܺ�ʹ��:�������servletconfig�����У����������ȡ��
	    ServletContext servletContext = arg0.getServletContext();
	    String drivervalue = servletContext.getInitParameter("driver");
	    System.out.println("drivervalue : "+drivervalue);
	    Enumeration<String> names2 = servletContext.getInitParameterNames();
	    while (names2.hasMoreElements()) {
			String name = (String) names2.nextElement();
			String value = servletContext.getInitParameter(name);
			System.out.println("-->"+name+"  : "+value);
		}
	    
	    //��ȡ��ǰwebӦ�õ�ĳ���ļ��ľ���·��
	    String realPath = servletContext.getRealPath("/realPath.jsp");
	    //E:\javaweb\javaweb\WebContent\realPath.jsp
	    System.out.println("realPath : "+realPath);
	    
	    //��ȡ��ǰwebӦ�õ�վ����
	    String contextPath = servletContext.getContextPath();
	    System.out.println(contextPath);
	    
	    //��ȡ������
	    try {
			ClassLoader classLoader = getClass().getClassLoader();
			InputStream iStream = classLoader.getResourceAsStream("jdbc.properties");
			System.out.println("1 "+iStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			 InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/classes/jdbc.properties");
			 System.out.println("2  "+inputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service...");

	}

	public HelloServlet() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("helloservlet's constrator...");
	}
	
	

}
