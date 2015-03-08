package com.unicss.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 7786896411151184547L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/plain; charset=UTF-8");
		String verifyCode = req.getParameter("checkCode");
		String picCode = (String)req.getSession().getAttribute("picCode");
		PrintWriter out = resp.getWriter();
		if(verifyCode.equals(picCode)){
			out.println("验证码正确");
		}else{
			out.println("验证码错误");
		}
		out.flush();
		out.close();
	}
}
