package com.icehockey.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class ImageUploadServlet
 */
@WebServlet("/ImageUploadServlet")
public class ImageUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (isMultipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// Configure a repository (to ensure a secure temp location is used)
			ServletContext servletContext = this.getServletConfig().getServletContext();

			File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			factory.setRepository(repository);

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("utf-8");

			try {
				List<FileItem> items = upload.parseRequest(request);

				for (FileItem item : items) {
					if (item.isFormField()) {
						System.out.println(item.getFieldName());
						System.out.println(item.getString("utf-8"));
					} else {
						System.out.println(item.getFieldName());
						System.out.println(item.getName());
						System.out.println(item.getContentType());
						System.out.println(item.getSize());

//						String rootPath = servletContext.getRealPath("//");
						//System.out.println(rootPath);
						//String savePath = rootPath + File.separator + "upload";
						String savePath="C:"+File.separator+"upload";
						File fileSaveFolder = new File(savePath);
						if (!fileSaveFolder.exists()) {
							fileSaveFolder.mkdir();
						}
						File tempfile = new File(item.getName());
						String saveFileName = savePath + File.separator + tempfile.getName();
						System.out.println(saveFileName);

						File uploadedFile = new File(saveFileName);
						item.write(uploadedFile);
						saveFileName = saveFileName.replace("\\", "\\\\");
						System.out.println(saveFileName);

						response.setContentType("text/html;charset=utf-8");
						PrintWriter out1 = response.getWriter();

						//out1.print("<script>parent.callback('//upload//"+tempfile.getName()+"');</script>");
						out1.print("<script>parent.callback('" + saveFileName + "');</script>");

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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
