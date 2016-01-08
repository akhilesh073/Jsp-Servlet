<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style>
body {
	font-family: Agenda-Light, sans-serif;
}

table {
	width: 100%;
	border-collapse: collapse;
}

th {
	background: orange;
	color: black;
	font-weight: bold;
}

@media screen and (min-width: 0px) and (max-width: 900px) {
	.col-3 {
		display: none !important;
	}
}

@media screen and (min-width: 0px) and (max-width: 500px) {
	.col-2 {
		display: none !important;
	}
}

\td, th {
	padding: 6px;
	border: 1px solid #ccc;
	text-align: center;
}

img {
	width: 100%;
}
</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
</head>
<body>
	<table border="1" bordercolor="black" width="100%">
		<thead>
			<tr>
				<th class="col-1">Image_ID</th>
				<th class="col-1">Image_NAME</th>
				<th class="col-4">Image</th>
				<th class="col-3">MIME_TYPE</th>
				<th class="col-2">WIDTH (pxs)</th>
				<th class="col-2">HEIGHT (pxs)</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="col-1">5</td>
				<td class="col-1">TestImage</td>
				<td class="col-4"><img src="images/test.png"></td>
				<td class="col-3">image/png</td>
				<td class="col-2">62</td>
				<td class="col-2">62</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
