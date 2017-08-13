package com.icehockey.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icehockey.entity.DegreeRecord;
import com.icehockey.entity.User;
import com.icehockey.service.DegreeRecordService;
import com.icehockey.service.UserService;

/**
 * Servlet implementation class DegreeServlet
 */
@WebServlet("/DegreeServlet")
public class DegreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DegreeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("------------------------degree.html--------------------------------------");
		PrintWriter writer = response.getWriter();
		UserService userService = new UserService();
		User user = null;
		Map<String, Object> map  = new HashMap<String, Object>();
		DegreeRecordService degreeRecordService=new DegreeRecordService();
		int userId = -1;
		//前端获取传入的data
		String userid = null;
		if (request.getParameter("userid") != null) {
			userid = request.getParameter("userid");
			userId = Integer.parseInt(userid);
		} else {
			map.put("userid", "null");
		}
		
		user = userService.queryUserByUserId(userId);
		if (user != null) {//插入成功
			System.out.println("找到当前用户" + user);
			List<DegreeRecord> degreeRecords=degreeRecordService.queryCoachDegreeByUserId(userId);
			if(degreeRecords.size()!=0){
				map.put("hasDegree", "yes");
				map.put("degreeRecords", degreeRecords);
			}else{
				map.put("hasDegree", "no");
				System.out.println("未找到等级记录");
			}
		
			//处理成功返回result=0	
			map.put("result", "0");
			map.put("userId", userId);
			map.put("userid", userId);
			System.out.println("map找到啦..." + map);
		} else {
			System.out.println("map未找到...");
			//第一次登陆返回result=1
			map.put("result", "-1");
		}
		//将转换得到的map转换为json并返回
		ObjectMapper objectMapper = new ObjectMapper();
		String resultJson = objectMapper.writeValueAsString(map);
		//此处直接返回JSON object对象，JSP可直接使用data.key
		resultJson = resultJson.replace("\"", "\\\"");
		resultJson = "\"" + resultJson + "\"";
		//此处返回JSON 字符串 string对象;JSP需要解析才能使用data.key
		System.out.println("resultJson ..." + resultJson);
		writer.print(resultJson);
		writer.flush();
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
