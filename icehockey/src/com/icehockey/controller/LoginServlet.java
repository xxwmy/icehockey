package com.icehockey.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icehockey.entity.User;
import com.icehockey.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("-----------------login.html----------");
		String loadTipStr = "";
		HttpSession session = request.getSession();
		if (session.isNew()) {
			// response.sendRedirect("noright.jsp");
			loadTipStr = "第一次访问";
		} else {
			// response.sendRedirect(tempOurl);
			int times = 0;
			if (session.getAttribute("times") != null) {
				times = 1 + Integer.parseInt(session.getAttribute("times")
						.toString());
			}
			session.setAttribute("times", times);
			loadTipStr = "再次访问" + times;
		}
		System.out.println("aaaaaaaaaaaaaa" + loadTipStr);
		PrintWriter writer = response.getWriter();
		UserService userService = new UserService();
		User user = null;
		Map<String, Object> map = new HashMap<String, Object>();
		// 遍历map得到前端传入的值
		String telephone = "";
		String password = "";
		if (request.getParameter("phoneNumber") != null) {
			telephone = request.getParameter("phoneNumber");
		} else {
			map.put("telephone", "null");
		}
		if (request.getParameter("verificationCode") != null) {
			password = request.getParameter("verificationCode");
		} else {
			map.put("verificationCode", "null");
		}
		// 登录函数
		user = userService.loginByTelepone(telephone, password);
		if (user != null) {// 登录成功
			if (user.getUserId() != -1) {
				System.out.println("找到当前用户" + user);

				// 登录成功返回result=0；登陆失败返回result=-1，第一次登陆返回result=isFirst
				if (user.getPlay() == null) {
					map.put("result", "isFirst");
				} else {
					map.put("result", "0");
				}
				map.put("userid", user.getUserId());
				map.put("userId", user.getUserId());
				map.put("telephone", telephone);
				map.put("password", password);
				System.out.println("map找到啦..." + map);
			} else {
				map.put("result", "-2");// 密码错误
			}
		} else {
			System.out.println("map未找到...");
			map.put("result", "-1");
		}
		// 将转换得到的map转换为json并返回
		ObjectMapper objectMapper = new ObjectMapper();
		String resultJson = objectMapper.writeValueAsString(map);
		// 此处直接返回JSON object对象，JSP可直接使用data.key
		resultJson = resultJson.replace("\"", "\\\"");
		resultJson = "\"" + resultJson + "\"";
		// 此处返回JSON 字符串 string对象;JSP需要解析才能使用data.key
		System.out.println("resultJson ..." + resultJson);
		writer.print(resultJson);
		writer.flush();
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
