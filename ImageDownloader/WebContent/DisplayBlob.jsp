<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="com.akh.app.SimpleImageInfo"%>

<%       Blob image = null;
		Connection con = null;
		byte[] imgData = null ;
		Statement stmt = null;
		ResultSet rs = null;
		OutputStream o=null;
	
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con = DriverManager.getConnection(
					"DriverURL:DBName", "UserName",	"Password");
			 stmt = con.createStatement();
			String query3= "";
			System.out.println("before executing Query");
			 rs = stmt.executeQuery(query3);
			 if (rs.next()) {
					image = rs.getBlob(5);
					imgData = image.getBytes(1,(int)image.length());
					SimpleImageInfo imageInfo = new SimpleImageInfo(imgData);
					System.out.println("MIME type : " + imageInfo.getMimeType() + " width : " + imageInfo.getWidth() + " height : " + imageInfo.getHeight());
				} else {
					//out.println("Display Blob Example");
					//out.println("image not found for given id>");
					return;
				}

				// display the image
	         response.setContentType("image/gif");
	          o= response.getOutputStream();
	         o.write(imgData);
	         o.flush();
	         o.close();
	         out.clear(); // where out is a JspWriter

	         out = pageContext.pushBody();
			} catch (Exception e) {
				out.println("Unable To Display image");
				out.println("Image Display Error=" + e.getMessage());
				return;
			} finally {
				try {
					rs.close();
					stmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		%>
	
