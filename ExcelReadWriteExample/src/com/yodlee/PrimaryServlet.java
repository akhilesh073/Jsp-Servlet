package com.yodlee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import au.com.bytecode.opencsv.*;

/**
 * Servlet implementation class PrimaryServlet
 */
/**
 * @author amohapat
 *
 */
/**
 * Read excel from input and display in UI using Apache POI
 *
 */
@WebServlet("/POI")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
// 50MB
public class PrimaryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrimaryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String appPath = request.getServletContext().getRealPath("");
		String filePath = "";
		for (Part part : request.getParts()) {
			String fileName = extractFileName(part);
			filePath = appPath + File.separator + fileName;
			part.write(filePath);
			System.out.println("Wrote file to " + appPath + File.separator
					+ fileName);
		}
		CSVReader reader = new CSVReader(new FileReader(filePath));
		String[] nextLine;
		ArrayList<DataBean> data = new ArrayList<DataBean>();
		while ((nextLine = reader.readNext()) != null) {
			// nextLine[] is an array of values from the line
			System.out.println(nextLine[0] + nextLine[1]);
			DataBean bean = new DataBean();
			bean.setUsername(nextLine[0]);
			bean.setPassword(nextLine[1]);
			data.add(bean);
		}
		// Remove Username,password header
		data.remove(0);
		request.setAttribute("data", data);
		request.getRequestDispatcher("output.jsp").forward(request, response);
	}

	private static String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		System.out.println("contentDisp: " + contentDisp);
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

}
