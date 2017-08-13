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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icehockey.entity.User;
import com.icehockey.service.UserService;

/**
 * Servlet implementation class MyInfoServlet
 */
@WebServlet("/MyInfoServlet")
public class MyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyInfoServlet() {
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
		System.out.println("---------myInfo.html----------");
		PrintWriter writer = response.getWriter();
		UserService userService = new UserService();
		User user = null;
		Map<String, Object> map = new HashMap<String, Object>();
		int userId = -1;
		String userid = "";
		// 前端获取传入的data
		if (request.getParameter("userid") != null) {
			userid = request.getParameter("userid");
			// 转化Id
			userId = Integer.parseInt(userid);
		} else {
			map.put("userid", "null");
		}

		// 按照userId检索数据库找到user
		user = userService.queryUserByUserId(userId);
		if (user != null) {// 插入成功
			System.out.println("找到当前用户" + user);

			// 处理成功返回result=0
			map.put("result", "0");
			map.put("userId", userId);
			map.put("userid", userid);
			map.put("sex", user.getSex());
			map.put("userName", user.getUserName());
			map.put("height", user.getHeight());
			map.put("weight", user.getWeight());
			map.put("roleName", user.getRole());
			map.put("country", user.getCountry());
			map.put("city", user.getCity());

			System.out.println("map找到啦..." + map);
		} else {
			System.out.println("map未找到...");
			map.put("result", "-1");
		}
		// 将转换得到的map转换为json并返回
		ObjectMapper objectMapper = new ObjectMapper();
		String resultJson = objectMapper.writeValueAsString(map);
		// System.out.println("resultJson ..." + resultJson);
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
