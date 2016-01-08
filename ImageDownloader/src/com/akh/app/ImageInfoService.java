package com.akh.app;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;

import com.akh.bean.LogoInformation;


/**
 * @author akhilesh
 *
 */
public class ImageInfoService {

	public static void main(String[] args) throws SQLException, IOException {
		getImageInfoFromDb();
	}

	public static List<LogoInformation> getImageInfoFromDb()
			throws SQLException, IOException {
		List<LogoInformation> logoInfoList = new ArrayList<LogoInformation>();

		String url = "JDBC URL";
		String dbName = "DB Name";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String userName = "uname";
		String password = "password";
		Blob img;
		byte[] imgData = null;

		try {
			System.out.println("Execution started............!");
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(url + dbName,
					userName, password);

			Statement stmt = conn.createStatement();
			String Query = "Query from DB";

			ResultSet rs = stmt.executeQuery(Query);

			while (rs.next()) {
				LogoInformation logoInfo = new LogoInformation();
				logoInfo.setImageId(rs.getString(1));
				logoInfo.setImageName(rs.getString(2));

				SimpleImageInfo imageInfo = findResolution(rs.getBlob(5));
				logoInfo.setMimeType(imageInfo.getMimeType());
				img = rs.getBlob(5);
				imgData = img.getBytes(1, (int) img.length());
				logoInfo.setImageBlog(imgData);
				logoInfo.setImageInfo(getByteArrayString(imgData));
				logoInfo.setWidth(imageInfo.getWidth());
				logoInfo.setHeight(imageInfo.getHeight());

				logoInfoList.add(logoInfo);
			}

		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		return logoInfoList;

	}

	private static String getByteArrayString(byte[] imgData) {
		return new Base64().encodeToString(imgData);
	}

	private static SimpleImageInfo findResolution(Blob blob)
			throws SQLException, IOException {
		byte[] imgData = blob.getBytes(1, (int) blob.length());
		SimpleImageInfo imageInfo = new SimpleImageInfo(imgData);
		return imageInfo;
	}
}
