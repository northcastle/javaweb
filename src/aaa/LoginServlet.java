package aaa;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginServlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("request is coming ......");
		//1.��ȡ���������ķ���
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("1 -- >"+name+" : "+password);
		//2.��ȡ��ֵ�ķ���
		String [] instrestings = request.getParameterValues("instrestring");
		for(String instresting : instrestings){
			System.out.print("2 -- >"+instresting+",  ");
		}
		System.out.println();
		//3.��ȡ����������ֵķ���
		Enumeration<String> names =  request.getParameterNames();
		while (names.hasMoreElements()) {
			String namea = (String) names.nextElement();
			String value = request.getParameter(namea);
			System.out.println("3 -- >"+namea+"  : "+value);
		}
		//4.�Լ�ֵ�Ե���ʽ��ȡ�������Ͳ���ֵ
		Map<String, String[]> name_values =  request.getParameterMap();
		for (Map.Entry<String, String[]> entry : name_values.entrySet()) {
			System.out.println("4 -- >"+entry.getKey() +" : "+Arrays.asList(entry.getValue()));
		}
	}

}
