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
		//直接通过初始化名字获取值
		String username = arg0.getInitParameter("user");
		System.out.println("user : "+username);
		//先获取参数的名字的集合，然后也可以获取参数值
	    Enumeration<String> names =  arg0.getInitParameterNames();
	    while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			System.out.println("name : "+name);
		}
	    
	    //ServletContext对象的介绍和使用:其包含在servletconfig对象中，可以由其获取到
	    ServletContext servletContext = arg0.getServletContext();
	    String drivervalue = servletContext.getInitParameter("driver");
	    System.out.println("drivervalue : "+drivervalue);
	    Enumeration<String> names2 = servletContext.getInitParameterNames();
	    while (names2.hasMoreElements()) {
			String name = (String) names2.nextElement();
			String value = servletContext.getInitParameter(name);
			System.out.println("-->"+name+"  : "+value);
		}
	    
	    //获取当前web应用的某个文件的绝对路径
	    String realPath = servletContext.getRealPath("/realPath.jsp");
	    //E:\javaweb\javaweb\WebContent\realPath.jsp
	    System.out.println("realPath : "+realPath);
	    
	    //获取当前web应用的站点名
	    String contextPath = servletContext.getContextPath();
	    System.out.println(contextPath);
	    
	    //获取输入流
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
