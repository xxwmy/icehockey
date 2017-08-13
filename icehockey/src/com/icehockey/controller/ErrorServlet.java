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
import com.icehockey.service.ErrorService;

/**
 * Servlet implementation class ErrorServlet
 */
@WebServlet("/ErrorServlet")
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ErrorServlet() {
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
		System.out.println("-------error.html----------------");
		PrintWriter writer = response.getWriter();
		ErrorService errorService = new ErrorService();
		Map<String, Object> map = new HashMap<String, Object>();

		String errorName = null;
		if (request.getParameter("errorCheck") != null) {
			errorName = request.getParameter("errorCheck");
		} else {
			map.put("errorCheck", "null");
		}

		String errorDesc = null;
		if (request.getParameter("errorDesc") != null) {
			errorDesc = request.getParameter("errorDesc");
		} else {
			map.put("errorDesc", "null");
		}
		String contactInfo = null;
		if (request.getParameter("errorPhoneEmain") != null) {
			contactInfo = request.getParameter("errorPhoneEmain");
		} else {
			map.put("errorPhoneEmain", "null");
		}
		boolean t = errorService.insertError(errorName, errorDesc, contactInfo);
		if (t) {// 插入成功
			map.put("result", "0");
			System.out.println("map找到啦..." + map);
		} else {
			System.out.println("map未找到...");
			// 第一次登陆返回result=1
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
