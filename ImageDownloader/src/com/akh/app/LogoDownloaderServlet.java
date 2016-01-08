package com.akh.app;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.akh.bean.LogoInformation;

/**
 * @author akhilesh
 *
 */
public class LogoDownloaderServlet extends HttpServlet {
	private static List<LogoInformation> logoInfoList;
	private static final long serialVersionUID = 1L;

	public LogoDownloaderServlet() {
		super();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get method called.");
		try {
			logoInfoList = ImageInfoService.getImageInfoFromDb();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("logoInfoList", logoInfoList);
		System.out.println("===================================");
		System.out.println("logoInfoList:  " + logoInfoList);
		System.out.println("===================================");
		javax.servlet.RequestDispatcher dispatcher = request
				.getRequestDispatcher("logoInfoTable.jsp");
		dispatcher.forward(request, response);
	}

}
