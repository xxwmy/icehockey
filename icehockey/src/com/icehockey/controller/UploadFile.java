package com.icehockey.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadFile
 */
@WebServlet("/UploadFile.do")
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//借助工具解析commons-fileupload smartupload
		//判断传递的是否事文件类型
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if(isMultipart)
		{
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// Configure a repository (to ensure a secure temp location is used)
			ServletContext servletContext = this.getServletConfig().getServletContext();
			//获取临时文件夹
			File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			factory.setRepository(repository);

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
      
			//解决中文参数乱码
			upload.setHeaderEncoding("utf-8");
			// 解析request获取上传的参数
			try {
				List<FileItem> items = upload.parseRequest(request);
				
				//处理参数
				for(FileItem item:items)
				{
					if(item.isFormField())
					{
						System.out.println(item.getFieldName());
						System.out.println(item.getString("utf-8"));
					}
					else
					{
						System.out.println(item.getFieldName());
						System.out.println(item.getName());
						System.out.println(item.getContentType());
						System.out.println(item.getSize());

						//写入文件
						String rootPath=servletContext.getRealPath("//");
						//System.out.println(rootPath);
						String savePath=rootPath+File.separator+"upload";
						File fileSaveFolder=new File(savePath);
						if(!fileSaveFolder.exists())
						{
							fileSaveFolder.mkdir();
						}
						//完整的存储文件名
						String saveFileName=savePath+File.separator+item.getName();
						System.out.println(saveFileName);
						//存储文件
					    File uploadedFile = new File(saveFileName);
					    item.write(uploadedFile);
					}
				}
				
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
