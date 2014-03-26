package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginservlet
 */
//@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		Cookie cookie= new Cookie("erkan","koca");
	    for(int i=1; i<100; i++) {
	        cookie = new Cookie("cookie-sayisi-",""+i);
	        response.addCookie(cookie);
	    }
	    cookie.setMaxAge(60*60*24*3);
	    response.addCookie(cookie);
	    int sayac = 0;
	    Cookie[] cookies = request.getCookies();
	    
	    
	    if (cookies == null) {
	        cookie = new Cookie("username", "admin");
	        response.addCookie(cookie);
	        cookie = new Cookie("Pass", "1234");
	        response.addCookie(cookie);
	        cookie = new Cookie("cookie-sayisi-",""+0);
	        response.addCookie(cookie);
	        PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet Mesaj</title>");
			out.println("<script>");
			out.println("function myFunction() {");
			out.println("alert('Ýlk cookie oluþtu');");
			out.println("}");
			out.println("</script>");
			out.println("</head>");
			out.println("<body onload='myFunction()'>");
			out.println("</body>");
			out.println("</html>");
        	response.sendRedirect("index");

	        
	        }
	    else {
	        String username = request.getParameter("username");
	        String Pass = request.getParameter("Pass");
	        for(Cookie c: cookies) {
	            if ((c.getName().equals("username")) &&  (c.getValue().equals(username))) {
	         
	                sayac=+1;
	                continue;
	            }
	             if ((c.getName().equals("Pass")) &&  (c.getValue().equals(Pass)) && ( sayac>0) ) {
	            	 PrintWriter out = response.getWriter();
	         		out.println("<html>");
	         		out.println("<head>");
	         		out.println("<title>Servlet Mesaj</title>");
	         		out.println("<script>");
	         		out.println("function myFunction() {");
	         		out.println("alert('Cookieler kullanýlýyor');");
	         		out.println("}");
	         		out.println("</script>");
	         		out.println("</head>");
	         		out.println("<body onload='myFunction()'>");
	         		out.println("</body>");
	         		out.println("</html>");	            
	            	response.sendRedirect("index");
	                }
	           //  if ((c.getName().equals("erkan")) &&  (c.getValue().equals("koca"))) {
	            
	            //	continue;
	            //}
	            
	            }
	           }
	        
	        }
	   
		
	}
	

